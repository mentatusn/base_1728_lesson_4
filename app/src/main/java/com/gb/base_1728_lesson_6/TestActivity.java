package com.gb.base_1728_lesson_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.gb.base_1728_lesson_4.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //EditText et = (EditText) getIntent().getExtras().getSerializable("sdg");
        TestCustom testCustom = (TestCustom) getIntent().getExtras().getSerializable("testCustom");
    }
}