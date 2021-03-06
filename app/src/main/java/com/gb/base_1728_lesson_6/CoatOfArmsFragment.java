package com.gb.base_1728_lesson_6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_coat_of_arms,menu);// TODO два фрагмента в одно меню
        //menu.add(Menu.NONE,10,Menu.NONE,"NewMenu");
        menu.findItem(R.id.action_about).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.action_toast):{
                Toast.makeText(requireContext()," Toast",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
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
        setHasOptionsMenu(true); // !!!!!! Мы говорим, что у фрагмента есть свое меню
        city = getArguments().getParcelable(ARG_CITY);
        ImageView imageView=  view.findViewById(R.id.imageView);
        TypedArray images = getResources().obtainTypedArray(R.array.coat_of_arms_imgs);
        imageView.setImageResource(images.getResourceId(city.getIndex(),R.drawable.msc));
        view.findViewById(R.id.btnAnchor).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(),view, Gravity.CENTER);
                requireActivity().getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case (R.id.action_popup_clear):{
                                imageView.setImageAlpha(0);
                                return true;
                            }
                            case (R.id.action_popup_exit):{
                                requireActivity().finish();
                                return true;
                            }
                        }
                        return false;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("mylogs","F2 onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("mylogs","F2 onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("mylogs","F2 onResume");
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.d("mylogs","F2 onStop");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.d("mylogs","F2 onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d("mylogs","F2 onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("mylogs","F2 onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("mylogs","F2 onDetach");
        super.onDetach();
    }
}