package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class EventViewModel extends AndroidViewModel {

    private EventRepository repository;
    private LiveData<List<Event>> allEvents;

    public EventViewModel(Application application) {
        super(application);

        repository = new EventRepository(application);
        allEvents = repository.getEvents();
    }

    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }

    public void insert(Event event) {
        repository.insert(event);
    }

}
