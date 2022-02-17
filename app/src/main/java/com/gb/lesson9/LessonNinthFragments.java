package com.gb.lesson9;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gb.base_1728_lesson_4.R;
import com.gb.base_1728_lesson_6.CitiesFragment;
import com.gb.base_1728_lesson_6.City;
import com.google.android.material.snackbar.Snackbar;

public class LessonNinthFragments extends Fragment {

    public static LessonNinthFragments newInstance() {
        LessonNinthFragments fragment = new LessonNinthFragments();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lesson_ninth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    void initView(View view) {
        /*view.findViewById(R.id.btnToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(),"Toast работает",Toast.LENGTH_LONG).show();
            }
        }); это то же самое что и 41 строка */
        view.findViewById(R.id.btnToast).setOnClickListener(v -> showToast());
        view.findViewById(R.id.btnSnackBar).setOnClickListener(v -> showSnackBar(view));
        view.findViewById(R.id.btnSnackBarWithAction).setOnClickListener(v -> showSnackBarWithAction(view));
        view.findViewById(R.id.btnAlertDialog).setOnClickListener(v -> showAlertDialog());
        view.findViewById(R.id.btnAlertDialogCustom).setOnClickListener(v -> showAlertDialogCustom());
    }

    void showAlertDialogCustom() {
        View view = getLayoutInflater().inflate(R.layout.dialog_custom, null);
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("AlertDialog")
                .setMessage("AlertDialog message")
                .setView(view)
                .show();
        view.findViewById(R.id.buttonCustomView).setOnClickListener(v -> {
            EditText editText = view.findViewById(R.id.editTextCustomView);
            showToast(editText.getText().toString());
            alertDialog.dismiss();
        });
    }

    void showAlertDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle("AlertDialog")
                .setMessage("AlertDialog message")
                .setPositiveButton("Да", (dialog, which) -> {
                    showToast("Да");
                })
                .setNegativeButton("Нет", (dialog, which) -> {
                    showToast("Нет");
                })
                .setNeutralButton("Ну не знаю", (dialog, which) -> {
                    showToast("Ну не знаю");
                })
                .show();
    }

    void showSnackBarWithAction(View view) {
        Snackbar.make(view, "SnackBarWithAction работает", Snackbar.LENGTH_LONG).setAction(
                "Попробововать еще раз", v -> {
                    showToast();
                }
        ).show(); //TODO
    }

    void showSnackBar(View view) {
        Snackbar.make(view, "SnackBar работает", Snackbar.LENGTH_LONG).show();
    }

    void showToast() {
        Toast.makeText(requireContext(), "Toast работает", Toast.LENGTH_LONG).show();
    }

    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}
