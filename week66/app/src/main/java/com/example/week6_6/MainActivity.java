package com.example.week6_6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initLr();
    }

    public void init(){
        btnNewActivity = findViewById(R.id.btnNewActivity);
    }

    public void initLr(){
        btnNewActivity.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), second.class);
            startActivity(intent);
        });
    }
}