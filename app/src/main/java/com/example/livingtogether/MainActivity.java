package com.example.livingtogether;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
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
            Toast.makeText(this, R.string.have_room_title, Toast.LENGTH_SHORT).show();
        });

        binding.cardNeedRoom.setOnClickListener(v -> {
            binding.checkNeedRoom.setImageResource(R.drawable.ic_check_circle);
            binding.checkHaveRoom.setImageResource(R.drawable.ic_radio_unchecked);
            Toast.makeText(this, R.string.need_room_title, Toast.LENGTH_SHORT).show();
        });

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            return id == R.id.nav_home || id == R.id.nav_matches || id == R.id.nav_messages || id == R.id.nav_profile;
        });
    }
}