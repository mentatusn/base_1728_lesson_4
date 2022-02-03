package com.gb.base_1728_lesson_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.tv);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            tv.setText(extras.getString(MainActivity.KEY_INTENT));
        }
    }
}