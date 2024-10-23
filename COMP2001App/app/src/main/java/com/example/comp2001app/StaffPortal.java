package com.example.comp2001app;

import android.content.Context;
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

public class StaffPortal extends AppCompatActivity {

    Button PersonalDetails;
    Button BookingsPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff_portal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        String fullName = sharedPreferences.getString("FullName", "Guest");
        String username = sharedPreferences.getString("Username", "Guest");

        TextView welcomeTextView = findViewById(R.id.welcome_text);
        welcomeTextView.setText("Welcome, " + fullName);

        PersonalDetails = findViewById(R.id.Info_Button);
        BookingsPage = findViewById(R.id.View_Holiday);

        PersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PersonalPage = new Intent(getApplicationContext(), PersonalDetailsPage.class);
                PersonalPage.putExtra("Username", username);
                PersonalPage.putExtra("FullName", fullName);
                startActivity(PersonalPage);
            }
        });

        BookingsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bookings = new Intent(getApplicationContext(), StaffBookings.class);
                startActivity(Bookings);
            }
        });
    }
}
