package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

@Dao
public interface EventDao {

        @Insert
        void insert(Event tabooCard);

        @Delete
        void delete(Event tabooCard);

        @Query("DELETE FROM event_table")
        void deleteAll();

        @Query("SELECT * FROM event_table")
        LiveData<List<Event>> getAllCards();
}
