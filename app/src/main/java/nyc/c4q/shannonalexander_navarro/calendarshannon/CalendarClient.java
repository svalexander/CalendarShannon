package nyc.c4q.shannonalexander_navarro.calendarshannon;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shannonalexander-navarro on 6/23/18.
 */

public class CalendarClient {

    static final String BASE_URL = "http://localhost:4567/hello";

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static CalendarAPI createCalendarApiService(){
        CalendarAPI calendarAPI = retrofit.create(CalendarAPI.class);
        return  calendarAPI;
    }
}
