package com.example.madise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LabGridActivity extends AppCompatActivity {

    TextView lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_grid);

        lab1 = findViewById(R.id.lab1);
        lab2 = findViewById(R.id.lab2);
        lab3 = findViewById(R.id.lab3);
        lab4 = findViewById(R.id.lab4);
        lab5 = findViewById(R.id.lab5);
        lab6 = findViewById(R.id.lab6);
        lab7 = findViewById(R.id.lab7);
        lab8 = findViewById(R.id.lab8);
        lab9 = findViewById(R.id.lab9);
        lab10 = findViewById(R.id.lab10);
        lab11 = findViewById(R.id.lab11);
        lab12 = findViewById(R.id.lab12);

        setClick(lab1, "Lab 1", R.drawable.lab1);
        setClick(lab2, "Lab 2", R.drawable.lab2);
        setClick(lab3, "Lab 3", R.drawable.lab3);
        setClick(lab4, "Lab 4", R.drawable.lab4);
        setClick(lab5, "Lab 5", R.drawable.lab5);
        setClick(lab6, "Lab 6", R.drawable.lab6);
        setClick(lab7, "Lab 7", R.drawable.lab7);
        setClick(lab8, "Lab 8", R.drawable.lab8);
        setClick(lab9, "Lab 9", R.drawable.lab9);
        setClick(lab10, "Lab 10", R.drawable.lab10);
        setClick(lab11, "Lab 11", R.drawable.lab11);
        setClick(lab12, "Lab 12", R.drawable.lab12);
    }

    private void setClick(TextView labView, String name, int image) {
        labView.setOnClickListener(v -> {
            Intent i = new Intent(LabGridActivity.this, LabDetailActivity.class);
            i.putExtra("lab", name);
            i.putExtra("image", image);
            startActivity(i);
        });
    }
}
