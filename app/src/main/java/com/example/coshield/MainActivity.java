package com.example.coshield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;



public class MainActivity extends AppCompatActivity {
    public void onClick44(View view ){
        Intent intent = new Intent(getApplicationContext(),accept.class);
        startActivity(intent);
    }
    public void Onclick3(View view){
        Intent intent = new Intent(getApplicationContext(), vaccine.class);
        startActivity(intent);
    }
    public void Onclick1(View view){
        Intent intent = new Intent(getApplicationContext(), donate.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}