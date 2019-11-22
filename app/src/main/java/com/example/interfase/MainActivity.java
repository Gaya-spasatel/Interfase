package com.example.interfase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    TextView tv;
    String sDown;
    String sMove;
    String sUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        tv = findViewById(R.id.textView);
        tv.setBackgroundColor(Color.GREEN);
        tv.setOnTouchListener(this);

       // setContentView(tv);
    }

    @Override
    public void onClick(View v) {
        ConstraintLayout root = findViewById(R.id.root);
        root.setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                sDown = "Down: " + x + "," + y;
                sMove = ""; sUp = "";
                break;
            case MotionEvent.ACTION_MOVE: // движение
                sMove = "Move: " + x + "," + y;
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = "Up: " + x + "," + y;
                break;
        }
        String out = sDown + "\n" + sMove + "\n" + sUp;
        tv.setText(out);
        return true;
        //return false;
    }
}
