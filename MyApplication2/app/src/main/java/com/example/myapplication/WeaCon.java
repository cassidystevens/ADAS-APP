package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class WeaCon extends AppCompatActivity {
    Button button1;
    TextView temperatureTextView;
    TextView weatherConditionTextView;

    private final String[] weatherConditions = {
            "Sunny",
            "Cloudy",
            "Rainy",
            "Snowy",
            "Windy",
            "Foggy",
            "Thunderstorm",
            "Partly Cloudy",
            "Clear"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wea_con);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button);
        weatherConditionTextView = findViewById(R.id.textView11);
        temperatureTextView = findViewById(R.id.textView9);
        displayRandomTemperature();
        displayRandomWeather();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(WeaCon.this, EnvAndContMetr.class);
                startActivity(intent1);
            }
        });
    }

        private void displayRandomTemperature() {
            // Generate random temperature between 50-100°F
            int randomTemp = new Random().nextInt(51) + 50; // 50-100 range

            // Display with degree symbol
            temperatureTextView.setText(String.format("%d°F", randomTemp));
    }

    private void displayRandomWeather() {
        // Generate and display random temperature
        int randomTemp = new Random().nextInt(51) + 50; // 50-100 range
        temperatureTextView.setText(String.format("%d°F", randomTemp));

        // Generate and display random weather condition
        String randomCondition = weatherConditions[new Random().nextInt(weatherConditions.length)];
        weatherConditionTextView.setText(randomCondition);

    }


}
