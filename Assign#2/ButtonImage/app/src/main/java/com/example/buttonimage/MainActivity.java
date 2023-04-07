package com.example.buttonimage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView img;

    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        img = (ImageView) findViewById(R.id.DogImg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x+=10;
                if (x >= 360){
                    x = 0;
                }
                img.setRotation(x);
            }
        });
    }
}