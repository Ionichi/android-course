package com.ionichi.webview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button _showButton;
    private EditText _urlEditText;
    private WebView _webView;

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

        _showButton = (Button) findViewById(R.id.showButton);
        _urlEditText = (EditText) findViewById(R.id.urlEditText);
        _webView = (WebView) findViewById(R.id.webView);
    }

    public void showButtonOnClick(View view) {
        String url = _urlEditText.getText().toString();
        if (!url.contains("https://")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("URL INVALID")
                    .setMessage("URL tidak dimulai dengan https://")
                    .setPositiveButton("Oke", null)
                    .show();
        } else {
            _webView.setWebViewClient((new WebViewClient()));
            _webView.loadUrl(url);;
        }
    }
}