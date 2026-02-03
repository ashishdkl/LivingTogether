package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivitySeekerPreferencesBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SeekerPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySeekerPreferencesBinding binding = ActivitySeekerPreferencesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup dropdowns
        String[] roomTypes = new String[]{"Single Room", "Shared Room", "Apartment"};
        binding.actvRoomType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, roomTypes));

        String[] smokingPref = new String[]{"No", "Yes", "Occasionally"};
        binding.actvSmoking.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, smokingPref));

        String[] drinkingPref = new String[]{"No", "Yes", "Socially"};
        binding.actvDrinking.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, drinkingPref));

        String[] petsPref = new String[]{"Not allowed", "Allowed", "Depends on the pet"};
        binding.actvPets.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, petsPref));

        // Modern Date Picker implementation for Seeker Preferences
        binding.etMoveInDate.setOnClickListener(v -> {
            MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select Move-in Date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build();

            datePicker.addOnPositiveButtonClickListener(selection -> {
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateString = sdf.format(new Date(selection));
                binding.etMoveInDate.setText(dateString);
            });

            datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        });

        binding.btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, UserProfileActivity.class));
                return true;
            }
            return id == R.id.nav_home || id == R.id.nav_matches || id == R.id.nav_messages;
        });

        binding.btnSavePreferences.setOnClickListener(v -> {
            // Navigate to Room Dashboard
            Intent intent = new Intent(SeekerPreferencesActivity.this, RoomDashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
}