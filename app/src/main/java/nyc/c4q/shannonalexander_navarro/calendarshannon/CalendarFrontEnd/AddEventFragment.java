package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarFrontEnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd.JsonResponseTransformer;
import nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarBackEnd.EventService;
import nyc.c4q.shannonalexander_navarro.calendarshannon.R;
import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

import static spark.Spark.get;
import static spark.Spark.post;

public class AddEventFragment extends Fragment {

    private Button submitBtn, startAm, startPm, endAm, endPm;
    private EditText startTimeET, endTimeET, descriptionET;
    private TextView close;
    private String description, start, end;
    private EventService eventService = new EventService();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(container.getContext()).inflate(R.layout.add_event_fragment, container, false);
        initViews(root);
        getDayFromBundle();
        onSubmit();
        checkAmOrPm();
        onClose();
        return root;
    }

    private void initViews(View view) {
        close = view.findViewById(R.id.close);
        submitBtn = view.findViewById(R.id.submit_btn);
        descriptionET = view.findViewById(R.id.description_et);
        startTimeET = view.findViewById(R.id.start_time_et);
        endTimeET = view.findViewById(R.id.end_time_et);
        startAm = view.findViewById(R.id.am_start);
        startPm = view.findViewById(R.id.pm_start);
        endAm = view.findViewById(R.id.am_end);
        endPm = view.findViewById(R.id.pm_end);
    }

    private void sendEvent() {
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        intent.putExtra("date", getEventFromForm().getDate());
        intent.putExtra("descrip", getEventFromForm().getDescription());
        intent.putExtra("start", getEventFromForm().getStartTime());
        intent.putExtra("end", getEventFromForm().getEndTime());
        startActivity(intent);
    }

    private void onSubmit() {
        submitBtn.setOnClickListener(view1 -> {
            eventRequestsToLocalServer(getEventFromForm());
            clearText();
            sendEvent();
            closeFragment();
        });
    }

    private void onClose() {
        close.setOnClickListener(view -> closeFragment());
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

    private void clearText() {
        descriptionET.setText("");
        startTimeET.setText("");
        endTimeET.setText("");
    }

    private void checkAmOrPm() {
        startAm.setOnClickListener(view -> {
            startAm.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
            startPm.setBackgroundResource(android.R.drawable.btn_default);
            start += "am";
        });
        startPm.setOnClickListener(view -> {
            startPm.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
            startAm.setBackgroundResource(android.R.drawable.btn_default);
            start += "pm";
        });
        endPm.setOnClickListener(view -> {
            endPm.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
            endAm.setBackgroundResource(android.R.drawable.btn_default);
            end += "pm";
        });
        endAm.setOnClickListener(view -> {
            endAm.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
            endPm.setBackgroundResource(android.R.drawable.btn_default);
            end += "am";
        });
    }

    private void eventRequestsToLocalServer(Event event) {
        post("/event", (request, response) -> eventService.createEventToPost(
                Integer.parseInt(request.queryParams(event.getDate() + "")),
                request.queryParams(event.getStartTime()),
                request.queryParams(event.getEndTime()),
                request.queryParams(event.getDescription())
        ), new JsonResponseTransformer());

        get("/event/:date", (request, response) -> event, new JsonResponseTransformer());
    }

}
