package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quiz5 extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    RadioButton ra,r1,r2,r3;

    static int rr5=0;
    public static int getvalue(){
        return rr5;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        getSupportActionBar().hide();
        radioGroup=findViewById(R.id.radioGroup);
        textView=findViewById(R.id.textView3);
        ra=findViewById(R.id.radioButton_a);
        r1=findViewById(R.id.radioButton1);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
    }
    public void next5(View view) {
        Intent intent= new Intent(this, quizfinal.class);
        startActivity(intent);
    }
    public void submit(View view) {
        if (ra.isChecked()){
            textView.setText("Woo! " +"\n"+
                    "Congratulation that's the Correct answer");
            rr5=1;
        }
        else{
            textView.setText("Wrong answer.....");
            rr5=0;
        }
    }
}