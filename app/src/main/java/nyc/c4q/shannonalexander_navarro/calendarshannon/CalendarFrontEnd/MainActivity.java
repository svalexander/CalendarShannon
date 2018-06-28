package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarFrontEnd;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd.EventViewModel;
import nyc.c4q.shannonalexander_navarro.calendarshannon.R;
import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_DAYS = 28;
    private List<Event> days = new ArrayList<>();
    private RecyclerView rv;
    private CalendarAdapter calendarAdapter;
    private EventViewModel eventViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDaysToList();
        initRV();
    }

    @Override
    protected void onPause() {
        super.onPause();
        addToDB();
    }

    private Event getEventFromIntent() {
        Intent intent = this.getIntent();
        int date = intent.getIntExtra("date",0);
        String description = intent.getStringExtra("descrip");
        String start = intent.getStringExtra("start");
        String end = intent.getStringExtra("end");
        Event event = new Event();
        event.setDate(date);
        event.setStartTime(start);
        event.setEndTime(end);
        event.setDescription(description);
        return event;
    }

    private void addToDB() {
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.getAllEvents().observe(this, eventList -> calendarAdapter.populateList(eventList));
        eventViewModel.insert(getEventFromIntent());
    }

    private void addDaysToList() {
        for (int i = 0; i < NUM_DAYS; i++) {
            Event event = new Event();
            event.setDate(i + 1);
            days.add(event);
        }
    }

    private void initRV() {
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 7, GridLayoutManager.VERTICAL, false));
        calendarAdapter = new CalendarAdapter(days);
        rv.setAdapter(calendarAdapter);
    }
}
