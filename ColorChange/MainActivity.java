package com.example.implicitintentfirst;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnRed, btnBlue, btnGreen;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainLayout = findViewById(R.id.mainLayout);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);

        btnRed.setOnClickListener(v ->
                mainLayout.setBackgroundColor(getResources().getColor(R.color.myRed)));

        btnBlue.setOnClickListener(v ->
                mainLayout.setBackgroundColor(getResources().getColor(R.color.myBlue)));

        btnGreen.setOnClickListener(v ->
                mainLayout.setBackgroundColor(getResources().getColor(R.color.myGreen)));
    }
}
