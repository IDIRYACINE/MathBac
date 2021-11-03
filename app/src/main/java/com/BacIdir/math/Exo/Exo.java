package com.BacIdir.math.Exo;

import android.content.Context;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Controllers.AdMob;
import com.BacIdir.math.Controllers.RecyclerGesture;
import com.BacIdir.math.Data.Registre;

public class Exo {
    private int[] exos;
    private ExoAdapter adapter ;
    private  RecyclerGesture itemTouchHelperCallback ;
    public boolean ExoStarted = false ;
    public boolean DisplayHints = false ;
    public boolean DisplaySolution = false ;

    public Exo(Context context , RecyclerView exoGrid) {
        Settings(context,exoGrid);
    }

    private void Settings(Context context , RecyclerView exoView){
        adapter = new ExoAdapter(context, exos);
        exoView.setAdapter(adapter);
        itemTouchHelperCallback  = new RecyclerGesture(0, ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT , this);
        DisplayExo();
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(exoView);

    }

    public void DisplaySolution(AdMob Ad){
        if (!DisplaySolution){
            exos = Registre.Solutions[Registre.currentUnit];
            itemTouchHelperCallback.toggleSwipe(false);
            UpdateAdapterData();
            Ad.Display();
            DisplaySolution = true ;
            DisplayHints = false ;
        }
        else {
            DisplayExo();
            DisplaySolution = false ;
        }
    }

    public void DisplayExo(){
        exos = Registre.Units[Registre.currentUnit];
        itemTouchHelperCallback.toggleSwipe(true);
        UpdateAdapterData();
    }

    public void DisplayHint(){
        if(!DisplayHints){
            DisplayHints = true ;
            DisplaySolution = false ;
            exos = Registre.Hints[Registre.currentUnit];
            itemTouchHelperCallback.toggleSwipe(false);
            adapter.data = exos ;
            adapter.notifyDataSetChanged();
        }
        else {
            DisplayHints = false ;
            DisplayExo();
        }
    }

    public void NextExo (){
        boolean ExcededExoPool = (Registre.currentExo + 1 < exos.length)&&(!ExoStarted);
        boolean ExceedUnitProgress = (Registre.currentExo + 1 <= Registre.UnitsProgress[Registre.currentUnit] );
        if ((ExcededExoPool)&&(ExceedUnitProgress)){
            Registre.currentExo +=1 ;
        }
        UpdateAdapterData();
    }

    public void PrevExo (){
        boolean ExcededExoPool = (Registre.currentExo - 1 >= 0)&&(!ExoStarted);
        if (ExcededExoPool){
            Registre.currentExo -= 1 ;
        }
        UpdateAdapterData();
    }

    private void UpdateAdapterData(){
        int[] ex = new int[25];
        ex[0] = exos[Registre.currentExo] ;
        adapter.data = ex ;
        adapter.notifyDataSetChanged();
    }

}