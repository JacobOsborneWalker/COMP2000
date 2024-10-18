package com.example.comp2001app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminNotifications extends AppCompatActivity {

    private Spinner spinner1; // First spinner to show user information
    private LinearLayout userInfoLayout; // Layout to hold user information
    private LinearLayout pastDaysOffLayout; // Layout to hold past days off

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notifications);

        spinner1 = findViewById(R.id.spinner1);
        Button acceptButton = findViewById(R.id.acceptButton);
        Button declineButton = findViewById(R.id.declineButton);
        userInfoLayout = findViewById(R.id.userInfoLayout);
        pastDaysOffLayout = findViewById(R.id.pastDaysOffLayout);

        // Create list of options for spinner 1 (user information)
        List<SpinnerItem> spinnerItems = new ArrayList<>();
        spinnerItems.add(new SpinnerItem("Arthur Dent", "11/11/2024 - 01/12/2024", "No Additional Information", "ID001"));
        spinnerItems.add(new SpinnerItem("Doctor Who", "02/11/2024 - 04/11/2024", "Medical Appointment", "ID002"));
        spinnerItems.add(new SpinnerItem("Joe Biden", "07/12/2024 - 25/12/2024", "No Additional Information", "ID003"));

        // Adapter for Spinner 1
        ArrayAdapter<SpinnerItem> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        // Set listener for item selection on Spinner 1
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showUserInfo(spinnerItems.get(position)); // Show information for selected user
                showPastDaysOff(spinnerItems.get(position).getPastDaysOff()); // Show past days off for the selected user
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                userInfoLayout.removeAllViews(); // Clear user info if nothing is selected
                pastDaysOffLayout.removeAllViews(); // Clear past days off if nothing is selected
            }
        });

        // Handle Accept button click for Spinner 1 selection
        acceptButton.setOnClickListener(v -> {
            if (spinner1.getSelectedItem() != null) {
                String message = "Accepted: " + spinner1.getSelectedItem().toString();
                Toast.makeText(AdminNotifications.this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(AdminNotifications.this, "No option selected from Drop-down 1", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Decline button click
        declineButton.setOnClickListener(v -> {
            Toast.makeText(AdminNotifications.this, "Declined", Toast.LENGTH_SHORT).show();
        });
    }

    private void showUserInfo(SpinnerItem item) {
        // Clear existing views
        userInfoLayout.removeAllViews();

        // Create and display TextViews for the selected user
        TextView idTextView = new TextView(this);
        idTextView.setText("Request ID: " + item.getId());
        idTextView.setTextSize(18);
        userInfoLayout.addView(idTextView);

        TextView nameTextView = new TextView(this);
        nameTextView.setText("Name: " + item.getName());
        nameTextView.setTextSize(18);
        userInfoLayout.addView(nameTextView);

        TextView datesTextView = new TextView(this);
        datesTextView.setText("Dates: " + item.getDates());
        datesTextView.setTextSize(16);
        userInfoLayout.addView(datesTextView);

        TextView additionalTextView = new TextView(this);
        additionalTextView.setText("Additional Info: " + item.getAdditionalText());
        additionalTextView.setTextSize(16);
        userInfoLayout.addView(additionalTextView);
    }

    private void showPastDaysOff(List<PastDayOff> pastDaysOff) {
        // Clear existing views
        pastDaysOffLayout.removeAllViews();

        // Add each past day off to the layout
        for (PastDayOff dayOff : pastDaysOff) {
            TextView pastDayTextView = new TextView(this);
            String displayText = String.format("Name: %s\nEnd Date: %s\nRequest ID: %s\nAdditional Info: %s\n",
                    dayOff.getName(), dayOff.getEndDate(), dayOff.getId(), dayOff.getAdditionalInfo());
            pastDayTextView.setText(displayText); // Set the text to the past day off
            pastDayTextView.setTextSize(16);  // Set desired text size
            pastDaysOffLayout.addView(pastDayTextView); // Add to the layout
        }
    }

    // SpinnerItem class to hold the data for each item
    private static class SpinnerItem {
        private final String name;
        private final String dates;
        private final String additionalText;
        private final String id; // Added ID field
        private final List<PastDayOff> pastDaysOff; // List of past days off

        public SpinnerItem(String name, String dates, String additionalText, String id) {
            this.name = name;
            this.dates = dates;
            this.additionalText = additionalText;
            this.id = id; // Initialize ID
            this.pastDaysOff = new ArrayList<>(); // Initialize past days off list
            generatePastDaysOff(); // Populate the list with example data
        }

        public String getName() {
            return name;
        }

        public String getDates() {
            return dates;
        }

        public String getAdditionalText() {
            return additionalText;
        }

        public String getId() {
            return id; // Added getter for ID
        }

        public List<PastDayOff> getPastDaysOff() {
            return pastDaysOff; // Getter for past days off
        }

        private void generatePastDaysOff() {
            // Example data for past days off, including name, end date, ID, and additional information
            pastDaysOff.add(new PastDayOff(name, "10/01/2024", id, "Vacation"));
            pastDaysOff.add(new PastDayOff(name, "15/01/2024", id, "Sick Leave"));
            pastDaysOff.add(new PastDayOff(name, "20/01/2024", id, "Personal Leave"));
            // You can modify this method to fetch or generate real past days off data as needed.
        }

        @Override
        public String toString() {
            return name;  // Display the name in the spinner's default view
        }
    }

    // PastDayOff class to hold the data for past days off
    private static class PastDayOff {
        private final String name;
        private final String endDate;
        private final String id;
        private final String additionalInfo;

        public PastDayOff(String name, String endDate, String id, String additionalInfo) {
            this.name = name;
            this.endDate = endDate;
            this.id = id;
            this.additionalInfo = additionalInfo;
        }

        public String getName() {
            return name;
        }

        public String getEndDate() {
            return endDate;
        }

        public String getId() {
            return id;
        }

        public String getAdditionalInfo() {
            return additionalInfo;
        }
    }
}
