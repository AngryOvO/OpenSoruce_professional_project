package com.example.test4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switch1;
    RadioGroup group;
    RadioButton radio1, radio2, radio3;
    Button button1, button2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = findViewById(R.id.text1);
        switch1 = findViewById(R.id.switch1);

        text2 = findViewById(R.id.text2);
        group = findViewById(R.id.group);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        img = findViewById(R.id.img);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switch1.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.radio1:
                        img.setImageResource(R.drawable.pie);
                        break;
                    case R.id.radio2:
                        img.setImageResource(R.drawable.q10);
                        break;
                    case R.id.radio3:
                        img.setImageResource(R.drawable.r11);
                        break;
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch1.setChecked(false);
                radio1.setChecked(false);
                radio2.setChecked(false);
                radio3.setChecked(false);
                img.setImageResource(0);
            }
        });
    }
}