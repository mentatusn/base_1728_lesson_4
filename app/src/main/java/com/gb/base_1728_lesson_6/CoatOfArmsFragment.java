package com.gb.base_1728_lesson_6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gb.base_1728_lesson_4.R;


public class CoatOfArmsFragment extends Fragment {

    public static final String ARG_CITY = "city";

    private City city;
    public static CoatOfArmsFragment newInstance(City city) {
        CoatOfArmsFragment fragment = new CoatOfArmsFragment();
        Bundle bundle= new Bundle();
        bundle.putParcelable(ARG_CITY,city);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coat_of_arms, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        city = getArguments().getParcelable(ARG_CITY);
        ImageView imageView=  view.findViewById(R.id.imageView);
        TypedArray images = getResources().obtainTypedArray(R.array.coat_of_arms_imgs);
        imageView.setImageResource(images.getResourceId(city.getIndex(),R.drawable.msc));
    }
}