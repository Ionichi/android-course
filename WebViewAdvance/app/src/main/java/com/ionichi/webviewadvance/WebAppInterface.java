package com.ionichi.webviewadvance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    private Activity _activity;
    private Context _context;

    public WebAppInterface(Context context, Activity activity) {
        _context = context;
        _activity = activity;
    }

    @JavascriptInterface
    public void showToast(String message) {
        Toast.makeText(_context, message, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showSms() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        _context.startActivity(intent);
    }
}
