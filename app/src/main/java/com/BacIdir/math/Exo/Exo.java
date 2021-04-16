package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.BacIdir.math.Controllers.CustomGesture;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.ExoActivity;
import com.BacIdir.math.R;

public class Exo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_exo, container, false);
    }


    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Settings(view);
    }

    private ImageView exo ;
    private int[] data ;
    private void Settings(View root){
        data = Registre.Units[Registre.Unit];
        exo = root.findViewById(R.id.exo_image);
        exo.setImageResource(data[Registre.Exo]);
        CustomGesture gesture = new CustomGesture(this);
        GestureDetector gestureDetector = new GestureDetector(getActivity(), gesture);
        gesture.SetGestureDetector(gestureDetector);
        root.setOnTouchListener( gesture);
    }


        public void NextExo (){
            boolean ExoStarted = ExoActivity.ExoStarted ;
            if ((Registre.Exo + 1 < data.length)&&(!ExoStarted)){
                Registre.Exo +=1 ;
                exo.setImageResource(data[Registre.Exo]);
            }
        }

        public void PrevExo (){
            boolean ExoStarted = ExoActivity.ExoStarted ;
            if ((Registre.Exo - 1 >= 0) &&(!ExoStarted)){
                Registre.Exo -= 1 ;
                exo.setImageResource(data[Registre.Exo]);
            }
        }

    }