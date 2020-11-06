package com.example.riddle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText min;
    private EditText max;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        min = (EditText)findViewById(R.id.num1);
        max = (EditText)findViewById(R.id.num2);

    }

    public void Click(View v) {
        switch (v.getId()) {
            case R.id.go:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("n1", min.getText().toString());
                intent.putExtra("n2", max.getText().toString());
                startActivity(intent);
                break;
            default: break;
        }
    }
}
