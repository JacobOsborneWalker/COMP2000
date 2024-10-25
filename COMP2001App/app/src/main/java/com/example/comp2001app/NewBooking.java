package com.example.comp2001app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class NewBooking extends AppCompatActivity {

    private EditText editTextStartDate;
    private EditText editTextEndDate;
    private TextView textViewDateDifference;
    private EditText editTextLegalName;
    private String fullName;

    private Date startDate;
    private Date endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_booking);

        fullName = getIntent().getStringExtra("FullName");

        editTextStartDate = findViewById(R.id.StartDate);
        editTextEndDate = findViewById(R.id.EndDate);
        textViewDateDifference = findViewById(R.id.textViewDateDifference);
        editTextLegalName = findViewById(R.id.LegalName);

        editTextStartDate.setOnClickListener(v -> showStartDatePickerDialog());
        editTextEndDate.setOnClickListener(v -> showEndDatePickerDialog());

        // return
        Button returnButton = findViewById(R.id.ReturnButton);
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(NewBooking.this, StaffPortal.class);
            startActivity(intent);
            finish();
        });

        // Verify
        Button verifyButton = findViewById(R.id.VerifyButton);
        verifyButton.setOnClickListener(v -> {
            if (startDate != null && endDate != null) {
                Toast.makeText(NewBooking.this, "Booking Request Sent", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(NewBooking.this, "Please select start and end dates first", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showStartDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                NewBooking.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editTextStartDate.setText(date);
                    startDate = createDate(selectedYear, selectedMonth, selectedDay);
                    calculateAndDisplayDateDifference();
                },
                year, month, day
        );

        datePickerDialog.show();
    }

    private void showEndDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                NewBooking.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editTextEndDate.setText(date);
                    endDate = createDate(selectedYear, selectedMonth, selectedDay);
                    calculateAndDisplayDateDifference();
                },
                year, month, day
        );

        datePickerDialog.show();
    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    private void calculateAndDisplayDateDifference() {
        if (startDate != null && endDate != null) {
            // Check if end date is before start date
            if (endDate.before(startDate)) {
                textViewDateDifference.setText("Please select a valid end date after the start date.");
                return;
            }

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            int weekdaysCount = 0;

            // Count weekdays
            while (!startCal.after(endCal)) {
                int dayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    weekdaysCount++;
                }
                startCal.add(Calendar.DAY_OF_MONTH, 1);
            }

            // Display the result
            textViewDateDifference.setText("Number of weekdays: " + weekdaysCount);
        }
    }
}
