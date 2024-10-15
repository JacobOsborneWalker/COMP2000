package com.example.comp2001app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {

    private List<User> userList;

    // Constructor to pass in the user list
    public StaffAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each user item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_profile_item, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        // Get the current user
        User currentUser = userList.get(position);

        // Bind user data to the view
        holder.profileName.setText(currentUser.getName());
        holder.profileImage.setImageResource(currentUser.getImageResId());  // Assuming the image is a resource drawable
    }

    @Override
    public int getItemCount() {
        return userList.size();  // Return the number of users
    }

    // ViewHolder class to hold the views for each user item
    public static class StaffViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView profileName;

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            profileName = itemView.findViewById(R.id.profile_name);
        }
    }
}
