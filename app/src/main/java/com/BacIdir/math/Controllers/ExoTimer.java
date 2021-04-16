package com.BacIdir.math.Controllers;

import android.os.CountDownTimer;
import com.BacIdir.math.Data.Registre;
import com.shawnlin.numberpicker.NumberPicker;

public class ExoTimer extends CountDownTimer {

    private final NumberPicker minutesCounter;
    private final NumberPicker secondsCounter;
    private int SECONDS = 59 ;
    private static int Minutes;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public ExoTimer(long millisInFuture, long countDownInterval, NumberPicker minutesCounter, NumberPicker secondsCounter) {
        super(millisInFuture * 10000 , countDownInterval);
        this.minutesCounter = minutesCounter;
        this.secondsCounter = secondsCounter;
        Minutes = (int) millisInFuture;
        SetUpSecondsCounter();

    }

    @Override
    public void onTick(long millisUntilFinished) {
        if(SECONDS - 1 >= 0){
            SECONDS -=1 ; secondsCounter.setValue(SECONDS);}
        else {
            SECONDS = 59 ;
            if (Minutes -1 > 0){ Minutes -=1;
                minutesCounter.setValue(Minutes); }
        }
    }

    @Override
    public void onFinish() {

    }

    public static void SetUpCounter(NumberPicker minutesCounter) {
        minutesCounter.setDisplayedValues(Registre.Rmin);
        minutesCounter.setMinValue(1);
        minutesCounter.setEnabled(false);
        minutesCounter.setMaxValue(Registre.Rmin.length);
        minutesCounter.setValue(Minutes);


    }
    public static void ResetCounter(NumberPicker minutesCounter , NumberPicker secondsCounter ) {
        minutesCounter.setMinValue(1);
        minutesCounter.setEnabled(true);
        minutesCounter.setMaxValue(Registre.Lmin.length);
        minutesCounter.setDisplayedValues(Registre.Lmin);
        minutesCounter.setValue(1);
        secondsCounter.setValue(0);
    }
    private void SetUpSecondsCounter(){
        secondsCounter.setDisplayedValues(Registre.Rmin);
        secondsCounter.setMinValue(1);
        secondsCounter.setEnabled(false);
        secondsCounter.setMaxValue(Registre.Rmin.length);
    }

}
