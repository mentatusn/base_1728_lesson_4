package com.gb.base_1728_lesson_6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.gb.base_1728_lesson_4.R;
import com.gb.lesson9.LessonNinthFragments;
import com.google.android.material.navigation.NavigationView;

public class MyFragmentsActivity extends AppCompatActivity {


    public void onDialogResult(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_activity_my_fragments);

        if (savedInstanceState == null) {
            /*CitiesFragment citiesFragment = CitiesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.cities, citiesFragment).commit();*/
            LessonNinthFragments lessonNinthFragments = LessonNinthFragments.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.cities, lessonNinthFragments).commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.burger_open,R.string.burger_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case (R.id.action_drawer_about):{
                        getSupportFragmentManager().beginTransaction().replace(R.id.cities,new AboutFragment()).addToBackStack("").commit();
                        drawerLayout.close();
                        return true;
                    }
                    case (R.id.action_drawer_exit):{
                        finish();
                        return true;
                    }
                }
                return false;
            }
        });

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