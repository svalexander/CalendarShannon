package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class EventRepository {
    private EventDao eventDao;
    private LiveData<List<Event>> events;

    public EventRepository(Application application) {
        EventDatabase db = EventDatabase.getDatabase(application);
        eventDao = db.eventDao();
        events = eventDao.getAllEvents();
    }

    LiveData<List<Event>> getEvents() {
        return events;
    }

    public void insert(Event event) {
        new insertAsyncTask(eventDao).execute(event);
    }

    private static class insertAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao daoAsyncTask;

        insertAsyncTask(EventDao dao) {
            daoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(final Event... params) {
            daoAsyncTask.update(params[0]);
            return null;
        }
    }
}
