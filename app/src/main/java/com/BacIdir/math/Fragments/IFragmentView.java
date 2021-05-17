package com.BacIdir.math.Fragments;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public interface IFragmentView {
    void SetFragmentView(RecyclerView viewList, TextView barTitle, ImageView backButton);

}

