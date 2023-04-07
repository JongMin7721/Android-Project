package com.example.turningbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import kotlinx.coroutines.channels.ChannelKt;

public class MainActivity extends AppCompatActivity {
    CheckBox ClickBtn, EnableBtn, RotationBtn;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickBtn = (CheckBox) findViewById(R.id.ClickableCheck);
        EnableBtn = (CheckBox) findViewById(R.id.EnableCheck);
        RotationBtn = (CheckBox) findViewById(R.id.RotationClick);
        btn = (Button) findViewById(R.id.button);

        ClickBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (ClickBtn.isChecked() == true){
                    btn.setClickable(false);
                }else{
                    btn.setClickable(true);
                }
            }
        });

        EnableBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (EnableBtn.isChecked() == true){
                    btn.setEnabled(false);
                }else{
                    btn.setEnabled(true);
                }
            }
        });

        RotationBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (RotationBtn.isChecked() == true){
                    btn.setRotation(45);
                }else{
                    btn.setRotation(0);
                }
            }
        });
    }
}