package nyc.c4q.shannonalexander_navarro.calendarshannon.models;

/**
 * Created by shannonalexander-navarro on 6/21/18.
 */

public class Event {

    //date here is circular
    private int date;
    private String startTime;
    private String endTime;
    private String description;

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
