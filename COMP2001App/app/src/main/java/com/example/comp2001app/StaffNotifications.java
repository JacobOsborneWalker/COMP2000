package com.example.comp2001app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StaffNotifications extends AppCompatActivity {

    private LinearLayout layoutNewNotifications;
    private LinearLayout layoutPastNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_notifications);

        layoutNewNotifications = findViewById(R.id.layoutNewNotifications);
        layoutPastNotifications = findViewById(R.id.layoutPastNotifications);

        // New Notifications Button
        Button buttonNewNotifications = findViewById(R.id.buttonNewNotifications);
        buttonNewNotifications.setOnClickListener(v -> {
            layoutNewNotifications.setVisibility(View.VISIBLE);
            layoutPastNotifications.setVisibility(View.GONE);
        });

        // Past Notifications Button
        Button buttonPastNotifications = findViewById(R.id.buttonPastNotifications);
        buttonPastNotifications.setOnClickListener(v -> {
            layoutPastNotifications.setVisibility(View.VISIBLE);
            layoutNewNotifications.setVisibility(View.GONE);
        });

        Button returnButton = findViewById(R.id.buttonReturn);
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(StaffNotifications.this, StaffPortal.class);
            startActivity(intent);
            finish();
        });

        layoutNewNotifications.setVisibility(View.VISIBLE);
        layoutPastNotifications.setVisibility(View.VISIBLE);
    }
}
