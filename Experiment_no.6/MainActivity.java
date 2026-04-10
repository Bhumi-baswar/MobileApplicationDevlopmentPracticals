package com.example.inputcontrols;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    RadioGroup radioGroup;
    CheckBox cbJava, cbPython, cbWeb;
    Switch switchBtn;
    Button btnSubmit;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        radioGroup = findViewById(R.id.radioGroup);
        cbJava = findViewById(R.id.cbJava);
        cbPython = findViewById(R.id.cbPython);
        cbWeb = findViewById(R.id.cbWeb);
        switchBtn = findViewById(R.id.switchBtn);
        btnSubmit = findViewById(R.id.btnSubmit);
        ratingBar = findViewById(R.id.ratingBar);

        // ✅ RADIO BUTTON EVENT
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selected = findViewById(checkedId);
            Toast.makeText(this, "Selected: " + selected.getText(), Toast.LENGTH_SHORT).show();
        });

        // ✅ CHECKBOX EVENTS
        cbJava.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, "Java " + (isChecked ? "Selected" : "Unselected"), Toast.LENGTH_SHORT).show();
        });

        cbPython.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, "Python " + (isChecked ? "Selected" : "Unselected"), Toast.LENGTH_SHORT).show();
        });

        cbWeb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, "Web " + (isChecked ? "Selected" : "Unselected"), Toast.LENGTH_SHORT).show();
        });

        // ✅ SWITCH (TOGGLE) EVENT
        switchBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Notifications ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Notifications OFF", Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                if (fromUser) {
                    Toast.makeText(MainActivity.this,
                            "You rated: " + rating,
                            Toast.LENGTH_SHORT).show();
                }

                // Optional logic based on rating
                if (rating <= 2) {
                    Toast.makeText(MainActivity.this, "We will improve!", Toast.LENGTH_SHORT).show();
                } else if (rating <= 4) {
                    Toast.makeText(MainActivity.this, "Thanks for feedback!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Awesome! धन्यवाद 😊", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // ✅ BUTTON CLICK EVENT
        btnSubmit.setOnClickListener(v -> submitForm());
    }

    private void submitForm() {

        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        int selectedGenderId = radioGroup.getCheckedRadioButtonId();

        // Validation
        if (name.isEmpty()) {
            etName.setError("Enter name");
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Enter email");
            return;
        }

        if (selectedGenderId == -1) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton genderBtn = findViewById(selectedGenderId);

        // Collect skills
        StringBuilder skills = new StringBuilder();

        if (cbJava.isChecked()) skills.append("Java ");
        if (cbPython.isChecked()) skills.append("Python ");
        if (cbWeb.isChecked()) skills.append("Web ");

        boolean subscribed = switchBtn.isChecked();

        // Final Output
        String result = "Name: " + name +
                "\nEmail: " + email +
                "\nGender: " + genderBtn.getText() +
                "\nSkills: " + skills.toString() +
                "\nSubscribed: " + (subscribed ? "Yes" : "No");

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}