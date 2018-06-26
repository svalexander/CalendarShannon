package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Date;

import static spark.Spark.get;

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
        initRV();
       // port(4567);
        get("/hello", (req, res) -> "My message");
        //http://localhost:4567/hello
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
}
