package com.example.jda8301.spellarhyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Unit3WordListActivity extends AppCompatActivity {

    private ImageView exit;

    HorizontalScrollView sv;

    ImageButton leftScroll;
    ImageButton rightScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_word_list);

        leftScroll = (ImageButton) findViewById(R.id.imageButton);
        rightScroll = (ImageButton) findViewById(R.id.imageButton2);


        sv = (HorizontalScrollView) findViewById(R.id.horizontalScrollView2);

        // Change Action Bar Title
        View actionBar = findViewById(R.id.actionBar);
        TextView actionBarTitle = actionBar.findViewById(R.id.actionBarTitle);
        actionBarTitle.setText("Unit 3 Word List");

        // Initialize variables
        exit = (ImageView) findViewById(R.id.exitButton);

        // Add touch animation to buttons
        Util.scaleOnTouch(exit);

        leftScroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(leftScroll.isPressed()) {
                            sv.setScrollX(sv.getScrollX() - 20);
                        }
                        else
                            timer.cancel();
                    }
                },0,10);

                return false;
            }
        });

        rightScroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(rightScroll.isPressed()) {
                            sv.setScrollX(sv.getScrollX() + 20);
                        }
                        else
                            timer.cancel();
                    }
                },0,10);

                return false;
            }
        });

    }

    // Intents - goes to a different activity when the button is clicked
    public void onClickExit(View view) {
        Intent intent = new Intent(getApplicationContext(), Unit3VowelListActivity.class);
        startActivity(intent);
    }

    public void onClickSelectWord(View view) {
        Intent intent = new Intent(getApplicationContext(), Unit3GameActivity.class);
        startActivity(intent);
    }
}
