package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityRoomDashboardBinding;

public class RoomDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRoomDashboardBinding binding = ActivityRoomDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // The ID inside layout_footer.xml is bottom_navigation.
        // In the include tag in activity_room_dashboard.xml, the ID is also bottom_navigation.
        // Therefore, ViewBinding generates binding.bottomNavigation (for the include)
        // and inside that, binding.bottomNavigation.bottomNavigation (for the view).
        binding.bottomNavigation.bottomNavigation.setSelectedItemId(R.id.nav_home);
        
        binding.bottomNavigation.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, UserProfileActivity.class));
                return true;
            } else if (id == R.id.nav_messages) {
                Toast.makeText(this, "Messages feature coming soon!", Toast.LENGTH_SHORT).show();
                return false;
            }
            return id == R.id.nav_home;
        });

        binding.btnMenu.setOnClickListener(v -> {
            // Open navigation drawer or menu logic
        });

        binding.btnViewListing.setOnClickListener(v -> {
            // Navigate to full room details
        });
    }
}