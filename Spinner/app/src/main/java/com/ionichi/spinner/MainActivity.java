package com.ionichi.spinner;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner _spinner1, _spinner2, _spinner3, _spinner4, _spinner5;

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

        initSpinner1();
        initSpinner2();
        initSpinner3();
        initSpinner4();
        initSpinner5();
    }

    private void initSpinner1() {
        _spinner1 = findViewById(R.id.spinner1);

        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("Rambutan");
        fruitsList.add("Langsat");
        fruitsList.add("Durian");
        fruitsList.add("Nangka");
        fruitsList.add("Mangga");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruitsList);
        _spinner1.setAdapter(arrayAdapter);
    }

    private void initSpinner2() {
        _spinner2 = findViewById(R.id.spinner2);

        List<String> studentList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            studentList.add("Mahasiswa ke-" + i);
        }

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        _spinner2.setAdapter(arrayAdapter2);
    }

    private void initSpinner3() {
        _spinner3 = findViewById(R.id.spinner3);

        List<String> oddList = new ArrayList<>();

        for (int i = 1; i <= 999; i += 2) {
            oddList.add("Bilangan (ganjil) ke-" + i);
        }

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, oddList);
        _spinner3.setAdapter(arrayAdapter3);
    }

    private void initSpinner4() {
        _spinner4 = findViewById(R.id.spinner4);

        List<String> evenList = new ArrayList<>();

        for (int i = 2; i <= 1000; i += 2) {
            evenList.add("Bilangan (genap) ke-" + i);
        }

        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, evenList);
        _spinner4.setAdapter(arrayAdapter4);
    }

    private void initSpinner5() {
        _spinner5 = findViewById(R.id.spinner5);

        List<String> primeList = new ArrayList<>();

//        outer:
//        for (int i = 2; i <= 1000; i++) {
//            for (int j = 2; j < i - 1; j++) {
//                if (i % j == 0) {
//                    continue outer;
//                }
//            }
//            primeList.add("Bilangan (prima) ke-" + i);
//        }

        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primeList.add("Bilangan (prima) ke-" + i);
        }

        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, primeList);
        _spinner5.setAdapter(arrayAdapter5);
    }

//    // method for check is prime number or not
//    private boolean isPrime(int number) {
//        if (number < 2) return false;
//
//        for (int i = 2; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}