package com.example.comp2001app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginButton = findViewById(R.id.Login_Button);
        EditText usernameInput = findViewById(R.id.username_input);
        EditText passwordInput = findViewById(R.id.password_input);

        // Login button
        loginButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            String fullName = "";
            String userType = "";

          // staff
            if (username.equalsIgnoreCase("JohnSmith7")) {
                fullName = "John Smith";
                userType = "staff";
                if (!password.equals("Password")) {
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                // admin
            } else if (username.equalsIgnoreCase("DaveMathews1")) {
                fullName = "Dave Mathews";
                userType = "admin";
                if (!password.equals("AdminPassword")) {
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                // incorrect username
            } else {
                Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                return;
            }

            // Details
            SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Username", username);
            editor.putString("FullName", fullName);
            editor.putString("UserType", userType);
            editor.apply();


            Intent intent;
            if (userType.equalsIgnoreCase("staff")) {
                intent = new Intent(getApplicationContext(), StaffPortal.class);
            } else {
                intent = new Intent(getApplicationContext(), AdminPortal.class);
            }

            intent.putExtra("Username", username);
            intent.putExtra("FullName", fullName);
            intent.putExtra("UserType", userType);

            startActivity(intent);
        });
    }
}
