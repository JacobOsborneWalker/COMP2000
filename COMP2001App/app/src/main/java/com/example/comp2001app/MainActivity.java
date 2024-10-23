package com.example.comp2001app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        // login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();

                String fullName = "";
                // staff name
                if (username.equalsIgnoreCase("staff")) {
                    fullName = "John Smith";
                }
                // admin name
                else if (username.equalsIgnoreCase("admin")) {
                    fullName = "Dave Mathews";
                }

                if (!fullName.isEmpty()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Username", username);
                    editor.putString("FullName", fullName);
                    editor.apply();

                    // admin or staff
                    Intent intent;
                    if (username.equalsIgnoreCase("staff")) {
                        intent = new Intent(getApplicationContext(), StaffPortal.class);
                    } else {
                        intent = new Intent(getApplicationContext(), AdminPortal.class);
                    }
                    startActivity(intent);
                }
            }
        });
    }
}
