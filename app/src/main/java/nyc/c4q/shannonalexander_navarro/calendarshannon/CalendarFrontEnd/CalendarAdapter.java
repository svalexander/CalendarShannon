package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarFrontEnd;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.R;
import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    List<Event> events;
    private AddEventFragment addEventFragment = new AddEventFragment();

    public CalendarAdapter(List<Event> days) {
        this.events = days;
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item_view, parent, false);
        return new CalendarViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        Event event = events.get(position);
        holder.bind(event);
        launchForm(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void populateList(List<Event> addedEvents) {
        events = addedEvents;
        notifyDataSetChanged();
    }

    private void launchForm(View view, int position) {
        final int day = position + 1;
        view.setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putInt("key", day);
            addEventFragment.setArguments(bundle);
            FragmentManager addEventFragTransaction = ((FragmentActivity) view1.getContext()).getSupportFragmentManager();
            addEventFragTransaction.beginTransaction().replace(R.id.frame_layout, addEventFragment).commit();
        });
    }
}
