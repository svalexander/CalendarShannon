package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

import static spark.Spark.get;
import static spark.Spark.post;


/**
 * Created by shannonalexander-navarro on 6/21/18.
 */

public class AddEventFragment extends Fragment {

    private Button submitBtn, startAm, startPm, endAm, endPm;
    private EditText startTimeET, endTimeET, descriptionET;
    private String description, start, end;
    private EventService eventService = new EventService();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(container.getContext()).inflate(R.layout.add_event_fragment, container, false);
        initViews(root);
        getDayFromBundle();
        clickListeners();
        return root;
    }

    private void initViews(View view) {
        submitBtn = view.findViewById(R.id.submit_btn);
        descriptionET = view.findViewById(R.id.description_et);
        startTimeET = view.findViewById(R.id.start_time_et);
        endTimeET = view.findViewById(R.id.end_time_et);
        startAm = view.findViewById(R.id.am_start);
        startPm = view.findViewById(R.id.pm_start);
        endAm = view.findViewById(R.id.am_end);
        endPm = view.findViewById(R.id.pm_end);
    }

    private void clickListeners() {
        submitBtn.setOnClickListener(view1 -> {
            closeFragment();
            postEventToLocalServer(getEventFromForm());
            getEventFromLocalServer();
            //   write(getEventFromLocalServer());
            Log.d("event?", getEventFromForm().getDescription());
            Log.d("date?", getEventFromForm().getDate() + "");
        });
    }

    private int getDayFromBundle() {
        Bundle bundle = getArguments();
        int date = bundle.getInt("key");
        return date;
    }

    private void closeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    private Event getEventFromForm() {
        description = descriptionET.getText().toString();
        start = startTimeET.getText().toString();
        end = endTimeET.getText().toString();
        return new Event(getDayFromBundle(), start, end, description);
    }

    //int date, String startTime, String endTime, String description
    private void postEventToLocalServer(Event event) {
        //this post not working, getting 404
        post("/event", (request, response) -> eventService.createEventToPost(
                Integer.parseInt(request.queryParams(event.getDate()+"")),
                request.queryParams(event.getStartTime()),
                request.queryParams(event.getEndTime()),
                request.queryParams(event.getDescription())
           // return request.params(":date");
        ) + request.body(), new JsonResponseTransformer());

        //gives me the last item sent, never keeps more than 1 item
        // get("/event/:date", (request, response) -> event, new JsonResponseTransformer());
    }

    void getEventFromLocalServer() {
        //when you look at the local host see date is 0 thats it
        //  Event returnedEvent = new Event();
        //request.queryMap() will write just that
        //request.queryParamsValues("id") gives null
        //request.body() gives an empty string
        //response.body is null
        //i think b/c i have no reference to my post

        //500 internal server error but the object is correct
        get("/event", (request, response) -> {
          //  String paramDate = request.params(":date");
            List<Event> event = eventService.getEvent();
            //not reaching log statements
            Log.d("get?", event.get(0).getDescription());
           // Log.d("paramValue", Integer.valueOf(paramDate)+"");
            return event;
        }, new JsonResponseTransformer());
    }

//    private void write(Event event) {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference eventReference = database.getReference(getEventFromLocalServer().getDate()+"");
//
//        eventReference.setValue(event);
//
//        eventReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Event value = dataSnapshot.getValue(Event.class);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                Log.e("Error", "Failed to read value.", error.toException());
//            }
//        });
//    }


}
