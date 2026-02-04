package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.livingtogether.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
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
            } else if (id == R.id.nav_matches) {
                loadFragment(new MatchesFragment());
                return true;
            } else if (id == R.id.nav_home) {
                hideFragmentContainer();
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        // Hide the main dashboard scroll view and show the fragment container
        binding.mainContentScroll.setVisibility(View.GONE);
        binding.fragmentContainer.setVisibility(View.VISIBLE);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    private void hideFragmentContainer() {
        // Show the main dashboard scroll view and hide the fragment container
        binding.mainContentScroll.setVisibility(View.VISIBLE);
        binding.fragmentContainer.setVisibility(View.GONE);
    }
}