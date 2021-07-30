package com.example.coshield;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class accept extends AppCompatActivity {
  public  void searchclick(View view){
      EditText city = (EditText) findViewById(R.id.editTextTextPersonName5);
      EditText state = (EditText) findViewById(R.id.editTextTextPersonName6);
      if(city.getText().toString().matches("") || state.getText().toString().matches("")){
          Toast.makeText(this , "Fill all details" , Toast.LENGTH_LONG).show();
      }
      else{
          Intent intent = new Intent(getApplicationContext(),searchresult.class);
          intent.putExtra("city" , city.getText().toString());
          intent.putExtra("state" , state.getText().toString());
          startActivity(intent);
      }

  }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);
    }
}