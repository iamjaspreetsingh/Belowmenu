package com.jskgmail.belowmenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    ListViewAdapter lviewAdapter;
    private ArrayList<String> stringArrayList, stringArrayList1, stringArrayList2, stringArrayList3, stringArrayList4;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            stringArrayList = new ArrayList<String>();


            stringArrayList1 = new ArrayList<String>();
            stringArrayList2 = new ArrayList<String>();
            stringArrayList3 = new ArrayList<String>();
            stringArrayList4 = new ArrayList<String>();

            ListView l=(ListView)findViewById(R.id.lv);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    l.setVisibility(View.VISIBLE);
                    mTextMessage.setVisibility(View.GONE);
            go();


                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setVisibility(View.VISIBLE);
                    mTextMessage.setText(R.string.title_dashboard);
                    l.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setVisibility(View.VISIBLE);
                    mTextMessage.setText(R.string.title_notifications);
                    l.setVisibility(View.GONE);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setVisibility(View.GONE);
        go();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
void go()
    {
        final ImageView imageView=(ImageView)findViewById(R.id.imageView2) ;
        final ViewGroup container=(ViewGroup)findViewById(R.id.ok);
        final ListView l=(ListView)findViewById(R.id.lv);
final TextView textView=(TextView)findViewById(R.id.textView);
               imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {;
                     
                       textView.setText("ojjj");
                   }
               });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("first");
        DatabaseReference myRef1 = database.getReference("second");


        stringArrayList = new ArrayList<String>();


        stringArrayList1 = new ArrayList<String>();
        stringArrayList2 = new ArrayList<String>();
        stringArrayList3 = new ArrayList<String>();
        stringArrayList4 = new ArrayList<String>();



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                stringArrayList.add("1");


                stringArrayList1.add(value);
                stringArrayList2.add("Description1");
                stringArrayList3.add("95");
                stringArrayList4.add("sdsds");
                l.setAdapter(lviewAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                stringArrayList1.add("sgg");
            }
        });





        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                stringArrayList.add("2");
                stringArrayList1.add(value);

                stringArrayList2.add("Description2");
                stringArrayList3.add("87");
                stringArrayList4.add("sdsds");
                l.setAdapter(lviewAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                stringArrayList1.add("aaa");
            }
        });








        stringArrayList.add("3");
        stringArrayList1.add("Student 3");
        stringArrayList2.add("Description3");
        stringArrayList3.add("85");
        stringArrayList4.add("sdsds");
        stringArrayList.add("4");
        stringArrayList1.add("Student 4");
        stringArrayList2.add("Description4");
        stringArrayList3.add("77");
        stringArrayList4.add("sdsds");
        stringArrayList.add("5");
        stringArrayList1.add("Student 5");
        stringArrayList2.add("Description5");
        stringArrayList3.add("65");
        stringArrayList4.add("sdsds");
        lviewAdapter = new ListViewAdapter(this, stringArrayList1, stringArrayList, stringArrayList2, stringArrayList3, stringArrayList4);
        l.setAdapter(lviewAdapter);
    }
}
