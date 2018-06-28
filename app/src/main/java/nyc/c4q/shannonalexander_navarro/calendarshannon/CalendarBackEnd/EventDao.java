package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

@Dao
public interface EventDao {

        @Insert
        void insert(Event event);

        @Delete
        void delete(Event event);

        @Query("DELETE FROM event_table")
        void deleteAll();

        @Query("SELECT * FROM event_table")
        LiveData<List<Event>> getAllEvents();

        @Update(onConflict = OnConflictStrategy.REPLACE)
        void update(Event event);
}
