package com.example.coshield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class searchresult extends AppCompatActivity {
    ParseObject donate = new ParseObject("Donate");
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    ArrayList<String> search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        String state = intent.getStringExtra("state");
        listView = findViewById(R.id.listview);
        search = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this , R.layout.support_simple_spinner_dropdown_item , search);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Donate");
        query.whereEqualTo("City" , city);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){
                    if(objects.size() == 0){
                        Toast.makeText(searchresult.this , "No entry found" , Toast.LENGTH_LONG).show();
                        Intent intent12 = new Intent(getApplicationContext() , MainActivity.class);
                        startActivity(intent12);
                    }
                    else{
                        for(ParseObject object : objects){
                            String text123 = "Name: " + object.getString("Name") +" " + "BloodGrp: "+ object.getString("Bloodgroup") + " " + "PhoneN0:" + object.getString("PhoneNumber") ;
                            Log.i("see" , text123);
                            search.add(text123) ;
                        }
                        listView.setAdapter(arrayAdapter);
                    }
                }
                else{
                    e.printStackTrace();
                }
            }
        });
    }
}