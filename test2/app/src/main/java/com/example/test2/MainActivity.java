package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit1, edit2;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    private TextView textResult;
    private String num1, num2;
    //    private int result; // 정수로 계산할 때
    private Double result;  // 실수로 계산할 때

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기 (수정)");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnMod = (Button) findViewById(R.id.BtnMod);

        textResult = (TextView) findViewById(R.id.TextResult);

        // 더하기
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값을 입력하지 않았을 때 오류 메시지 토스트
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
//                result = Integer.parseInt(num1) + Integer.parseInt(num2);   // 정수로 계산할때
                result = Double.parseDouble(num1) + Double.parseDouble(num2);   // 실수로 계산할때
                textResult.setText("계산 결과 : " + result);
            }
        });

        // 빼기
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값을 입력하지 않았을 때 오류 메시지 토스트
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                //                result = Integer.parseInt(num1) - Integer.parseInt(num2);   // 정수로 계산할때
                result = Double.parseDouble(num1) - Double.parseDouble(num2);   // 실수로 계산할때
                textResult.setText("계산 결과 : " + result);
            }
        });

        // 곱셈
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값을 입력하지 않았을 때 오류 메시지 토스트
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
//                result = Integer.parseInt(num1) * Integer.parseInt(num2);   // 정수로 계산할때
                result = Double.parseDouble(num1) * Double.parseDouble(num2);   // 실수로 계산할때
                textResult.setText("계산 결과 : " + result);
            }
        });

        // 나누기
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값을 입력하지 않았을 때 오류 메시지 토스트
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 0으로 나눌 시 토스트 메세지와 계산 안함
                if (edit2.getText().toString().equals("0")) {
                    Toast.makeText(MainActivity.this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
//                result = Integer.parseInt(num1) / Integer.parseInt(num2);   // 정수로 계산할때
                result = Double.parseDouble(num1) / Double.parseDouble(num2);   // 실수로 계산할때
                textResult.setText("계산 결과 : " + result);
            }
        });

        // 나머지
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값을 입력하지 않았을 때 오류 메시지 토스트
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
//                result = Integer.parseInt(num1) % Integer.parseInt(num2);   // 정수로 계산할때
                result = Double.parseDouble(num1) % Double.parseDouble(num2);   // 실수로 계산할때
                textResult.setText("계산 결과 : " + result);
            }
        });
    }
}