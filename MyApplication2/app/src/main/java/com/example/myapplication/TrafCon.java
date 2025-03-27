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

public class TrafCon extends AppCompatActivity {
    Button button1;
    TextView trafficConditionTextView;
    TextView delayTimeTextView;
    private final String[] trafficConditions = {
            "Heavy Traffic",
            "Light Traffic",
            "Accident Reported",
            "Major Accident",
            "No Traffic",
            "Construction Work",
            "Road Closed",
            "Congestion",
            "Slow Moving"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_traf_con);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        button1 = findViewById(R.id.button);
        trafficConditionTextView = findViewById(R.id.trafficConditionTextView);
        delayTimeTextView = findViewById(R.id.delayTimeTextView);

        // Generate and display random traffic data
        displayRandomTrafficData();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TrafCon.this, EnvAndContMetr.class);
                startActivity(intent1);
            }
        });
    }

    private void displayRandomTrafficData() {
        // Generate and display random traffic condition
        String randomCondition = trafficConditions[new Random().nextInt(trafficConditions.length)];
        trafficConditionTextView.setText(randomCondition);

        // Generate and display random delay time (0-30 minutes)
        int delayMinutes = new Random().nextInt(31); // 0-30 range
        delayTimeTextView.setText(String.format("%d minutes", delayMinutes));

    }

}
