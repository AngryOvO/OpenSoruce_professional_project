package com.example.test6;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    RadioButton rCal, rTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = findViewById(R.id.chronometer);
        rCal = findViewById(R.id.rCal);
        rTime = findViewById(R.id.rTime);
        dPicker = findViewById(R.id.dPicker);
        tPicker = findViewById(R.id.tPicker);
        tView = findViewById(R.id.tView);

        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });
        rTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        chrono.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                rCal.setVisibility(View.VISIBLE);
                rTime.setVisibility(View.VISIBLE);
            }
        });

        tView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                String dateStr = dPicker.getYear() + "년" + (dPicker.getMonth() + 1) + "월" +
                        dPicker.getDayOfMonth() + "일" + tPicker.getCurrentHour() + "시" +
                        tPicker.getCurrentMinute() + "분" + " 예약됨";
                tView.setText(dateStr);

                rCal.setVisibility(View.INVISIBLE);
                rTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }
}