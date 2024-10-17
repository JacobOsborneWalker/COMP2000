package com.example.comp2001app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonalDetailsPage extends AppCompatActivity {

    String username;
    Button ReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details_page);

        // Retrieve the username passed from the previous activity
        username = getIntent().getStringExtra("Username");

        // Setting up insets for the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Return button and set onClick listener
        ReturnButton = findViewById(R.id.Return);
        ReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.equals("Staff")) {
                    Intent StaffPortal = new Intent(getApplicationContext(), StaffPortal.class);
                    startActivity(StaffPortal);
                } else {
                    Intent AdminPortal = new Intent(getApplicationContext(), AdminPortal.class);
                    startActivity(AdminPortal);
                }
            }
        });
    }
}
