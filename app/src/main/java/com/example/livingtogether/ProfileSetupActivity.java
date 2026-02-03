package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityProfileSetupBinding;

public class ProfileSetupActivity extends AppCompatActivity {

    private ActivityProfileSetupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileSetupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup gender dropdown
        String[] genders = new String[]{"Female", "Male", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, genders);
        binding.actvGender.setAdapter(adapter);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMain();
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For now, navigate to main as it's the last step in this task
                navigateToMain();
            }
        });
    }

    private void navigateToMain() {
        Intent intent = new Intent(ProfileSetupActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}