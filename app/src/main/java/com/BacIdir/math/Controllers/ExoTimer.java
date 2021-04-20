package com.BacIdir.math.Controllers;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.ExoActivity;
import com.BacIdir.math.R;
import com.shawnlin.numberpicker.NumberPicker;

public class ExoTimer extends CountDownTimer {

    private final NumberPicker minutesCounter;
    private final NumberPicker secondsCounter;
    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager ;
    private final ExoActivity activity ;
    private int SECONDS = 59 ;
    private static int Minutes;
    private int PROGRESS_CURRENT ;
    private final int PROGRESS_MAX ;
    private final int NOTIFICATION_ID = 11 ;


    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    public ExoTimer(long millisInFuture, long countDownInterval, NumberPicker minutesCounter, NumberPicker secondsCounter, ExoActivity activity) {
        super(millisInFuture * 1000 * 60 , countDownInterval);
        this.minutesCounter = minutesCounter;
        this.secondsCounter = secondsCounter;
        this.activity = activity ;
        Minutes = (int) millisInFuture;
        PROGRESS_MAX = Minutes * 1000 * 60;
        PROGRESS_CURRENT = PROGRESS_MAX;
        NotificationSettings(activity);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if(SECONDS - 1 >= 0){
            secondsCounter.setValue(SECONDS);SECONDS -=1 ; }
        else {
            secondsCounter.setValue(SECONDS);
            SECONDS = 59 ;
            if (Minutes -1 > 0){ Minutes -=1;
                minutesCounter.setValue(Minutes); }
        }
        PROGRESS_CURRENT -= 1000 ;
        notificationBuilder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }


    @Override
    public void onFinish() {
        notificationBuilder.setContentTitle("إنتهي الوقت");
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
        try {Alarm();}
        catch (PendingIntent.CanceledException ignored){}
    }


    private void Alarm() throws PendingIntent.CanceledException {
        Intent wakeScreen  =  new Intent(activity, PostCountDown.class);
        PendingIntent timerEnd = PendingIntent.getBroadcast(activity, 0, wakeScreen, 0);
       // timerEnd.send();
         AlarmManager alarmManager = (AlarmManager)activity.getSystemService(Context.ALARM_SERVICE);
       alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,  SystemClock.elapsedRealtime() + 5000, timerEnd);


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

    private void NotificationSettings (Context activity){
        String CHANNEL_ID = "TimerEnd";
        Intent wakeScreen  =  new Intent(activity, ExoActivity.class);
       // wakeScreen.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent timerEnd = PendingIntent.getActivity(activity, 0, wakeScreen, PendingIntent.FLAG_CANCEL_CURRENT);

        notificationBuilder = new NotificationCompat.Builder(activity, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_exo)
                .setContentTitle("الوقت المتبقي")
                .setProgress(PROGRESS_MAX,PROGRESS_CURRENT,false)
                .setOngoing(true)
                .setSilent(true)
                .setAutoCancel(true)
                .setContentIntent(timerEnd)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        CreateNotification(CHANNEL_ID);
    }

    private void CreateNotification(String CHANNEL_ID){
        CharSequence CHANNEL_NAME = "ExoTimer";
        String CHANNEL_DESCRIPTION = "ExoTimer";
        notificationManager = activity.getSystemService(NotificationManager.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,  NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);

        }
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }

    public void DismissNotification(){
        notificationManager.cancelAll();
    }
}