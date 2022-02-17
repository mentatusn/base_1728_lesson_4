package com.gb.lesson9;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.gb.base_1728_lesson_4.R;
import com.gb.base_1728_lesson_6.MyFragmentsActivity;

public class MyDialogFragmentCustom extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.dialog_custom, null);
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("Введите имя")
                .setView(view)
                .show();
        view.findViewById(R.id.buttonCustomView).setOnClickListener(v -> {
            EditText editText = view.findViewById(R.id.editTextCustomView);
            ( (MyFragmentsActivity) getActivity()).onDialogResult(editText.getText().toString());
            dismiss();
        });

        return alertDialog;
    }

}
