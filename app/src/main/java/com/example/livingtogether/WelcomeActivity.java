package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWelcomeBinding binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSkip.setOnClickListener(v -> navigateToLogin());
        binding.btnGetStarted.setOnClickListener(v -> navigateToLogin());
    }

    private void navigateToLogin() {
        Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}