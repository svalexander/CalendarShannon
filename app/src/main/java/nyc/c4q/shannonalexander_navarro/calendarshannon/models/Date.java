package nyc.c4q.shannonalexander_navarro.calendarshannon.models;

/**
 * Created by shannonalexander-navarro on 6/21/18.
 */

public class Date {

    private String date;
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
