package com.example.time_date_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    RadioButton rdoCal, rdoTime;
    CalendarView Cal;
    TimePicker TimePicker;
    TextView tvYear, tvMonth, tvDay, tvTime, tvMin;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chronometer = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        TimePicker = (TimePicker) findViewById(R.id.tPicker);
        Cal = (CalendarView) findViewById(R.id.Cal1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvMin = (TextView) findViewById(R.id.tvMin);
        tvTime = (TextView) findViewById(R.id.tvTime);

        TimePicker.setVisibility(View.INVISIBLE);
        Cal.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker.setVisibility(View.VISIBLE);
                Cal.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker.setVisibility(View.INVISIBLE);
                Cal.setVisibility(View.VISIBLE);
            }
        });

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                TimePicker.setVisibility(View.INVISIBLE);
                Cal.setVisibility(View.INVISIBLE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvTime.setText(Integer.toString(TimePicker.getCurrentHour()));
                tvMin.setText(Integer.toString(TimePicker.getCurrentMinute()));
                return false;
            }
        });

        Cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int Year, int Month, int Day) {
                selectYear = Year;
                selectMonth = Month;
                selectDay = Day;
            }
        });
    }
}