package com.BacIdir.math;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private NavController controller ;
    private FragmentManager fm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){
            setContentView(R.layout.activity_main);

            fm = getSupportFragmentManager();

            NavHostFragment host = (NavHostFragment) fm.findFragmentById(R.id.nav_host);
            controller = host.getNavController();

            BottomNavigationView  bottomNavigationView = findViewById(R.id.bottom_bar);
            bottomNavigationView.setOnNavigationItemSelectedListener(this);


        }




    }


    @Override
    public boolean onNavigationItemSelected(MenuItem Item) {





        switch (Item.getItemId()){
            case R.id.Home :
                    controller.navigate(R.id.units,null,new  NavOptions.Builder().setPopUpTo(R.id.units,true).build());
                return true ;

            case R.id.Dashboard :
                    controller.navigate(R.id.graphs,null,new  NavOptions.Builder().setPopUpTo(R.id.graphs,true).build());
                return true ;

        }

        return false;
    }


}
