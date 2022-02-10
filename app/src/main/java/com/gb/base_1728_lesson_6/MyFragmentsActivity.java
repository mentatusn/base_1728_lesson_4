package com.gb.base_1728_lesson_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.EditText;

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

        MyCustomEditText editText = new MyCustomEditText(this);
        TestCustom testCustom = new TestCustom(this);
        Bundle bundle = new Bundle();
        //bundle.putSerializable("sdg",editText);
        bundle.putSerializable("testCustom",testCustom);
        Intent i= new Intent(this,TestActivity.class);
        i.putExtras(bundle);
        startActivity(i);
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