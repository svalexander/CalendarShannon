package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 6/21/18.
 */

public class CalendarAdapter extends BaseAdapter {

    private List<Integer> dates;

    public CalendarAdapter(List<Integer> days) {
        this.dates = days;
    }

    @Override
    public int getCount() {
        return dates.size();
    }

    //should return the actual object at the specified position in the adapter
    @Override
    public Object getItem(int i) {
        return i;
    }

    //should return the row id of the item
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        CalendarViewHolder viewHolder;
       // if (view == null) {

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_item_view, viewGroup, false);
            viewHolder = new CalendarViewHolder();
            viewHolder.textView = view.findViewById(R.id.day_tv);
       // } else {
            viewHolder.textView.setText(dates.get(i)+"");
         //   viewHolder = (CalendarViewHolder) view.getTag();
     //   }
        return view;
    }
}
