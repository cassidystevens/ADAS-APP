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


public class HRVAndStrLev extends AppCompatActivity {

    Button button1;
    TextView BPMTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hrvand_str_lev);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button);
        BPMTextView = findViewById(R.id.textView3);
        displayRandomBPM();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HRVAndStrLev.this,WeaDevMet.class);
                startActivity(intent1);
            }
        });
    }

    private void displayRandomBPM() {
        // Generate random temperature between 50-100°F
        int randomBPM = new Random().nextInt(61) + 60; // 50-100 range

        // Display with degree symbol
        BPMTextView.setText(String.format("%d", randomBPM));
}
}