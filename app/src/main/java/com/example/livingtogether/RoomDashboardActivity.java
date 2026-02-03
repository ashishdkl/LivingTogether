package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityRoomDashboardBinding;

public class RoomDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRoomDashboardBinding binding = ActivityRoomDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setSelectedItemId(R.id.nav_home);
        
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, UserProfileActivity.class));
                return true;
            } else if (id == R.id.nav_home) {
                return true;
            }
            return false;
        });

        binding.btnMenu.setOnClickListener(v -> {
            // Open navigation drawer or menu logic
        });

        binding.btnViewListing.setOnClickListener(v -> {
            // Navigate to full room details
        });
    }
}