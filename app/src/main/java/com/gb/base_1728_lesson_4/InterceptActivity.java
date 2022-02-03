package com.gb.base_1728_lesson_4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InterceptActivity extends AppCompatActivity  {


    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        Bundle bundle =getIntent().getExtras();
        if(bundle!=null){
            tv.setText(bundle.getStringArray(Intent.EXTRA_EMAIL)[0]+" "+bundle.getString(Intent.EXTRA_SUBJECT));
        }
    }

}