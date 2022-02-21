package com.gb.base_1728_lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        LinearLayout linearLayout = (LinearLayout) view;
        LayoutInflater layoutInflater = getLayoutInflater();
        String[] cities = getResources().getStringArray(R.array.cities);
        for (int i=0;i<cities.length;i++){
            String cityName = cities[i];
            View listItem = layoutInflater.inflate(R.layout.fragment_cities_list_cities_item,linearLayout,false);
            linearLayout.addView(listItem);

            TextView textView = listItem.findViewById(R.id.textView);
            textView.setTextSize(30f);
            textView.setText(cityName);
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
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.cities,coatOfArmsFragment).addToBackStack("").commit();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("mylogs","F1 onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("mylogs","F1 onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("mylogs","F1 onResume");
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.d("mylogs","F1 onStop");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.d("mylogs","F1 onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d("mylogs","F1 onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("mylogs","F1 onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("mylogs","F1 onDetach");
        super.onDetach();
    }
}