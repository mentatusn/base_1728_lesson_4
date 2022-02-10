package com.gb.base_1728_lesson_6;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import java.io.Serializable;

public class MyCustomEditText extends androidx.appcompat.widget.AppCompatEditText implements Serializable {
    public MyCustomEditText(Context context) {
        super(context);
    }

    public MyCustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
