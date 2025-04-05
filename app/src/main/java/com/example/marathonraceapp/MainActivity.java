package com.example.marathonraceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int totalHours;
    int totalMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final EditText hours = (EditText)findViewById(R.id.timeHour);
        final EditText minutes = (EditText)findViewById(R.id.timeMinutes);
        Button button = (Button)findViewById(R.id.resultsButton);



        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalHours = Integer.parseInt(hours.getText().toString());
                totalMinutes = Integer.parseInt(minutes.getText().toString());

                if (totalHours > 10) {
                    Toast.makeText(MainActivity.this, "Hours cannot be higher than 10", Toast.LENGTH_SHORT).show();
                } else if (totalMinutes > 59) {
                    Toast.makeText(MainActivity.this, "Minutes cannot be higher than 59", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("key1", totalHours);
                    editor.putInt("key2", totalMinutes);
                    editor.commit();

                    startActivity(new Intent(MainActivity.this, Rankings.class));

                }
            }
        });



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}