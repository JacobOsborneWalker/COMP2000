package com.example.comp2001app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminPortal extends AppCompatActivity {

    Button StaffViewButton;
    Button PersonalDetails;
    Button NotificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_portal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        String fullName = sharedPreferences.getString("FullName", "Guest");
        String username = sharedPreferences.getString("Username", "Guest");

        // welcome message
        TextView welcomeTextView = findViewById(R.id.welcome_text);
        welcomeTextView.setText("Welcome, " + fullName + "!");

        // buttons
        StaffViewButton = findViewById(R.id.StaffMangement);
        PersonalDetails = findViewById(R.id.Info_Button);
        NotificationButton = findViewById(R.id.Notifications);

        // staff view
        StaffViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent StaffPage = new Intent(getApplicationContext(), AdminStaffView.class);
                startActivity(StaffPage);
            }
        });

        // personal details
        PersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PersonalPage = new Intent(getApplicationContext(), PersonalDetailsPage.class);
                PersonalPage.putExtra("Username", username);
                PersonalPage.putExtra("FullName", fullName);
                startActivity(PersonalPage);
            }
        });

        // notifications
        NotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AdminNotifications = new Intent(getApplicationContext(), AdminNotifications.class);
                startActivity(AdminNotifications);
            }
        });
    }
}
