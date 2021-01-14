package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.*;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.BacIdir.math.Controllers.ExoAdapter;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class Exo extends Fragment {


    private int[] data ;
    private View root ;
    private GestureDetector gestureDetector ;
    ImageView exo ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        if ( savedInstanceState == null) {
            data = Registre.Units[Registre.Unit];
            root = inflater.inflate(R.layout.fragment_exo,container,false);

            Gesture gesture = new Gesture();
            gestureDetector = new GestureDetector(getActivity(),gesture);
            root.setOnTouchListener(gesture);

        }

        return root;

    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {

            exo = view.findViewById(R.id.exo_image);
            exo.setImageResource(data[Registre.Exo]);

        }
    }

    private class Gesture extends SimpleOnGestureListener implements View.OnTouchListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

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
                    Next();

                }
                else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                    Prev();
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

        private void Next (){
            if (Registre.Exo + 1 < data.length){
                Registre.Exo +=1 ;
                exo.setImageResource(data[Registre.Exo]);
            }

        }

        private void Prev (){
            if (Registre.Exo - 1 >= 0){
                Registre.Exo -= 1 ;
                exo.setImageResource(data[Registre.Exo]);
            }
        }

    }


}


