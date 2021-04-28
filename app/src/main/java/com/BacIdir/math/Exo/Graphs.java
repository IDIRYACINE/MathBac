package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import androidx.fragment.app.Fragment;
import com.BacIdir.math.Controllers.BackBar;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.R;

import static android.os.Looper.getMainLooper;

public class Graphs extends Fragment {
    private Database database;
    private View root;
    private Handler handler ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_graphs, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        root = view;
        Settings(root);

    }

    @Override
    public void onResume() {
        super.onResume();
        Thread Background = new Thread(SetGraphValues);
        Background.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        database.Disconect();
    }

    private final Runnable SetGraphValues = new Runnable() {
        @Override
        public void run() {
            SetUpMarks();
        }
    };

    private void UpdateGraph(final float[] marks){
       handler.post(new Runnable() {
           @Override
           public void run() {
               int[] units = new int[]{R.id.unit1_rating,R.id.unit2_rating,R.id.unit3_rating,R.id.unit4_rating,R.id.unit5_rating};
               for (int i = 0 ; i < 5 ;i++) {
                   RatingBar unitBar = root.findViewById(units[i]) ;
                   unitBar.setRating(marks[i]);}
           }
       });
    }

    private void SetUpMarks(){
        float[] marks = new float[5];
        database = new Database(getContext());
        database.Connect();
        database.SetGraphData(marks);
        UpdateGraph(marks);
        }

    private void Settings(View root){
        handler = new Handler(getMainLooper());
        ImageView backButton = root.findViewById(R.id.graph_icon);
        BackBar listener = new BackBar(getActivity());
        backButton.setOnClickListener(listener);
    }


}
