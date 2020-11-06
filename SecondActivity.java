package com.example.riddle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


    public class SecondActivity extends Activity{
        TextView res, ques;
        private Button left,right;
        private int n1,n1_2,n2, n2_2;

      //  private int num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        res = findViewById(R.id.res);
        //ques = findViewById(R.id.ques);
        left = (Button)findViewById(R.id.left_b);
        right = (Button)findViewById(R.id.right_b);

        if (!getIntent().getStringExtra("n1").isEmpty()) {
            n1 = Integer.parseInt(getIntent().getStringExtra("n1"));
        }

        if(!getIntent().getStringExtra("n2").isEmpty()) {
            n2 = Integer.parseInt(getIntent().getStringExtra("n2"));
        }

        start();
    }

        public void start() {
            if (noNull(n1, n2)) {
                n1_2 = n2/2;
                n2_2 = n2/2;
                //num3 = (num2-num1)/2;
                setTxt();
            }
        }

        public void setTxt() {

            left.setText(n1 + " - "+ n1_2);
            right.setText(n2_2 + " - "+ n2);
           // ques.setText(num3);
    }

        public void One(View v){
            if (n1_2==n1) {
                res.setText("Ваше число - "+n1_2 + "!");
            } else if (noNull(n1, n2)) {
                n2 = n1_2;
                n1_2 = n2 - (n2 - n1) / 2;
                n2_2 = n2 - (n2 - n1) / 2 + 1;
                setTxt();
                if (n1>n1_2) {
                    n1_2 = n1;
                    setTxt();
                }
                if (n2_2>n2) {
                    n2_2 = n2;
                    setTxt();
                }
            }
        }

        public void Two(View v){
            if (n2_2==n2) {
                res.setText("Ваше число - "+n2_2 + "!");
            } else if (noNull(n1, n2)) {
                n1 = n2_2;
                n1_2 = n1 + (n2 - n1) / 2 - 1;
                n2_2 = n1 + (n2 - n1) / 2;
                setTxt();
                if (n1>n1_2) {
                    n1_2 = n1;
                    setTxt();
                }
                if (n2_2>n2) {
                    n2_2 = n2;
                    setTxt();
                }
            }
        }

        public Boolean noNull(int n1, int n2) {
            if (n1==0 && n2==0) {
                res.setText(" Что-то пошло не так ");
                return false;
            }
            return true;
        }

    }
