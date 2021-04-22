package com.BacIdir.math;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
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
    private NavController controller ;
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
        Setting();
        Thread Background = new Thread(AdRequest);
        Background.start();
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    private AdMob Ad ;
    Runnable AdRequest = new Runnable() {
        @Override
        public void run() {
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

            case R.id.Hint : ExoHints(Item);
            return true;

            case R.id.Solve: ExoSolution(Item);
            return true;
        }
        return false;
    }

    private void Setting(){
        context = this ;
        mainLooper = getMainLooper();
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.exo_host);
        controller = host.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.exo_controls);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        minutesCounter = findViewById(R.id.mins);
        secondsCounter = findViewById(R.id.seconds);

        ex = (Exo) host.getChildFragmentManager().getFragments().get(0);
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
                ExoMark mark = new ExoMark(this,Ad);
                mark.show();
                CountDown.cancel();
                CountDown.DismissNotification();
                ExoTimer.ResetCounter(minutesCounter,secondsCounter);

        }
    }


    private void ExoHints(MenuItem Item){
        if(!DisplayHints){
            DisplayHints = true ;
            Item.setIcon(R.drawable.ic_exo);
            controller.navigate(R.id.action_exoN_to_hintN);
        }
        else {
            DisplayHints = false ;
            Item.setIcon(R.drawable.ic_hint);
            controller.navigate(R.id.action_hintN_to_exoN);
        }
    }

    private void ExoSolution (MenuItem Item){
        if (!DisplaySolution){
            Item.setIcon(R.drawable.ic_exo);
            ex.DisplaySolution();
            DisplaySolution = true ;
        }
        else {
            Item.setIcon(R.drawable.ic_hint);
            ex.DisplayExo();
            DisplaySolution = false ;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DisplayHints = !DisplayHints;
    }

    private void CreateCounter() {
        String c = Registre.Lmin[minutesCounter.getValue()-1];
        int Minute = Integer.parseInt(c) ;
        CountDown = new ExoTimer(Minute,1000 , minutesCounter, secondsCounter,this);
    }

}