package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {

    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnCreateAccount = findViewById(R.id.btnCreateAccount);
    }
}
