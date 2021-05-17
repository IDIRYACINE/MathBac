package com.BacIdir.math.Timer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class PostCountDown extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       SetUpVibration(context);
       WakeScreen(context);
    }

    private void SetUpVibration(Context context){
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        int VIBRATION_DURATION = 3000;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            VibrationEffect vibrationEffect = VibrationEffect.createOneShot(VIBRATION_DURATION,VibrationEffect.DEFAULT_AMPLITUDE);
            vibrator.vibrate(vibrationEffect);
        }
        else {
            vibrator.vibrate(VIBRATION_DURATION);
        }
    }

    private void WakeScreen(Context context){
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock fullWakeLock = powerManager.newWakeLock( PowerManager.FULL_WAKE_LOCK| PowerManager.ACQUIRE_CAUSES_WAKEUP
                | PowerManager.ON_AFTER_RELEASE, "math:wakelocktag.");
        fullWakeLock.acquire(60*1000L);
    }
}
