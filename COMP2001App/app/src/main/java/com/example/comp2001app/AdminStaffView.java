package com.example.comp2001app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminStaffView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_staff_view);


        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);


        button1.setOnClickListener(v -> openDetailsPage(button1));
        button2.setOnClickListener(v -> openDetailsPage(button2));
        button3.setOnClickListener(v -> openDetailsPage(button3));
        button4.setOnClickListener(v -> openDetailsPage(button4));
        button5.setOnClickListener(v -> openDetailsPage(button5));
        button6.setOnClickListener(v -> openDetailsPage(button6));
        button7.setOnClickListener(v -> openDetailsPage(button7));
        button8.setOnClickListener(v -> openDetailsPage(button8));
    }

    // Method to open the details page and pass the button name
    private void openDetailsPage(Button button) {
        // Set the click listener for each button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the button's text (the name displayed on the button)
                String buttonText = button.getText().toString();

                // Start the next activity and pass the button's name
                Intent intent = new Intent(AdminStaffView.this, individualstaffview.class);
                intent.putExtra("button_name", buttonText);
                startActivity(intent);
            }
        });
    }
}
