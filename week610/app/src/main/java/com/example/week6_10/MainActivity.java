package com.example.week6_10;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";

    private Button btnDial, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("액티비티 테스트 예제");

        Log.i(TAG, "onCreate()");

        init();
        initLr();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    public void init(){
        btnDial = findViewById(R.id.btnDial);
        btnEnd = findViewById(R.id.btnEnd);
    }

    public void initLr(){
        btnDial.setOnClickListener(v ->{
            Uri uri = Uri.parse("tel:01012345678");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        });
        btnEnd.setOnClickListener(v ->{
            finish();
        });
    }
}