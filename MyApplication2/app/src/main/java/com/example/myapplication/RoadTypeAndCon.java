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


public class RoadTypeAndCon extends AppCompatActivity {
    Button button1;
    TextView roadTypeTextView;
    TextView roadConditionTextView;

    // Arrays of possible road types and conditions
    private final String[] roadTypes = {
            "Highway",
            "Main Road",
            "Side Street",
            "Residential Street",
    };
    private final String[] roadConditions = {
            "Closed",
            "Partially Open",
            "Detour Available",
            "Fully Open",
            "Construction Zone",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_road_type_and_con);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button);
        roadTypeTextView = findViewById(R.id.roadTypeTextView);
        roadConditionTextView = findViewById(R.id.roadConditionTextView);
        displayRandomRoadData();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RoadTypeAndCon.this, EnvAndContMetr.class);
                startActivity(intent1);
            }
        });
    }

    private void displayRandomRoadData() {
        // Generate and display random road type
        String randomType = roadTypes[new Random().nextInt(roadTypes.length)];
        roadTypeTextView.setText(randomType);

        // Generate and display random road condition
        String randomCondition = roadConditions[new Random().nextInt(roadConditions.length)];
        roadConditionTextView.setText(randomCondition);

    }
}
