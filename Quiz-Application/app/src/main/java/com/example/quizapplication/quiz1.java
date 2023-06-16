package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quiz1 extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    RadioButton ra,r1,r2,r4;
    static int rr=0;
    public static int getvalue(){
        return rr;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        getSupportActionBar().hide();
        radioGroup=findViewById(R.id.radioGroup);
        textView=findViewById(R.id.textView3);
        ra=findViewById(R.id.radioButton_a);
        r1=findViewById(R.id.radioButtona1);
        r2=findViewById(R.id.radioButton2);
        r4=findViewById(R.id.radioButton4);
    }


    public void next1(View view) {
        Intent intent= new Intent(this, quiz2.class);
        intent.putExtra("rr1",rr);
        startActivity(intent);

    }
    public void submit(View view) {
        if (ra.isChecked()){
            textView.setText("Woo! " +"\n"+
                    "Congratulation that's the Correct answer");
            rr=1;
        }
        else{
            textView.setText("Wrong answer.....");
            rr=0;
        }
    }
}