package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EnglishActivity extends AppCompatActivity {
    TextView t2, t3;
    RadioButton r1, r2, r3, r4;
    Button b1, b2;

    String[] query = {"My mother is a good cook.", "What will you do this afternoon?",
            "I got up _ than my mother", "Are you _ at the moon?", "I _ baseball very much"};
    String[] a = {"I agree to you", "I will play soccer", "the earliest", "look", "am"};
    String[] b = {"I agree with you", "I was playing soccer", "earlier", "looks", "have"};
    String[] c = {"I agree you", "I play soccer", "earliest", "looking", "like"};
    String[] d = {"I agree for you", "I played soccer", "early", "looked", "was liked"};
    String[] answer = {"I agree with you", "I will play soccer", "earlier", "looking", "like"};
    String var;
    int index, right, wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.textView);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r);
        r3 = findViewById(R.id.r2);
        r4 = findViewById(R.id.r3);
        b1 = findViewById(R.id.b);
        b2 = findViewById(R.id.b2);

    }

    public  void onStartClick(View view){
        nextQuestion();
        b1.setEnabled(false);
    }
    public void nextQuestion(){
        t2.setText(query[index]);
        r1.setText(a[index]);
        r2.setText(b[index]);
        r3.setText(c[index]);
        r4.setText(d[index]);
    }
    public void onNextClick(View view){
        if(r1.isChecked()){
            var = a[index];
            r1.setChecked(false);
        }
        else if(r2.isChecked()){
            var = b[index];
            r2.setChecked(false);
        }
        else if(r3.isChecked()){
            var = c[index];
            r3.setChecked(false);
        }
        else if(r4.isChecked()){
            var = d[index];
            r4.setChecked(false);
        }
        if(var.equals(answer[index])){
            right++;
        } else{
            wrong++;
        }
        t3.setText("Правильно: "+right+". Неправильно: "+wrong);
        if(index<query.length-1){
            index++;
            nextQuestion();
        }
        else{
            Toast.makeText(this, "Тест окончен", Toast.LENGTH_LONG).show();
            b1.setEnabled(true);
            index = 0;
            right = 0;
            wrong = 0;
        }

    }
}