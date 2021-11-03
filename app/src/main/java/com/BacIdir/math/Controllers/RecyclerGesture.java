package com.BacIdir.math.Controllers;

import android.graphics.Canvas;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Exo.Exo;

public class RecyclerGesture extends ItemTouchHelper.SimpleCallback {

    private final Exo exo ;
    private boolean swipeEnabled = true ;
    public RecyclerGesture(int dragDirs, int swipeDirs , Exo exo) {
        super(dragDirs, swipeDirs);
        this.exo = exo ;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
    if(!swipeEnabled){
        return ItemTouchHelper.UP | ItemTouchHelper.DOWN;
    }
    return super.getMovementFlags(recyclerView,viewHolder);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (swipeEnabled) {
            if (direction == ItemTouchHelper.LEFT) {
                exo.NextExo();
            } else {
                exo.PrevExo();
            }
        }
    }

    public void toggleSwipe(boolean value){
        swipeEnabled = value;
    }

}
