package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quiz2 extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    RadioButton ra,r4,r2,r3;
    static int rr2=0;
    public static int getvalue(){
        return rr2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        getSupportActionBar().hide();
        radioGroup=findViewById(R.id.radioGroup);
        textView=findViewById(R.id.textView3);
        ra=findViewById(R.id.radioButton_a);
        r4=findViewById(R.id.radioButton4);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
    }

    public void next2(View view) {
        Intent intent2= new Intent(this, quiz3.class);
        startActivity(intent2);
    }

    public void submit(View view) {
        if (ra.isChecked()){
        textView.setText( "Woo! " +"\n"+
                "Congratulation that's the Correct answer");
        rr2=1;
        }
        else{
            textView.setText("Wrong answer.....");
            rr2=0;
        }
    }
}