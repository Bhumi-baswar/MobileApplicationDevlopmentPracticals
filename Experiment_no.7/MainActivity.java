package com.example.progressbarr;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    ProgressBar downloadBar, loadingBar;
    TextView txtProgress;
    Button btnDownload, btnLoad, btnNext;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBar = findViewById(R.id.downloadBar);
        loadingBar = findViewById(R.id.loadingBar);
        txtProgress = findViewById(R.id.txtProgress);
        btnDownload = findViewById(R.id.btnDownload);
        btnLoad = findViewById(R.id.btnLoad);
        Button btnNext = findViewById(R.id.btnNext);

        // ✅ Download Simulation
        btnDownload.setOnClickListener(v -> {
            progress = 0;
            Handler handler = new Handler();

            new Thread(() -> {
                while (progress <= 100) {
                    try {
                        Thread.sleep(80);

                        handler.post(() -> {
                            downloadBar.setProgress(progress);
                            txtProgress.setText(progress + "%");

                            if (progress == 100) {
                                Toast.makeText(this, "Download Complete ✅", Toast.LENGTH_SHORT).show();
                            }
                        });

                        progress++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        btnLoad.setOnClickListener(v -> {
            loadingBar.setVisibility(View.VISIBLE);

            new Handler().postDelayed(() -> {
                loadingBar.setVisibility(View.GONE);
                Toast.makeText(this, "Connected to Server 🌐", Toast.LENGTH_SHORT).show();
            }, 3000);
        });

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}