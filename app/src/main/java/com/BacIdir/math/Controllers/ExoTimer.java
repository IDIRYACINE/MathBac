package com.BacIdir.math.Controllers;

import android.os.CountDownTimer;
import android.util.Log;
import com.BacIdir.math.Data.Registre;
import com.shawnlin.numberpicker.NumberPicker;

public class ExoTimer extends CountDownTimer {

    private NumberPicker mins ;
    private NumberPicker seconds ;
    private int sec = 59 ;
    private int time ;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public ExoTimer(long millisInFuture, long countDownInterval, NumberPicker mins , NumberPicker seconds) {
        super(millisInFuture * 10000 , countDownInterval);
        this.mins = mins ;
        this.seconds = seconds;
        this.time = (int) millisInFuture;


    }

    @Override
    public void onTick(long millisUntilFinished) {
        if(sec - 1 >= 0){sec -=1 ; seconds.setValue(sec);}
        else {
            sec = 59 ;
            if (time -1 > 0){ time -=1;mins.setValue(time); }
        }

    }

    @Override
    public void onFinish() {

    }


}
