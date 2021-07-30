package com.example.coshield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

public class Loginpage extends AppCompatActivity {
    public View number(View view){
        return view ;
    }
    public void Onclick1(View view){
        EditText editText = (EditText)findViewById(R.id.editTextPhone);
        if(editText.getText().toString().length() != 10){
            Toast.makeText(this , "Enter a valid number" , Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);




    }
}