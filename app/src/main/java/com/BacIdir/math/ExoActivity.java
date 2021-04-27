package com.BacIdir.math;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.BacIdir.math.Controllers.AdMob;
import com.BacIdir.math.Controllers.ExoTimer;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.Exo.Exo;
import com.BacIdir.math.Exo.ExoMark;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shawnlin.numberpicker.NumberPicker;

public class ExoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private Looper mainLooper ;
    private ExoTimer CountDown;
    private NumberPicker minutesCounter;
    private NumberPicker secondsCounter;
    private Activity context ;
    public static boolean ExoStarted = false ;
    private boolean DisplayHints = false ;
    private boolean DisplaySolution = false ;
    private Exo ex ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);
        Thread Background = new Thread(AdRequest);
        Background.start();

    }


    

    private AdMob Ad ;
    Runnable AdRequest = new Runnable() {
        @Override
        public void run() {
            Setting();
            ExoTimer.ResetCounter(minutesCounter,secondsCounter);
            Handler handler = new Handler(mainLooper);
            Ad = new AdMob(context, handler);
            Ad.LoadAd();
        }};

    @Override
    public boolean onNavigationItemSelected( MenuItem Item) {
        switch (Item.getItemId()){
            case R.id.Start : StartExo(Item);
            return true;

            case R.id.Hint : ExoHints();
            return true;

            case R.id.Solve: ExoSolution();
            return true;
        }
        return false;
    }

    private void Setting(){
        context = this ;
        mainLooper = getMainLooper();
        BottomNavigationView bottomNavigationView = findViewById(R.id.exo_controls);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        minutesCounter = findViewById(R.id.mins);
        secondsCounter = findViewById(R.id.seconds);
        RecyclerView exoGrid = findViewById(R.id.exo_host);
        ex = new Exo(this,exoGrid);
    }


        private void StartExo(MenuItem item){
            if (!ExoStarted){
                ExoStarted = true ;
                item.setIcon(R.drawable.ic_exo_stop);
                CreateCounter();
                ExoTimer.SetUpCounter(minutesCounter);
                CountDown.start();

            }
            else {
                ExoStarted = false ;
                item.setIcon(R.drawable.ic_exo_start);
                ExoMark mark = new ExoMark(this);
                mark.show();
                CountDown.cancel();
                CountDown.DismissNotification();
                ExoTimer.ResetCounter(minutesCounter,secondsCounter);
        }
    }


    private void ExoHints(){
        if(!DisplayHints){
            DisplayHints = true ;
            DisplaySolution = false ;
            ex.DisplayHint();
        }
        else {
            DisplayHints = false ;
            ex.DisplayExo();
        }
    }

    private void ExoSolution (){
        if (!DisplaySolution){
            ex.DisplaySolution();
            Ad.Display();
            DisplaySolution = true ;
            DisplayHints = false ;
        }
        else {
            ex.DisplayExo();
            DisplaySolution = false ;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DisplayHints = false ;
        DisplaySolution = false ;
        ExoStarted = false ;
        if (CountDown !=null) {CountDown.cancel();}

    }

    private void CreateCounter() {
        String c = Registre.Lmin[minutesCounter.getValue()-1];
        int Minute = Integer.parseInt(c) ;
        CountDown = new ExoTimer(Minute,1000 , minutesCounter, secondsCounter,this);
    }

}