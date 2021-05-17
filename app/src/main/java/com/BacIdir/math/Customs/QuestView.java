package com.BacIdir.math.Customs;


import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class QuestView extends androidx.appcompat.widget.AppCompatTextView {
    public int position ;

    public QuestView(@NonNull Context context) {
        super(context);
    }

    public QuestView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
