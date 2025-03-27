package com.example.myapplication;

import android.content.Context;
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

public class CorBeh extends AppCompatActivity implements SensorEventListener {

    Button button1;
    private SensorManager sensorManager;
    private Sensor gyro;
    private TextView gyro_values, gps_values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cor_beh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gyro_values = findViewById(R.id.gyro_values3);
        gps_values = findViewById(R.id.gps_values);

        // dummy GPS data
        double latitude = generateRandomCoordinate(-90, 90);
        double longitude = generateRandomCoordinate(-180, 180);

        gps_values.setText(String.format("Latitude: %.5f,\nLongitude: %.5f", latitude, longitude));

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }

        if (gyro != null) {
            sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_NORMAL);
        }

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(CorBeh.this,MainActivity2.class);
                startActivity(intent1);
            }
        });
    }

    private double generateRandomCoordinate(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyro_values.setText(String.format("X: %.2f, Y: %.2f, Z: %.2f", x, y, z));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}