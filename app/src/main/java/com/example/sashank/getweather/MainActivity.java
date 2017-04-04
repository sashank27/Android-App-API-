package com.example.sashank.getweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        EditText city = (EditText) findViewById(R.id.editText);
        Intent i=new Intent(this,Activity2.class);
        String name = city.getText().toString();
        i.putExtra("EXTRA_MESSAGE", name);
        startActivity(i);
    }
}
