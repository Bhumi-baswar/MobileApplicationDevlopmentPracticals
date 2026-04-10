package com.example.madise;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LabDetailActivity extends AppCompatActivity {

    ImageView labImage;
    TextView labDesc;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_detail);

        labImage = findViewById(R.id.labImage);
        labDesc = findViewById(R.id.labDesc);
        backBtn = findViewById(R.id.backBtn);

        String lab = getIntent().getStringExtra("lab");
        int image = getIntent().getIntExtra("image", 0);

        labImage.setImageResource(image);

        if (lab.equals("Lab 1")) {
            labDesc.setText("Programming Lab:\nPCs have Intel Core i3/i5 processor, 8 GB RAM and 500 GB storage. They run C, C++, Java compilers and programming software.");
        }
        else if (lab.equals("Lab 2")) {
            labDesc.setText("Data Structures Lab:\nComputers have Intel Core i5 processor with 8 GB RAM. Used to run C/C++ IDEs for implementing data structures.");
        }
        else if (lab.equals("Lab 3")) {
            labDesc.setText("DBMS Lab:\nPCs have Intel Core i5 processor, 8 GB RAM and 1 TB storage. They support MySQL and SQL Server.");
        }
        else if (lab.equals("Lab 4")) {
            labDesc.setText("Operating System Lab:\nComputers have Intel Core i5 processor with 8–16 GB RAM. Used to run Linux and Windows OS.");
        }
        else if (lab.equals("Lab 5")) {
            labDesc.setText("Computer Networks Lab:\nPCs have Intel Core i5 processor, 8 GB RAM and LAN connectivity. Used for networking tools.");
        }
        else if (lab.equals("Lab 6")) {
            labDesc.setText("Software Engineering Lab:\nComputers have Intel Core i5 processor with 8 GB RAM. Used for UML and project development.");
        }
        else if (lab.equals("Lab 7")) {
            labDesc.setText("Artificial Intelligence Lab:\nPCs have Intel Core i7 processor with 16 GB RAM. Used for AI programming.");
        }
        else if (lab.equals("Lab 8")) {
            labDesc.setText("Machine Learning Lab:\nComputers have Intel Core i7 processor, 16 GB RAM and GPU support. Used for ML models.");
        }
        else if (lab.equals("Lab 9")) {
            labDesc.setText("Mobile Development Lab:\nPCs have Intel Core i5/i7 processor with 8 GB RAM. Used for Android Studio.");
        }
        else if (lab.equals("Lab 10")) {
            labDesc.setText("Cloud Computing Lab:\nComputers have Intel Core i5 processor and 8 GB RAM with high-speed internet. Used for AWS and cloud services.");
        }
        else if (lab.equals("Lab 11")) {
            labDesc.setText("Cyber Security Lab:\nComputers have Intel Core i5/i7 processor with 8–16 GB RAM. Used for security tools.");
        }
        else if (lab.equals("Lab 12")) {
            labDesc.setText("IoT Lab:\nComputers have Intel Core i5 processor with 8 GB RAM. Used for IoT devices and sensors.");
        }
        else {
            labDesc.setText("Lab details not available.");
        }

        backBtn.setOnClickListener(v -> finish());
    }
}
