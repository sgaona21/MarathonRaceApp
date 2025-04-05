package com.example.marathonraceapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Rankings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rankings);


        TextView averagePace = (TextView)findViewById(R.id.averageTime);
        ImageView image = (ImageView)findViewById(R.id.medalResultsImage);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int totalHours = sharedPref.getInt("key1", 0);
        int totalMinutes = sharedPref.getInt("key2", 0);

        float averagePacePerMile;

        averagePacePerMile = ((totalHours * 60) + totalMinutes) / 26;
        averagePace.setText("Average Pace: " + averagePacePerMile + " Minutes");

        if (averagePacePerMile < 11) {
            image.setImageResource(R.drawable.gold);
        } else if (averagePacePerMile < 15 && averagePacePerMile > 10) {
            image.setImageResource(R.drawable.silver);
        } else if (averagePacePerMile >= 15) {
            image.setImageResource(R.drawable.bronze);
        }



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}