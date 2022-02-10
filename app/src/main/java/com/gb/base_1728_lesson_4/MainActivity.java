package com.gb.base_1728_lesson_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {


    public static String KEY_INTENT_FROM_MAIN_TO_SECOND = "key1235";
    public static String KEY_INTENT_FROM_SECOND_TO_MAIN = "key2346";
    public static int REQUEST_CODE = 999;
    Button btn;
    Button btnSender;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        btnSender = findViewById(R.id.btnSender);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(KEY_INTENT_FROM_MAIN_TO_SECOND,"Привет, SecondActivity! Я из MainActivity");
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        btnSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("myAction");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode==RESULT_OK){
            if(data.getExtras()!=null)
            tv.setText(data.getStringExtra(KEY_INTENT_FROM_SECOND_TO_MAIN));
        }
    }
}