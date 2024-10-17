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

public class AdminPortal extends AppCompatActivity {

    Button StaffViewButton;  // Declaration of the button
    Button PersonalDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_portal);

        // Adjust for system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the button from layout
        StaffViewButton = findViewById(R.id.StaffMangement);
        PersonalDetails = findViewById(R.id.Info_Button);

        // Set onClickListener to handle button press
        StaffViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the AdminStaffView activity when the button is clicked
                Intent StaffPage = new Intent(getApplicationContext(), AdminStaffView.class);
                startActivity(StaffPage);
            }
        });

        // Set a click listener on the button
        PersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the PersonalDetailsPage activity
                Intent PersonalPage = new Intent(getApplicationContext(), PersonalDetailsPage.class);
                startActivity(PersonalPage);
            }
        });
    }
}
