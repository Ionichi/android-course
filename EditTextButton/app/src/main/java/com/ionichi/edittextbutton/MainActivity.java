package com.ionichi.edittextbutton;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button okeButton = (Button) findViewById(R.id.okeButton);

        okeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
                String name = nameEditText.getText().toString();
                String message;
                boolean isValid = false;
                if (!name.isEmpty()) {
                    message = "Hello, " + name + "!";
                    isValid = true;
                } else {
                    message = "Mohon isi nama anda!";
                }
                TextView infoTextView = (TextView) findViewById(R.id.infoTextView);
                infoTextView.setText(message);

                TypedValue typedValue = new TypedValue();
                getTheme().resolveAttribute(com.google.android.material.R.attr.colorOnBackground, typedValue, true);
                int textColor = typedValue.data;

                infoTextView.setTextColor(isValid ? textColor : Color.RED);
            }
        });
    }
}