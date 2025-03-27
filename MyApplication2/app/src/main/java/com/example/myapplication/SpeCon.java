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

public class SpeCon extends AppCompatActivity {

    Button button1;
    private TextView gps_values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spe_con);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gps_values = findViewById(R.id.gps_values2);

        // dummy GPS data
        double latitude = generateRandomCoordinate(-90, 90);
        double longitude = generateRandomCoordinate(-180, 180);

        gps_values.setText(String.format("Latitude: %.5f,\nLongitude: %.5f", latitude, longitude));


        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(SpeCon.this,MainActivity2.class);
                startActivity(intent1);
            }
        });
    }

    private double generateRandomCoordinate(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}