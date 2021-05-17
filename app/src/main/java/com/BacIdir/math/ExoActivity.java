package com.BacIdir.math;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Controllers.AdMob;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.Exo.Exo;
import com.BacIdir.math.Exo.ExoMark;
import com.BacIdir.math.Timer.ExoTimer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shawnlin.numberpicker.NumberPicker;

public class ExoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private ExoTimer CountDown;
    private NumberPicker minutesCounter;
    private NumberPicker secondsCounter;
    private Exo ex ;
    private AdMob Ad ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);
        SetUpViews(this);
        SetUpAds(this);
    }

    private void SetUpAds(Activity context){
        Runnable AdRequest = () -> {
            ExoTimer.ResetCounter(minutesCounter,secondsCounter);
            Handler handler = new Handler(getMainLooper());
            //Ad = new AdMob(context, handler);
            //Ad.LoadAd();
        };
        Thread Background = new Thread(AdRequest);
        Background.start();
    }

    private void SetUpViews(Activity context){

        BottomNavigationView bottomNavigationView = findViewById(R.id.exo_controls);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        minutesCounter = findViewById(R.id.mins);
        secondsCounter = findViewById(R.id.seconds);

        RecyclerView exoGrid = findViewById(R.id.exo_host);
        exoGrid.setLayoutManager(new LinearLayoutManager(context));

        ex = new Exo(this,exoGrid);
    }

    private void StartExo(MenuItem item){
        if (!ex.ExoStarted){
            ex.ExoStarted = true ;
            item.setIcon(R.drawable.ic_exo_stop);
            CreateCounter();
            ExoTimer.SetUpCounter(minutesCounter);
            CountDown.start();
        }
        else {
            ex.ExoStarted = false ;
            item.setIcon(R.drawable.ic_exo_start);
            ExoMark mark = new ExoMark(this,ex);
            mark.show();
            CountDown.cancel();
            CountDown.DismissNotification();
            ExoTimer.ResetCounter(minutesCounter,secondsCounter);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ex.DisplayHints = false ;
        ex.DisplaySolution = false ;
        ex.ExoStarted = false ;
        if (CountDown !=null) {CountDown.cancel();}
    }

    private void CreateCounter() {
        String c = Registre.Lmin[minutesCounter.getValue()-1];
        int Minute = Integer.parseInt(c) ;
        CountDown = new ExoTimer(Minute,1000 , minutesCounter, secondsCounter,this);
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem Item) {
        switch (Item.getItemId()){
            case R.id.Start : StartExo(Item);
                return true;

            case R.id.Hint : ex.DisplayHint();
                return true;

            case R.id.Solve: ex.DisplaySolution(Ad);
                return true;
        }
        return false;
    }

}