package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quiz3 extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    RadioButton ra,r1,r4,r3;
    static int rr3=0;
    public static int getvalue(){
        return rr3;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        getSupportActionBar().hide();
        radioGroup=findViewById(R.id.radioGroup);
        textView=findViewById(R.id.textView3);
        ra=findViewById(R.id.radioButton_a);
        r1=findViewById(R.id.radioButton1);
        r4=findViewById(R.id.radioButton4);
        r3=findViewById(R.id.radioButton3);
    }
    public void next3(View view) {
        Intent intent= new Intent(this, quiz4.class);
        startActivity(intent);
    }
    public void submit(View view) {
        if (ra.isChecked()){
            textView.setText("Woo! " +"\n"+
                    "Congratulation that's the Correct answer");
            rr3=1;
        }
        else{
            textView.setText("Wrong answer.....");
            rr3=0;
        }
    }
}