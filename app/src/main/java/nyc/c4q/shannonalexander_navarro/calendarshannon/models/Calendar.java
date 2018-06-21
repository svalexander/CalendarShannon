package nyc.c4q.shannonalexander_navarro.calendarshannon.models;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 6/21/18.
 */

public class Calendar {

    private List<Date> dates;
    private String user;

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
