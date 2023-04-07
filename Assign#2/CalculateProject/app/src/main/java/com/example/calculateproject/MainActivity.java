package com.example.calculateproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tresult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.button0,R.id.button1,
            R.id.button2,R.id.button3,R.id.button4,R.id.button5,
            R.id.button6,R.id.button7,R.id.button8,R.id.button9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단한 계산기");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        tresult = (TextView) findViewById(R.id.textResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (Integer.parseInt(num2) == 0){
                    Toast.makeText(getApplicationContext(),
                        "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                }
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        for (i = 0; i < numBtnIDs.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (i = 0; i < numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit1.isFocused() == true){
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }else if (edit2.isFocused() == true){
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "먼저 에딧텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}