package com.ionichi.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button _loginButton;
    private EditText _idEditText, _passwordEditText;
    private Intent _menuIntent;
    private String _id, _password, _url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this); agar tidak menempel pada screen tepi pada WSA Emulator
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _idEditText = findViewById(R.id.idEditText);
        _passwordEditText = findViewById(R.id.passwordEditText);
        _loginButton = findViewById(R.id.loginButton);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _id = _idEditText.getText().toString();
                _password = _passwordEditText.getText().toString();

                _url = "https://stmikpontianak.cloud/011100862/login.php?id=" + _id + "&password=" + _password;
                Log.d("*ionichi*", "_url: " + _url);

                AsyncHttpClient ahc = new AsyncHttpClient();
                ahc.get(_url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int i, Header[] headers, byte[] bytes) {
                        String response = new String(bytes);
                        Log.d("*ionichi*", "response: " + response);

                        if (!response.equals("[{\"idCount\":\"1\"}]")) {
                            Toast.makeText(getApplicationContext(), "ID dan password anda tidak cocok.", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Toast.makeText(getApplicationContext(), "Selamat datang, " + _id, Toast.LENGTH_SHORT).show();

                        _menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                        _menuIntent.putExtra("userId", _id);

                        startActivity(_menuIntent);
                    }

                    @Override
                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                        Log.e("*ionichi*", "error: " + throwable.getMessage());
                        Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}