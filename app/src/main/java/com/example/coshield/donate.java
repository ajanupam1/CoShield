package com.example.coshield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class donate extends AppCompatActivity {
    ParseObject donate = new ParseObject("Donate");
    public void Onclick5(View view){
        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText editText3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText editText4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText editText5 = (EditText) findViewById(R.id.editTextPhone2);
              if(editText1.getText().toString().matches("") || editText2.getText().toString().matches("") || editText3.getText().toString().matches("")  || editText4.getText().toString().matches("") || editText5.getText().toString().matches("")){
                Toast.makeText(this , "Complete the information" , Toast.LENGTH_SHORT).show();
              }
              else{

                  donate.put("Name" , editText1.getText().toString());
                  donate.put("City" , editText2.getText().toString());
                  donate.put("State" , editText3.getText().toString());
                  donate.put("Bloodgroup" , editText4.getText().toString());
                  donate.put("PhoneNumber" , editText5.getText().toString());
                  donate.saveInBackground(new SaveCallback() {
                      @Override
                      public void done(ParseException e) {
                          if(e == null){
                              Log.i("sussess" , "saved");
                          }
                          else{
                              e.printStackTrace();
                          }
                      }
                  });
                  Toast.makeText(this , "DETAILS SUBMITTED SUCCESSFULLY" , Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                  startActivity(intent);
              }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

    }
}