package com.example.comp2001app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class individualstaffview extends AppCompatActivity {

    // Declare the EditText for legal name
    private EditText legalname;
    private Button ReturnButton;  // Declare ReturnButton as private for consistency

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the layout file
        setContentView(R.layout.activity_individualstaffview);

        // Apply window insets for system bars (to handle system bars padding if required)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the 'Username' passed via Intent
        String username = getIntent().getStringExtra("button_name");

        // Find the EditText for 'LegalName' in the layout
        legalname = findViewById(R.id.LegalName);

        // Set the 'LegalName' field with the username received from Intent
        legalname.setText(username);

        // Initialize Return button and set onClick listener
        ReturnButton = findViewById(R.id.Return);
        ReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminPortal = new Intent(individualstaffview.this, AdminPortal.class);
                startActivity(adminPortal);
                finish();  // Optionally, close this activity
            }
        });
    }
}
