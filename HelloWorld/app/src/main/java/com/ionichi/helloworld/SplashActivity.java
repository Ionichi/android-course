package com.ionichi.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        int SPLASH_DURATION = 1500;

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            // override transistion untuk API 34 keatas (android 14)
            // overrideActivityTransition(
            //        OVERRIDE_TRANSITION_OPEN, // Jenis transisi (buka atau tutup)
            //        R.anim.slide_in_right,    // Animasi masuk
            //        R.anim.slide_out_left,    // Animasi keluar
            //        Color.WHITE               // Warna latar belakang
            // );

            finish(); // tutup splash agar tidak bisa back
        }, SPLASH_DURATION);

    }
}
