package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Date;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_DAYS = 28;
    private List<Date> days = new ArrayList<>();
    private RecyclerView rv;
    private CalAdapter calAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDaysToList();
      //  initGridview();
        initRV();
    }

    private void addDaysToList() {
        for (int i = 0; i < NUM_DAYS; i++) {
            Date date = new Date();
            date.setDate(i + 1 + "");
            days.add(date);
        }
    }

    private void initRV() {
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 7, GridLayoutManager.VERTICAL, false));
        calAdapter = new CalAdapter(days);
        rv.setAdapter(calAdapter);
    }

    private void initGridview() {
//        GridView gridView = findViewById(R.id.gridview);
//        CalendarAdapter calendarAdapter = new CalendarAdapter(days);
//        gridView.setAdapter(calendarAdapter);
    }

    //create a 2d array of cells to represent the day
}
