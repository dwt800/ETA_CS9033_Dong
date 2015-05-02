package com.nyu.cs9033.eta.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Trip implements Parcelable {
	
	// Member fields should exist here, what else do you need for a trip?
	// Please add additional fields
	private String name;
    private ArrayList<Person> friends;
    private Person person;
    private String destination;
    private String time;
    private int tripID;
    private ArrayList<Person> res = new ArrayList<Person>();
    private static final String JSON_ID = "id";
    private static final String JSON_DESTINATION = "destination";
    private static final String JSON_PEOPLE = "people";
    private static final String JSON_DATE = "date";
    private final static String TAG = "Trip";

    public String getName(){
        return name;
    }
    public void setName(String name){this.name = name;}
    public ArrayList<Person> getFriends(){
        return friends;
    }
    public void setFriends(String friends){
        Person person1 = new Person();
        person1.setName(friends);
            res.add(person1);
        this.friends = res;
    }
    public void setPerson(String person){
        Person person1 = new Person();
        person1.setName(person);
    }

    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination){this.destination = destination;}
    public String getTime(){
        return time;
    }
    public void setTime(String time){this.time = time;}
    public int getTripID() { return tripID;}

	/**
	 * Parcelable creator. Do not modify this function.
	 */
	public static final Parcelable.Creator<Trip> CREATOR = new Parcelable.Creator<Trip>() {
		public Trip createFromParcel(Parcel p) {
			return new Trip(p);
		}

		public Trip[] newArray(int size) {
			return new Trip[size];
		}
	};
	
	/**
	 * Create a Trip model object from a Parcel. This
	 * function is called via the Parcelable creator.
	 * 
	 * @param p The Parcel used to populate the
	 * Model fields.
	 */
	public Trip(Parcel p) {
        tripID = p.readInt();
        name = p.readString();
        destination = p.readString();
        friends = (ArrayList<Person>)p.readSerializable();
        time = p.readString();
//        time = (Date)p.readSerializable();
		// TODO - fill in here
	}
	
	/**
	 * Create a Trip model object from arguments
	 * 
	 * @param name  Add arbitrary number of arguments to
	 * instantiate Trip class based on member variables.
	 */


	public Trip(String name,ArrayList<Person> friends, String destination,String time) {
//        this.tripID = trip_ID;
        this.name = name;
        this.friends = friends;
        this.destination = destination;
        this.time = time;
	}

	/**
	 * Serialize Trip object by using writeToParcel. 
	 * This function is automatically called by the
	 * system when the object is serialized.
	 * 
	 * @param dest Parcel object that gets written on 
	 * serialization. Use functions to write out the
	 * object stored via your member variables. 
	 * 
	 * @param flags Additional flags about how the object 
	 * should be written. May be 0 or PARCELABLE_WRITE_RETURN_VALUE.
	 * In our case, you should be just passing 0.
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.tripID);
		dest.writeString(this.name);
        dest.writeSerializable(this.friends);
        dest.writeString(this.destination);
        dest.writeString(this.time);
//        dest.writeSerializable(this.time);
	}
	
	/**
	 * Feel free to add additional functions as necessary below.
	 */

    // convert String to List
    public ArrayList<Person> ConvertFriendsToList(String friends1){
        String[] vfriend = friends1.split(",");
        ArrayList<Person> vfriends = new ArrayList<Person>();
        for(String v:vfriend){
            person = new Person();
            person.setName(v);
            vfriends.add(person);
        }
        return vfriends;
    }

    //convert List to String
    public String ConvertFriendsToString(ArrayList<Person> friends){
        String friends2 ="";
        for(int i=0; i<friends.size();i++) {
            friends2+=friends.get(i).getName()+" ";
        }
        return friends2;
    }

    public JSONObject toJSON() throws JSONException {
        Log.i(TAG, "Trips write to json");
        JSONObject json = new JSONObject();
        json.put(JSON_ID, String.valueOf(tripID));
        json.put(JSON_DESTINATION, destination);
        json.put(JSON_PEOPLE, new JSONArray(friends));
        json.put(JSON_DATE, time);

        return json;
    }

    //initial Trip
	public Trip(){}

	/**
	 * Do not implement
	 */
	@Override
	public int describeContents() {
		// Do not implement!
		return 0;
	}
}
