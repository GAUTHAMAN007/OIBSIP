package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class quizfinal extends AppCompatActivity {
static int rr,rr2,rr3,rr4,rr5,result;
String res;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizfinal);
        rr=quiz1.getvalue();
        rr2=quiz2.getvalue();
        rr3=quiz3.getvalue();
        rr4=quiz4.getvalue();
        rr5=quiz5.getvalue();
        textView=findViewById(R.id.textView5);
        result=rr+rr2+rr3+rr4+rr5;
        res=Integer.toString(result);
        textView.setText(res);
    }
}