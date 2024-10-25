package com.example.comp2001app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonalDetailsPage extends AppCompatActivity {

    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve name and username
        String username = getIntent().getStringExtra("Username");
        String fullName = getIntent().getStringExtra("FullName");
        String userType = getIntent().getStringExtra("UserType");

        // Find and set TextViews
        TextView usernameTextView = findViewById(R.id.Username);
        TextView nameTextView = findViewById(R.id.LegalName);


        usernameTextView.setText(username);
        nameTextView.setText(fullName);


        // Return button
        returnButton = findViewById(R.id.Return);
        returnButton.setOnClickListener(v -> {
            Intent intent;
            if (userType != null && userType.equalsIgnoreCase("staff")) {
                intent = new Intent(getApplicationContext(), StaffPortal.class);
            } else {
                intent = new Intent(getApplicationContext(), AdminPortal.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
