package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import com.google.gson.Gson;

import spark.ResponseTransformer;

/**
 * Created by shannonalexander-navarro on 6/26/18.
 */

public class JsonResponseTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object event) {
        return gson.toJson(event);
    }

}