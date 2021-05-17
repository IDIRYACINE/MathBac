package com.BacIdir.math.Fragments.Units;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.Fragments.IFragmentView;
import com.BacIdir.math.Fragments.INavigation;
import com.BacIdir.math.R;

public class Units implements IFragmentView {

    private final Context context;
    private final UnitsAdapter adapter ;

    public Units(Context context , INavigation parent) {
        this.context = context;
        adapter = new UnitsAdapter(context, Registre.unitsTitles , parent);

    }

    @Override
    public void SetFragmentView(RecyclerView viewList, TextView barTitle, ImageView backButton) {
        viewList.setLayoutManager(new LinearLayoutManager(context));
        viewList.setAdapter(adapter);
        backButton.setVisibility(View.GONE);
        SetUpBarTitle(barTitle);
    }

    private void SetUpBarTitle(TextView barTitle){
        barTitle.setText(context.getString(R.string.unit_bar_title));
    }
}
