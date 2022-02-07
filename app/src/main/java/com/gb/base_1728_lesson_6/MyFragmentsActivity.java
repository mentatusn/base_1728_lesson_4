package com.gb.base_1728_lesson_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import com.gb.base_1728_lesson_4.R;

public class MyFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);

        if (savedInstanceState == null) {
            CitiesFragment citiesFragment = CitiesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.cities, citiesFragment).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                City defaultCity = new City(0);
                CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(defaultCity);
                getSupportFragmentManager().beginTransaction().replace(R.id.coat_of_arms,coatOfArmsFragment).commit();
            }
        }
    }
}