package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class Units extends Fragment implements View.OnClickListener {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_units, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Settings(view);
    }

    @Override
    public void onClick(View view) { UnitNavigation(view); }

    private void UnitNavigation (View view){
        Registre.Unit = TagToInt(view);
        if (Registre.Unit < 6 ){controller.navigate(R.id.exoQuest,null,new  NavOptions.Builder().setPopUpTo(R.id.exoQuest,true).build());}
        else {controller.navigate(R.id.graphs,null,new  NavOptions.Builder().setPopUpTo(R.id.graphs,true).build());}
    }

    private NavController controller ;
    private void Settings (View root){
        NavHostFragment host = (NavHostFragment) getParentFragment();
        controller = host.getNavController();

        int[] views = {R.id.unit_title1,R.id.unit_title2,R.id.unit_title3,R.id.unit_title4,R.id.unit_title5,R.id.unit_title6 ,
                        R.id.unit_icon1,R.id.unit_icon2,R.id.unit_icon3,R.id.unit_icon4,R.id.unit_icon5,R.id.unit_icon6} ;
        for (int view: views) { root.findViewById(view).setOnClickListener(this); }
    }

    private int TagToInt(View view){
        String tag = (String) view.getTag();
        return Integer.parseInt(tag);
    }

}
