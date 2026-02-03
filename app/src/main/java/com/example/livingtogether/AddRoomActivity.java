package com.example.livingtogether;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.livingtogether.databinding.ActivityAddRoomBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AddRoomActivity extends AppCompatActivity {

    private ActivityAddRoomBinding binding;
    private final ActivityResultLauncher<Intent> mapResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    double lat = result.getData().getDoubleExtra("latitude", 0);
                    double lng = result.getData().getDoubleExtra("longitude", 0);
                    String locationText = String.format(Locale.getDefault(), "Lat: %.4f, Lng: %.4f", lat, lng);
                    binding.actvLocation.setText(locationText);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup dropdowns
        String[] locations = new String[]{"Baneshwor", "Patan", "Thamel", "Kirtipur"};
        binding.actvLocation.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations));

        String[] roomTypes = new String[]{"Single Room", "Shared Room", "Full Apartment"};
        binding.actvRoomType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, roomTypes));

        String[] amenities = new String[]{"Wi-Fi", "Kitchen", "Parking", "Attached Bathroom"};
        binding.actvAmenities.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, amenities));

        // Modern Date Picker implementation
        binding.etAvailableFrom.setOnClickListener(v -> {
            MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select Availability Date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build();

            datePicker.addOnPositiveButtonClickListener(selection -> {
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateString = sdf.format(new Date(selection));
                binding.etAvailableFrom.setText(dateString);
            });

            datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        });

        // Map selection
        binding.btnSelectMap.setOnClickListener(v -> {
            Intent intent = new Intent(this, MapPickerActivity.class);
            mapResultLauncher.launch(intent);
        });

        binding.btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        binding.btnSubmit.setOnClickListener(v -> {
            // Navigate to Roommate Preferences after room details
            Intent intent = new Intent(AddRoomActivity.this, RoommatePreferencesActivity.class);
            startActivity(intent);
            finish();
        });
    }
}