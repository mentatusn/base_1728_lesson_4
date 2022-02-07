package com.gb.base_1728_lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gb.base_1728_lesson_4.R;


public class CitiesFragment extends Fragment {
    public static final String CURRENT_CITY = "city_current";
    private City currentCity;
    public static CitiesFragment newInstance() {
        CitiesFragment fragment = new CitiesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_CITY,currentCity);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState!=null){
            currentCity = savedInstanceState.getParcelable(CURRENT_CITY);
        }else{
            currentCity = new City(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showLand();
        }
        initView(view);
    }

    private void initView(View view) {
        String[] cities = getResources().getStringArray(R.array.cities);
        for (int i=0;i<cities.length;i++){
            String cityName = cities[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(cityName);
            ((LinearLayout) view).addView(textView);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentCity = new City(finalI);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        showLand();
                    }else{// портрет
                        showPort();
                    }
                }
            });
        }
    }

    private void showLand() {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(currentCity);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.coat_of_arms,coatOfArmsFragment).commit();
    }
    private void showPort() {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(currentCity);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cities,coatOfArmsFragment).addToBackStack("").commit();
    }
}