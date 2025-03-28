package com.example.myapplication;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

public class WeaCon extends AppCompatActivity implements SensorEventListener {
    Button button1;
    TextView temperatureTextView;
    TextView weatherConditionTextView;
    private SensorManager sensorManager;
    private Sensor tempSensor;


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

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(WeaCon.this, EnvAndContMetr.class);
                startActivity(intent1);
            }
        });
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float temperatureCelsius = event.values[0];
            float temperatureFahrenheit = (temperatureCelsius * 9/5) + 32;
            temperatureTextView.setText(String.format("%.1f°F", temperatureFahrenheit));

            // Simple weather condition based on temperature
            if (temperatureFahrenheit > 85) {
                weatherConditionTextView.setText("Sunny");
            } else if (temperatureFahrenheit > 70) {
                weatherConditionTextView.setText("Partly Cloudy");
            } else if (temperatureFahrenheit > 50) {
                weatherConditionTextView.setText("Cloudy");
            } else {
                weatherConditionTextView.setText("Cold");
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Dummy Code
    }



}
