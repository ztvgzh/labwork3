package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;

public class RussianActivity extends AppCompatActivity {

    TextView t2, t3, t4;
    RadioButton r1, r2, r3, r4;
    Button b1, b2;

    String[] query = {"В каком слове пишется буква 'и'?", "Выберите правильный вариант:",
            "Вставьте пропущенную букву Апоф_оз", "В каком слове допущена ошибка?", "Выберите правильный вариант написания:"};
    String[] a = {"пред_стория", "не объятный", "у", "сгущёнка", "тьщательно"};
    String[] b = {"вз_мать", "не обьятный", "о", "печёнка", "тщательно"};
    String[] c = {"воз_меть", "необъятный", "е", "тушёнка", "тсчательно"};
    String[] d = {"из_мать", "необьятный", "и", "девчёнка", "тьсчательно"};
    String[] answer = {"вз_мать", "необъятный", "е", "девчёнка", "тщательно"};
    String var;
    int index, right, wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian);

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.textView);
        t4 = findViewById(R.id.t3);
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
    CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {

            public void onTick ( long millisUntilFinished){
            t4.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
        }

        public void onFinish() {
            t4.setText("Done.");
        }
    }.start();



}