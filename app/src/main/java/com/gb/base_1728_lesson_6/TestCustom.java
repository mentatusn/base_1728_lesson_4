package com.gb.base_1728_lesson_6;

import android.content.Context;
import android.util.AttributeSet;

import java.io.Serializable;

public class TestCustom implements Serializable {
    Context mContext;
    public TestCustom(Context context) {
        mContext = context;
    }
}
