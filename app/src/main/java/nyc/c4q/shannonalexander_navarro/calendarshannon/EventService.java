package nyc.c4q.shannonalexander_navarro.calendarshannon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

/**
 * Created by shannonalexander-navarro on 6/26/18.
 */

public class EventService {

    private HashMap<Integer,Event> eventMap = new HashMap<>();

    public List<Event> getEvent(){
        return new ArrayList<>(eventMap.values());
    }

    public Event createEventToPost(int date, String startTime, String endTime, String description){
        Event event = new Event(date,startTime,endTime,description);
        eventMap.put(event.getDate(),event);
        return event;
    }

//    public User createUser(String name, String email) {
//        failIfInvalid(name, email);
//        User user = new User(name, email);
//        users.put(user.getId(), user);
//        return user;
//    }
}
