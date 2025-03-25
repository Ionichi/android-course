package com.ionichi.implicitintent;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
    }

    public void showTelephone(View view) {
        Intent telephoneIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(telephoneIntent);
    }

    public void showSMS(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_MAIN);
        smsIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(smsIntent);
    }

    public void showCalender(View view) {
        Intent calenderIntent = new Intent(Intent.ACTION_MAIN);
        calenderIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(calenderIntent);
    }

    public void showBrowser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_MAIN);
        browserIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(browserIntent);
    }

    public void showCalculator(View view) {
//        try {
//            Intent calculatorIntent = new Intent(Intent.ACTION_MAIN);
//            calculatorIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//
//            ComponentName cn = new ComponentName("com.android.calculator2", "com.android.calculator2.Calculator");
//            calculatorIntent.setComponent(cn);
//
//            startActivity(calculatorIntent);
//        } catch (ActivityNotFoundException anfe) {
//            Toast.makeText(getApplicationContext(), "Aplikasi tidak ditemukan", Toast.LENGTH_SHORT).show();
//        }

        ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();
        final PackageManager pm = getPackageManager();

        List<PackageInfo> packs = pm.getInstalledPackages(0);

        for (PackageInfo pi : packs) {
            String packageName = pi.packageName.toLowerCase();

            if (packageName.contains("calcul")) {
                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);

                items.add(map);
            }
        }

        if (!items.isEmpty()) {
            String packageName = (String) items.get(0).get("packageName");

            Intent i = pm.getLaunchIntentForPackage(packageName);

            if (i != null) {
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Tidak ditemukan aplikasi kalkulator", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showContact(View view) {
        Intent contactIntent = new Intent(Intent.ACTION_MAIN);
        contactIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(contactIntent);
    }

    public void showGallery(View view) {
        Intent galleryIntent = new Intent(Intent.ACTION_MAIN);
        galleryIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(galleryIntent);
    }

    public void showWifi(View view) {
        Intent wifiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(wifiIntent);
    }

    public void showSound(View view) {
        Intent soundIntent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(soundIntent);
    }

    public void showAirplaneMode(View view) {
        Intent airplaneModeIntent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(airplaneModeIntent);
    }

    public void showApplication(View view) {
        Intent applicationIntent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(applicationIntent);
    }

    public void showBluetooth(View view) {
        Intent bluetoothIntent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(bluetoothIntent);
    }
}