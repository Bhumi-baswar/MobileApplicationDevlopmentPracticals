package com.example.madise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWelcome = findViewById(R.id.btnWelcome);

        btnWelcome.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, LabGridActivity.class);
            startActivity(i);
        });
    }
}
