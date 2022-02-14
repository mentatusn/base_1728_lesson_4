package com.gb.base_1728_lesson_6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.gb.base_1728_lesson_4.R;

public class MyFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);

        if (savedInstanceState == null) {
            CitiesFragment citiesFragment = CitiesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.cities, citiesFragment).commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.action_about):{
                getSupportFragmentManager().beginTransaction().replace(R.id.cities,new AboutFragment()).addToBackStack("").commit();
                return true;
            }
            case (R.id.action_exit):{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /** Пришлось перенести наш костыль в onResume
     * так как не onBackPressed() вызывать в onCreate - черевато
     **/
    @Override
    protected void onResume() {
        super.onResume();
        // ищем фрагмент, который сидит в контейнере R.id.cities_container
        Fragment backStackFragment = (Fragment)getSupportFragmentManager()
                .findFragmentById(R.id.cities);
        // если такой есть, и он является CoatOfArmsFragment
        if(backStackFragment!=null&&backStackFragment instanceof CoatOfArmsFragment){
            //то сэмулируем нажатие кнопки Назад
            onBackPressed();
        }
    }
}