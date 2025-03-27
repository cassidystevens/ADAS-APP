package com.example.myapplication;

import static android.content.Context.*;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccAndBrakPatt extends AppCompatActivity implements SensorEventListener {

    Button button1;
    private SensorManager sensorManager;
    private Sensor accel;
    private Sensor gyro;
    private TextView accel_values, gyro_values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acc_and_brak_patt);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        accel_values = findViewById(R.id.accel_values);
        gyro_values = findViewById(R.id.gyro_values);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }

        // Register Sensor Listener
        if (accel != null) {
            sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if (gyro != null) {
            sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_NORMAL);
        }

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(AccAndBrakPatt.this,MainActivity2.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accel_values.setText(String.format("X: %.2f, Y: %.2f, Z: %.2f", x, y, z));
        }

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyro_values.setText(String.format("X: %.2f, Y: %.2f, Z: %.2f", x, y, z));
        }
    }
}