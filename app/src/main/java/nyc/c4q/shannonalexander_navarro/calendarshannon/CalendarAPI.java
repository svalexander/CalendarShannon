package nyc.c4q.shannonalexander_navarro.calendarshannon;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by shannonalexander-navarro on 6/23/18.
 */

interface CalendarAPI {

    @POST("event")
    Call<CalendarClient> postEvent(@Body Event event);
}
