package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
    private AddEventFragment addEventFragment = new AddEventFragment();

    public CalAdapter(List<Date> days) {
        this.dates = days;
    }

    @Override
    public CalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item_view, parent, false);
        //  launchForm(root);
        return new CalViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CalViewHolder holder, int position) {

        Date date = dates.get(position);
        holder.bind(date);
        launchForm(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public void launchForm(View view, int position) {
        final int day = position + 1;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key", day);
                addEventFragment.setArguments(bundle);
                FragmentManager addEventFragTransaction = ((FragmentActivity) view.getContext()).getSupportFragmentManager();
                addEventFragTransaction.beginTransaction().replace(R.id.frame_layout, addEventFragment).commit();

            }
        });
    }
}
