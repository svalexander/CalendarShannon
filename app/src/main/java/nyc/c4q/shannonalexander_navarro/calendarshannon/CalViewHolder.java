package nyc.c4q.shannonalexander_navarro.calendarshannon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.calendarshannon.models.Date;

;

/**
 * Created by shannonalexander-navarro on 6/22/18.
 */

public class CalViewHolder extends RecyclerView.ViewHolder {

   private TextView dateTV;

    public CalViewHolder(View itemView) {
        super(itemView);
       dateTV = itemView.findViewById(R.id.day_tv);
    }

    public void bind(Date date) {
        dateTV.setText(date.getDate());
    }
}
