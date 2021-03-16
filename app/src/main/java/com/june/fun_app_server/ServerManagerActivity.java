package com.june.fun_app_server;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.june.R;

public class ServerManagerActivity extends AppCompatActivity {

    private Button button1,button2;
    private ServerManager serverManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_manager);

        button1 = findViewById(R.id.button_start);
        button2 = findViewById(R.id.button_stop);
        serverManager = new ServerManager(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serverManager.startServer();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serverManager.stopServer();
            }
        });

    }
}