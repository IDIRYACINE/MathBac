package com.BacIdir.math.Controllers;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.BacIdir.math.Exo.Exo;

public class CustomGesture extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {


    public CustomGesture(Exo exo) {
       this.exo = exo ;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    private Exo exo ;
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {

        final int SWIPE_MIN_DISTANCE = 120;
        final int SWIPE_MAX_OFF_PATH = 250;
        final int SWIPE_THRESHOLD_VELOCITY = 200;
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                exo.NextExo();

            }
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                exo.PrevExo();
            }
        } catch (Exception e) {
            // nothing
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private GestureDetector gestureDetector ;
    public void SetGestureDetector(GestureDetector detector){
        gestureDetector = detector ;
    }
}