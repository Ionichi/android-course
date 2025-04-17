
package com.ionichi.customspinner;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner1 = findViewById(R.id.spinner1);

        List<String> countryList = new ArrayList<>();
        countryList.add("Albania");
        countryList.add("Belgia");
        countryList.add("Hungary");
        countryList.add("Iran");
        countryList.add("Slovenia");

        CountryAdapter ca = new CountryAdapter(getApplicationContext(), countryList);
        spinner1.setAdapter(ca);
    }
}