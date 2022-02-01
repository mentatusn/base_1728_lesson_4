package com.gb.base_1728_lesson_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String PREF_NAME = "key_pref";
    private static final String PREF_THEME_KEY = "key_pref_theme";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_main);
        ((RadioButton) findViewById(R.id.radioButtonMaterialDefault)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialGreen)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialBlue)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialRed)).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radioButtonMaterialDefault:{
                setAppTheme(R.style.myThemeDefault);
                break;
            }
            case R.id.radioButtonMaterialGreen:{
                setAppTheme(R.style.myThemeGreen);
                break;
            }
            case R.id.radioButtonMaterialBlue:{
                setAppTheme(R.style.myThemeBlue);
                break;
            }
            case R.id.radioButtonMaterialRed:{
                setAppTheme(R.style.myThemeRed);
                break;
            }
        }
        recreate();
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(PREF_THEME_KEY, codeStyle);
        editor.apply();
    }

    protected int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(PREF_THEME_KEY,R.style.myThemeDefault);
    }

}