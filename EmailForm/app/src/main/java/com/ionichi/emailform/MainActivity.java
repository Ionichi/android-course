package com.ionichi.emailform;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button _sendButton;
    private EditText _recipientEditText, _subjectEditText, _messageEditText;

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
//                        notif gambar
//                        .setStyle((new NotificationCompat.BigPictureStyle()
//                                .bigPicture(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.logo_yorionic))))

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                manager.notify(1, builder.build());
            }
        });
    }
}