package com.example.sashank.getweather;

import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadData extends AsyncTask<String,Void,String>{

    @Override
    protected String doInBackground(String... urls) {

        String result="";
        URL url;
        HttpURLConnection urlConnection=null;

        try {
            url=new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

            while (data!=-1)
            {
                char current = (char) data;
                result+=current;
                data=reader.read();
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject weatherdata = new JSONObject(jsonObject.getString("main"));

            double temperature = Double.parseDouble(weatherdata.getString("temp"));
            double humidity = Double.parseDouble(weatherdata.getString("humidity"));
            double pressure = Double.parseDouble(weatherdata.getString("pressure"));
            double min_temp = Double.parseDouble(weatherdata.getString("temp_min"));
            double max_temp = Double.parseDouble(weatherdata.getString("temp_max"));

            int tempInteger = (int) (temperature - 273.15);

            String placeName = jsonObject.getString("name");

            Activity2.city.setText(String.valueOf(placeName));
            Activity2.temp.setText(String.valueOf(tempInteger) + " ̊C");
            Activity2.humi.setText(String.valueOf(humidity) + " %");
            Activity2.pre.setText(String.valueOf(pressure) + " Pa");
            Activity2.mintemp.setText(String.valueOf(min_temp) + " ̊C");
            Activity2.maxtemp.setText(String.valueOf(max_temp) + " ̊C");


        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
