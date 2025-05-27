package com.ionichi.recyclerviewa;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView _recyclerView1;

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

        _recyclerView1 = findViewById(R.id.recyclerView1);

        List<CountryModel> countryModelList = new ArrayList<>();

        CountryModel cm = new CountryModel();
        cm.setName("Albania");
        cm.setDescription("Negara ini menggunakan bendera berwarna merah.");
        cm.setUrl("https://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/48/Albania-Flag-icon.png\n");
        countryModelList.add(cm);

        cm = new CountryModel();
        cm.setName("Hungary");
        cm.setDescription("Negara ini bernama Hungaria dalam bahasa Indonesia.");
        cm.setUrl("https://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/48/Hungary-Flag-icon.png");
        countryModelList.add(cm);

        cm = new CountryModel();
        cm.setName("Slovenia");
        cm.setDescription("Belm ada deskripsi untuk negara ini. Silahkan ditambahkan bagi yang mau.");
        cm.setUrl("https://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/48/Slovenia-Flag-icon.png");
        countryModelList.add(cm);

        cm = new CountryModel();
        cm.setName("Belgium");
        cm.setDescription("Namanya Belgia dalam bahasa Indonesia. Negara ini terdapat di Eropa.");
        cm.setUrl("https://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/48/Belgium-Flag-icon.png\n");
        countryModelList.add(cm);

        cm = new CountryModel();
        cm.setName("Canada");
        cm.setDescription("Negara ini terdapat di sebelah utara negara Amerika Serikat.");
        cm.setUrl("https://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/48/Canada-Flag-icon.png");
        countryModelList.add(cm);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
        _recyclerView1.setLayoutManager(lm);

        CountryAdapter ca = new CountryAdapter(this,countryModelList);
        _recyclerView1.setAdapter(ca);
    }
}