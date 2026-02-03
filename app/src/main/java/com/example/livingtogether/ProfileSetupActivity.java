package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityProfileSetupBinding;

public class ProfileSetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProfileSetupBinding binding = ActivityProfileSetupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup gender dropdown
        String[] genders = new String[]{"Female", "Male", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, genders);
        binding.actvGender.setAdapter(adapter);

        binding.btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        binding.btnSkip.setOnClickListener(v -> navigateToMain());

        binding.btnNext.setOnClickListener(v -> navigateToMain());
    }

    private void navigateToMain() {
        Intent intent = new Intent(ProfileSetupActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}