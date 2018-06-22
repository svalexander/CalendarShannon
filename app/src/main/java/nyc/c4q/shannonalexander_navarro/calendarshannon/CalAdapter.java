package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Date;

/**
 * Created by shannonalexander-navarro on 6/22/18.
 */

public class CalAdapter extends RecyclerView.Adapter<CalViewHolder> {

    private List<Date> dates;

    public CalAdapter(List<Date> days) {
        this.dates = days;
    }

    @Override
    public CalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  root = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item_view, parent, false);
        return new CalViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CalViewHolder holder, int position) {

        Date date = dates.get(position);
        holder.bind(date);
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }
}
