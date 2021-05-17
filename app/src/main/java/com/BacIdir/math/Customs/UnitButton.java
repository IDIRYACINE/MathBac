package com.BacIdir.math.Customs;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class UnitButton extends AppCompatButton {
    public int position ;
    public int destination ;


    public UnitButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public UnitButton(@NonNull Context context) {
        super(context);
    }

    public UnitButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

}
