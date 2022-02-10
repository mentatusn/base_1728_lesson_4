package com.gb.base_1728_lesson_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            tv.setText(extras.getString(MainActivity.KEY_INTENT_FROM_MAIN_TO_SECOND));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.KEY_INTENT_FROM_SECOND_TO_MAIN,"Привет, MainActivity! У меня все хорошо, сама как?");
                SecondActivity.this.setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}