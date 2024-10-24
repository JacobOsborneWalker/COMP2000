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

public class StaffBookings extends AppCompatActivity {

    Button UpcomingButton;
    Button PastButton;
    Button PendingButton;
    Button Return;
    Button AddBooking;
    TextView UpcomingData;
    TextView PastData;
    TextView PendingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff_bookings);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String fullName = getIntent().getStringExtra("FullName");

        // setting the buttons
        UpcomingButton = findViewById(R.id.UpcomingHoliday);
        PastButton = findViewById(R.id.PastHoliday);
        PendingButton = findViewById(R.id.PendingHolidays);
        Return = findViewById(R.id.Return);
        AddBooking = findViewById(R.id.NewBooking);
        UpcomingData = findViewById(R.id.UpcomingHolidayData);
        PastData = findViewById(R.id.PastHolidayData);
        PendingData = findViewById(R.id.PendignHolidaysData);

        // hiding data
        PastData.setVisibility(View.GONE);
        PendingData.setVisibility(View.GONE);

        // Upcoming holidays
        String upcomingHolidays = fullName + "\n" +
                "Break #1: \n" +
                "StartDate: 07/01/2025  EndDate: 11/01/2025 \n" +
                "Reason: Personal Holiday \n" +
                "\n" +
                "Break #2: \n" +
                "StartDate: 12/03/2025  EndDate: 13/03/2025 \n" +
                "Reason: Family visit \n" +
                "\n" +
                "Break #3: \n" +
                "StartDate: 04/02/2025  EndDate: 05/02/2025 \n" +
                "Reason: Personal Holiday \n";

        // pending holidays
        String pendingHoliday = fullName + "\n" +
                "No Upcoming Pending breaks";

        // past holidays
        String pastHoliday = fullName + "\n" +
                "No Past Holidays";

        UpcomingData.setText(upcomingHolidays);
        PastData.setText(pastHoliday);
        PendingData.setText(pendingHoliday);
        UpcomingData.setVisibility(View.VISIBLE);

        // upcoming data
        UpcomingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UpcomingData.getVisibility() == View.GONE) {
                    UpcomingData.setVisibility(View.VISIBLE);
                } else {
                    UpcomingData.setVisibility(View.GONE);
                }
            }
        });

        // past data
        PastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PastData.getVisibility() == View.GONE) {
                    PastData.setVisibility(View.VISIBLE);
                } else {
                    PastData.setVisibility(View.GONE);
                }
            }
        });

        // pending data
        PendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PendingData.getVisibility() == View.GONE) {
                    PendingData.setVisibility(View.VISIBLE);
                } else {
                    PendingData.setVisibility(View.GONE);
                }
            }
        });

        // return button
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent staffPortal = new Intent(getApplicationContext(), StaffPortal.class);
                startActivity(staffPortal);
            }
        });

        // booking page
        AddBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookingsPage = new Intent(getApplicationContext(), NewBooking.class);
                bookingsPage.putExtra("FullName", fullName);
                startActivity(bookingsPage);
            }
        });
    }
}
