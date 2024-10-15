package com.example.comp2001app;

import android.content.Intent;
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

        // buttons and text
        loginButton = findViewById(R.id.Login_Button);
        EditText Usernamegiven = findViewById(R.id.username_input);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Username = Usernamegiven.getText().toString();
                if(Username.equals("Staff")){
                    Intent stafflogin = new Intent(getApplicationContext(), StaffPortal.class);
                    startActivity(stafflogin);
                } else{
                    Intent adminlogin = new Intent(getApplicationContext(), AdminPortal.class);
                    startActivity(adminlogin);
                }

            }
        });
    }
}