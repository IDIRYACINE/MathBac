package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import com.BacIdir.math.Customs.UnitButton;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class Units extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_units, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Thread Setup = new Thread(new Runnable() {
            @Override
            public void run() { Settings(view); }}) ;

        Setup.start();

    }

    private void Settings (View root){
        NavHostFragment host = (NavHostFragment) getParentFragment() ;
        NavController controller = host.getNavController();
        NavOptions navOptions = new  NavOptions.Builder().setPopUpTo(R.id.exoQuest,true).build();
        SetUpUnits(root,controller, navOptions);
    }


    private void SetUpUnits(View root , final NavController controller , final NavOptions navOptions){
        int[] Units  = {R.id.unit1_button,R.id.unit2_button,R.id.unit3_button,R.id.unit4_button,R.id.unit5_button,R.id.unit6_button};
        View.OnClickListener unitListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnitButton unitButton = (UnitButton) v;
                Registre.currentUnit = unitButton.position;
                controller.navigate(unitButton.destination,null,navOptions);
            }};

        for (int i = 0 ;i < Units.length;i++) {
            UnitButton unitButton= root.findViewById(Units[i]);
            unitButton.setOnClickListener(unitListener);
            unitButton.position = i ;
            unitButton.destination = i < 5? R.id.exoQuest : R.id.graphs ;
        }
    }


}
