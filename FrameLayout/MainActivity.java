package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnBottomRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBottomRight = findViewById(R.id.btnBottomRight);

        btnBottomRight.setOnClickListener(v -> {
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}
