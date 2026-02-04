package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        binding.cardHaveRoom.setOnClickListener(v -> {
            binding.checkHaveRoom.setImageResource(R.drawable.ic_check_circle);
            binding.checkNeedRoom.setImageResource(R.drawable.ic_radio_unchecked);
            startActivity(new Intent(MainActivity.this, AddRoomActivity.class));
        });

        binding.cardNeedRoom.setOnClickListener(v -> {
            binding.checkNeedRoom.setImageResource(R.drawable.ic_check_circle);
            binding.checkHaveRoom.setImageResource(R.drawable.ic_radio_unchecked);
            startActivity(new Intent(MainActivity.this, SeekerPreferencesActivity.class));
        });

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, UserProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                return true;
            } else if (id == R.id.nav_messages) {
                Toast.makeText(this, "Messages feature coming soon!", Toast.LENGTH_SHORT).show();
                return false; 
            }
            return id == R.id.nav_home || id == R.id.nav_matches;
        });
    }
}