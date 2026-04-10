package com.example.progressbarr;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ProgressBar circularBar, marksBar;
    TextView txtMarks;
    Button btnProcess, btnMarks;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        circularBar = findViewById(R.id.circularBar);
        marksBar = findViewById(R.id.marksBar);
        txtMarks = findViewById(R.id.txtMarks);
        btnProcess = findViewById(R.id.btnProcess);
        btnMarks = findViewById(R.id.btnMarks);


        btnProcess.setOnClickListener(v -> {
            circularBar.setVisibility(View.VISIBLE);

            new Handler().postDelayed(() -> {
                circularBar.setVisibility(View.GONE);
                Toast.makeText(this, "Result Generated 🎓", Toast.LENGTH_SHORT).show();
            }, 3000);
        });

        btnMarks.setOnClickListener(v -> {
            progress = 0;
            Handler handler = new Handler();

            new Thread(() -> {
                while (progress <= 100) {
                    try {
                        Thread.sleep(70);

                        handler.post(() -> {
                            marksBar.setProgress(progress);
                            txtMarks.setText("Marks: " + progress);

                            if (progress == 100) {
                                Toast.makeText(this, "Marks Calculated ✅", Toast.LENGTH_SHORT).show();
                            }
                        });

                        progress++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}