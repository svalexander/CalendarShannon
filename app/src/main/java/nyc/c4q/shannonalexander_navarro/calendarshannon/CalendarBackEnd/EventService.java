package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class EventService {
    
    public Event getEvent(){
        return new Event();
    }

    public Event createEventToPost(int date, String startTime, String endTime, String description){
        Event event = new Event(date, startTime, endTime, description);
        return event;
    }


}
