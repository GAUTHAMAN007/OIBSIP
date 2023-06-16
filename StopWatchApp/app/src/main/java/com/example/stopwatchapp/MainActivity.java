package com.example.stopwatchapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int milliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;

    private TextView timeTextView;
    private Button startButton;
    private Button stopButton;
    private Button holdButton;
    private Button resetButton;

    private Handler handler;
    private Runnable runnable;

    private boolean isRunning = false;
    private boolean isHold = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = findViewById(R.id.timeTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        holdButton = findViewById(R.id.holdButton);
        resetButton = findViewById(R.id.resetButton);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (!isHold) {
                    milliseconds += 10;
                    if (milliseconds >= 1000) {
                        milliseconds = 0;
                        seconds++;
                        if (seconds >= 60) {
                            seconds = 0;
                            minutes++;
                        }
                    }
                    updateTimeTextView();
                }
                handler.postDelayed(this, 10);
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    startButton.setEnabled(false);
                    stopButton.setEnabled(true);
                    holdButton.setEnabled(true);
                    resetButton.setEnabled(true);
                    handler.postDelayed(runnable, 10);
                    isRunning = true;
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    holdButton.setEnabled(false);
                    resetButton.setEnabled(true);
                    handler.removeCallbacks(runnable);
                    isRunning = false;
                }
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHold = !isHold;
                if (isHold) {
                    holdButton.setText("Resume");
                } else {
                    holdButton.setText("Hold");
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                holdButton.setEnabled(false);
                resetButton.setEnabled(false);
                handler.removeCallbacks(runnable);
                milliseconds = 0;
                seconds = 0;
                minutes = 0;
                updateTimeTextView();
                isRunning = false;
                isHold = false;
                holdButton.setText("Hold");
            }
        });
    }

    private void updateTimeTextView() {
        String time = String.format("%02d:%02d:%02d", minutes, seconds, milliseconds / 10);
        timeTextView.setText(time);
    }
}