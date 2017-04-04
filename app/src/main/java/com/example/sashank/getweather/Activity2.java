package com.example.sashank.getweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    static TextView city;
    static TextView temp;
    static TextView humi;
    static TextView pre;
    static TextView mintemp;
    static TextView maxtemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent i=getIntent();
        String cityName=i.getStringExtra("EXTRA_MESSAGE");

        DownloadData data = new DownloadData();
        data.execute("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=4905e99ced7c4fa6a603bfd61571bf07");

        city = (TextView) findViewById(R.id.cityName);
        temp = (TextView) findViewById(R.id.temperature);
        humi = (TextView) findViewById(R.id.humidity);
        pre = (TextView) findViewById(R.id.pressure);
        mintemp = (TextView) findViewById(R.id.mintemp);
        maxtemp = (TextView) findViewById(R.id.maxtemp);

    }

}
