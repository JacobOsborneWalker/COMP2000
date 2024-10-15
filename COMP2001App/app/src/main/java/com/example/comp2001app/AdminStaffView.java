package com.example.comp2001app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdminStaffView extends AppCompatActivity {

    RecyclerView recyclerView;
    StaffAdapter staffAdapter;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_staff_view);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.staff_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of users (This data could come from a database)
        userList = new ArrayList<>();
        userList.add(new User("John Doe", R.drawable.ic_launcher_foreground));
        userList.add(new User("Jane Smith", R.drawable.ic_launcher_foreground));
        // Add more users here dynamically if needed

        // Set up the adapter with user data
        staffAdapter = new StaffAdapter(userList);
        recyclerView.setAdapter(staffAdapter);
    }
}
