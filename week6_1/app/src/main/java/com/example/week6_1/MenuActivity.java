package com.example.week6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnCustomerManagement = findViewById(R.id.btnCustomerManagement);
        Button btnProductManagement = findViewById(R.id.btnProductManagement);
        Button btnSalesManagement = findViewById(R.id.btnSalesManagement);

        btnCustomerManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("menu", btnCustomerManagement.getText());

                setResult(RESULT_OK, intent);

                finish();
            }
        });

        btnProductManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("menu", btnProductManagement.getText());

                setResult(RESULT_OK, intent);

                finish();
            }
        });

        btnSalesManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("menu", btnSalesManagement.getText());

                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }
}