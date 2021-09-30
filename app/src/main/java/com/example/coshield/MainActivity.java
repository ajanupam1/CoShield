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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;



public class MainActivity extends AppCompatActivity {
    String total_cases = null;
    String total_recovered = null;
    String total_deaths = null;
    TextView cases , recovered , deaths ;

    public class Fetchdata extends AsyncTask<String, Void , String> {
        String data="" ;

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            HttpsURLConnection httpsURLConnection = null ;
            try{
                url = new URL(strings[0]);
                httpsURLConnection = (HttpsURLConnection)url.openConnection();
                InputStream in = httpsURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int read = reader.read();
                while(read!= -1){
                    char current = (char)read ;
                    data = data+ current ;
                    read = reader.read();
                }

            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data ;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                    JSONObject current = new JSONObject(s);
                    total_cases = current.getString("totalCases");
                    total_deaths = current.getString("deaths");
                    total_recovered = current.getString("recovered") ;
                    Log.i("info1" , total_cases);
                Log.i("info2" , total_recovered);
                Log.i("info3" , total_deaths);
                cases.setText(total_cases);
                recovered.setText(total_recovered);
                deaths.setText(total_deaths);

                } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }

        }




        //        @Override
//        protected Void doInBackground(Void... voids) {
//            URL url = null;
//            HttpsURLConnection httpsURLConnection = null ;
//            try{
//                url = new URL("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true#");
//                httpsURLConnection = (HttpsURLConnection)url.openConnection();
//                InputStream in = httpsURLConnection.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in);
//                int read = reader.read();
//                while(read!= -1){
//                    char current = (char)read ;
//                    data = data+ current ;
//                    read = reader.read();
//                }
//
//            }
//            catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void unused) {
//            try {
//                    JSONObject current = new JSONObject(data);
//                    Log.i("info1" , (String) current.get("activeCases"));
//
//                } catch (JSONException jsonException) {
//                jsonException.printStackTrace();
//            }
////                String active = value.getString("activeCases");
////                Log.i("s" , active);
//
//        }
    }

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

      Fetchdata fetchdata = new Fetchdata() ;
      fetchdata.execute("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true#");

        cases = findViewById(R.id.cases);
        recovered =findViewById(R.id.recovered);
        deaths = findViewById(R.id.deaths);

    }
}