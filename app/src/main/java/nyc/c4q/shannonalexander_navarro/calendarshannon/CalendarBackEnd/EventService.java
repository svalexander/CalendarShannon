package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import java.util.HashMap;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class EventService {

    private HashMap<Integer,Event> eventMap = new HashMap<>();

    public Event getEvent(){
        return new Event();
    }

    public Event createEventToPost(int date, String startTime, String endTime, String description){
        Event event = new Event(date, startTime, endTime, description);
        eventMap.put(event.getDate(),event);
        return event;
    }


}
