package nyc.c4q.shannonalexander_navarro.calendarshannon.CalendarFrontEnd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.calendarshannon.R;
import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Event;

public class CalendarViewHolder extends RecyclerView.ViewHolder {

    private TextView dateTV, descriptionTV, startTimeTV, endTimeTV;

    public CalendarViewHolder(View itemView) {
        super(itemView);
        dateTV = itemView.findViewById(R.id.day_tv);
        descriptionTV = itemView.findViewById(R.id.description_tv);
        startTimeTV = itemView.findViewById(R.id.start_time_tv);
        endTimeTV = itemView.findViewById(R.id.end_time_tv);
    }

    public void bind(Event event) {
        dateTV.setText(event.getDate()+"");
        if (event.getDescription() != null) {
            descriptionTV.setText(event.getDescription());
        }
        if (event.getEndTime() != null) {
            endTimeTV.setText(event.getEndTime());
        }
        if (event.getStartTime() != null) {
            startTimeTV.setText(event.getStartTime());
        }
    }
}
