package com.ionichi.emailform;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button _sendButton;
    private EditText _recipientEditText, _subjectEditText, _messageEditText;
    private static final int RC_NOTIFICATION = 23;

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

        if (!checkNotificationPermission()) {
            askNotificationPermission();
        }

        initSendButton();
    }

    private void initSendButton() {
        _sendButton = findViewById(R.id.sendButton);
        _recipientEditText = findViewById(R.id.recipientEditText);
        _subjectEditText = findViewById(R.id.subjectEditText);
        _messageEditText = findViewById(R.id.messageEditText);

        _sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNotificationPermission()) {
                    // min sdk 26 (android 8)
                    NotificationChannel channel = new NotificationChannel("ioChannel", "IO", NotificationManager.IMPORTANCE_DEFAULT);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.logo_yorionic)
                            .setContentTitle("Email from " + _recipientEditText.getText())
                            .setContentText(_subjectEditText.getText())
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(_subjectEditText.getText() + "\n" + _recipientEditText.getText() + ": " + _messageEditText.getText()))
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setChannelId(channel.getId());
//                        notification attach image
//                        .setStyle((new NotificationCompat.BigPictureStyle()
//                                .bigPicture(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.logo_yorionic))))

                    NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    manager.createNotificationChannel(channel);
                    manager.notify(1, builder.build());
                } else {
                    showPermissionDeniedDialog();
                }
            }
        });
    }

    private void askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, RC_NOTIFICATION);
            }
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, int deviceId) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId);
//        if (requestCode == RC_NOTIFICATION) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Allowed", Toast.LENGTH_SHORT).show();
//            } else {
//                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.POST_NOTIFICATIONS)) {
////                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
//                    showPermissionDeniedDialog();
//                }
//            }
//        }
//    }

    // show dialog when notification permission is denied permanent
    private void showPermissionDeniedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Izin Diperlukan")
            .setMessage("Aplikasi memerlukan izin notifikasi. Silakan aktifkan secara manual di Pengaturan.")
            .setPositiveButton("Buka Pengaturan", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            })
            .setNegativeButton("Batal", null)
            .show();
    }

    private boolean checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }
}