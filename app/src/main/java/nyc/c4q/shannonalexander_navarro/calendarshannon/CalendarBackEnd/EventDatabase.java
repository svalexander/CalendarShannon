package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.*;
import android.arch.persistence.room.Database;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

@Database(entities = {Event.class}, version = 1, exportSchema = false)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();
    private static EventDatabase INSTANCE;

    public static EventDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EventDatabase.class, "event_database")
                            .addCallback(roomCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();

        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final EventDao eventDao;

        PopulateDbAsync(EventDatabase db) {
            eventDao = db.eventDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            eventDao.deleteAll();
            return null;
        }
    }

}
