package com.BacIdir.math;

import android.graphics.Region;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import com.BacIdir.math.Controllers.ExoMark;
import com.BacIdir.math.Controllers.ExoTimer;
import com.BacIdir.math.Data.Registre;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shawnlin.numberpicker.NumberPicker;

public class ExoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private NavController controller ;
    private ExoTimer timer ;
    private NumberPicker mins ;
    private NumberPicker seconds ;
    private InterstitialAd mInterstitialAd ;
    public static boolean exo_started = false ;
    public static boolean exo_hint = false ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){

            setContentView(R.layout.activity_exo);

            NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.exo_host);
            controller = host.getNavController();


            BottomNavigationView bottomNavigationView = findViewById(R.id.exo_controls);
            bottomNavigationView.setOnNavigationItemSelectedListener(this);

            mins = findViewById(R.id.mins);
            mins.setMinValue(1);
            mins.setMaxValue(Registre.Lmin.length);
            mins.setDisplayedValues(Registre.Lmin);
            mins.setValue(1);

            seconds = findViewById(R.id.seconds);
            seconds.setScrollerEnabled(false);

            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-7616920693631792/9303048879");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());


        }




    }

    @Override
    public boolean onNavigationItemSelected( MenuItem Item) {

        switch (Item.getItemId()){

            case R.id.Start : start_exo(Item);
                return true;

            case R.id.Hint : exo_switch(Item);
                return true;
        }


        return false;
    }


    private void start_exo(MenuItem Item){

        if(!exo_started){

            exo_started = true ;
            Item.setIcon(R.drawable.ic_exo_stop);
            Item.setTitle(R.string.Stop);
            // get the value for count down from numpicker
            String c = Registre.Lmin[mins.getValue()-1];
            int count = Integer.parseInt(c) ;

            //
            timer = new ExoTimer(count,1000 ,mins,seconds);
            mins.setMinValue(1);
            mins.setMaxValue(Registre.Rmin.length);
            mins.setDisplayedValues(Registre.Rmin);
            mins.setValue(count);

            timer.start();


        }
        else {
            exo_started = false ;
            Item.setIcon(R.drawable.ic_exo_start);
            Item.setTitle(R.string.Start);

            timer.cancel();

            mins.setMinValue(1);
            mins.setMaxValue(Registre.Lmin.length);
            mins.setDisplayedValues(Registre.Lmin);
            mins.setValue(1);
            seconds.setValue(0);

            ExoMark mark = new ExoMark(this,mInterstitialAd);
            mark.show();

        }

    }

    private void exo_switch (MenuItem Item){

        if(!exo_hint){
            exo_hint = true ;
            Item.setIcon(R.drawable.ic_exo);
            Item.setTitle(R.string.Exo);
            controller.navigate(R.id.hintN,null,new  NavOptions.Builder().setPopUpTo(R.id.hintN,true).build());


        }
        else {
            exo_hint = false ;
            Item.setIcon(R.drawable.ic_hint);
            Item.setTitle(R.string.Hint);
            controller.navigate(R.id.exoN,null,new  NavOptions.Builder().setPopUpTo(R.id.exoN,true).build());

        }

    }

}
