package com.BacIdir.math.Controllers;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Exo.Exo;

public class RecyclerGesture extends ItemTouchHelper.SimpleCallback {

    private final Exo exo ;

    public RecyclerGesture(int dragDirs, int swipeDirs , Exo exo) {
        super(dragDirs, swipeDirs);
        this.exo = exo ;
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }
/*
    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

    }*/

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (direction == ItemTouchHelper.LEFT) {exo.NextExo();}
        else {exo.PrevExo();}
    }

}
