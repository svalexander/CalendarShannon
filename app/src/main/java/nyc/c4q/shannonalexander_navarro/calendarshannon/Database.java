package nyc.c4q.shannonalexander_navarro.calendarshannon;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by shannonalexander-navarro on 6/23/18.
 */

public class Database {

    public Database() {
        getDatabase();
    }

    private void getDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Trying again");
    }
}
