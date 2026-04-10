package com.example.menuss;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    TextView txtOptions, txtContext, txtPopup;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOptions = findViewById(R.id.txtOptions);
        txtContext = findViewById(R.id.txtContext);
        txtPopup = findViewById(R.id.txtPopup);
        btnPopup = findViewById(R.id.btnPopup);

        // ---------------- CONTEXT MENU ----------------
        registerForContextMenu(txtContext);

        // ---------------- POPUP MENU ----------------
        btnPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopup);
            popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                txtPopup.setText("Selected: " + item.getTitle());
                Toast.makeText(MainActivity.this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });
    }

    // ---------------- OPTIONS MENU ----------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_settings){
            txtOptions.setText("Settings Selected");
            Toast.makeText(this,"Settings Clicked",Toast.LENGTH_SHORT).show();
        } else if(id == R.id.menu_profile){
            txtOptions.setText("Profile Selected");
            Toast.makeText(this,"Profile Clicked",Toast.LENGTH_SHORT).show();
        } else if(id == R.id.menu_logout){
            txtOptions.setText("Logout Selected");
            Toast.makeText(this,"Logout Clicked",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    // ---------------- CONTEXT MENU ----------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.txtContext){
            getMenuInflater().inflate(R.menu.context, menu);
            menu.setHeaderTitle("Choose Color");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.context_red){
            txtContext.setTextColor(Color.RED);
            Toast.makeText(this,"Red Selected",Toast.LENGTH_SHORT).show();
        } else if(id == R.id.context_green){
            txtContext.setTextColor(Color.GREEN);
            Toast.makeText(this,"Green Selected",Toast.LENGTH_SHORT).show();
        } else if(id == R.id.context_blue){
            txtContext.setTextColor(Color.BLUE);
            Toast.makeText(this,"Blue Selected",Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}