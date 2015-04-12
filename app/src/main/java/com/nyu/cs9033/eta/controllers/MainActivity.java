package com.nyu.cs9033.eta.controllers;


import com.nyu.cs9033.eta.models.Person;
import com.nyu.cs9033.eta.models.Trip;
import com.nyu.cs9033.eta.R;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
    protected final static String EXTRA_MESSAGE = "com.nyu.cs9033.eta.MESSAGE";

    private TextView textView;
    private Person person;
    Trip trip;
    private ArrayList<Trip> context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        Log.v(TAG,"index"+1);
        Button create_trip = (Button) findViewById(R.id.create_trip);
        Button view_trip = (Button) findViewById(R.id.view);
        Button view_history = (Button) findViewById(R.id.trip_history);
        create_trip.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startCreateTripActivity();
            }
        });
        view_trip.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startViewTripActivity();
            }
        });
        view_history.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startTripHistoryActivity();
            }
        });
        // viewTrip.setOnClickListener(this);
		// TODO - fill in here
	}

	/**
	 * This method should start the
	 * Activity responsible for creating
	 * a Trip.
	 */
	public void startCreateTripActivity() {
            Intent intent = new Intent(this, CreateTripActivity.class);
            startActivity(intent);
        }
		// TODO - fill in here
	
	/**
	 * This method should start the
	 * Activity responsible for viewing
	 * a Trip.
	 */
	public void startViewTripActivity() {
            Intent intent = new Intent(this, ViewTripActivity.class);
//            intent.putExtra("create trip",trip);
            startActivity(intent);
    }

    public void startTripHistoryActivity() {
        Intent intent = new Intent(this,TripHistoryActivity.class);
        startActivity(intent);
    }
	
	/**
	 * Receive result from CreateTripActivity here.
	 * Can be used to save instance of Trip object
	 * which can be viewed in the ViewTripActivity.
	 * 
	 * Note: This method will be called when a Trip
	 * object is returned to the main activity. 
	 * Remember that the Trip will not be returned as
	 * a Trip object; it will be in the persisted
	 * Parcelable form. The actual Trip object should
	 * be created and saved in a variable for future
	 * use, i.e. to view the trip.
	 * 
	 */
//	@Override
//	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//		// TODO - fill in here
//            if(resultCode==1) {
//                trip = data.getParcelableExtra("create trip");
//            }
//        if(resultCode == REQUEST_DATA) {
//            if (resultCode == RESULT_OK) {
//                Uri uri = data.getData();
//                String[] queryFields = new String[]{
//                        ContactsContract.Contacts.DISPLAY_NAME
//                };
//                Cursor cursor = getContentResolver().query(uri, queryFields, null, null, null);
//                if (cursor.getCount() == 0) {
//                    cursor.close();
//                    return;
//                }
//                cursor.moveToFirst();
//                String name = cursor.getString(0);
//                Log.v(name,"name");
//                String destination = cursor.getString(1);
//                Date time = new Date(cursor.getLong(2));
//                trip.setName(name);
//                trip.setDestination(destination);
//                trip.setTime(time);
//                Intent intent = new Intent(this,ViewTripActivity.class);
//                intent.putExtra("name", trip);
//                startActivity(intent);
//                cursor.close();
//            }
//        }
//	}
}
