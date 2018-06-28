package nyc.c4q.shannonalexander_navarro.calendarshannon.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by shannonalexander-navarro on 6/21/18.
 */

@Entity(tableName = "event_table")
public class Event implements Serializable {

    //date here is circular
    @PrimaryKey
    private int date;
    private String startTime;
    private String endTime;
    private String description;

    public Event(int date, String startTime, String endTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    //need empty constructor or firebase
    public Event() {
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
