package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import androidx.fragment.app.Fragment;
import com.BacIdir.math.Controllers.BackBar;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.R;

public class Graphs extends Fragment {
    private Database database;
    private View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_graphs, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        root = view;

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
            SetUpMarks(root);
            Settings(root);
        }
    };

    private void SetUpMarks(View root){
        int[] units = new int[]{R.id.unit1_rating,R.id.unit2_rating,R.id.unit3_rating,R.id.unit4_rating,R.id.unit5_rating};
        float[] marks = new float[5];
        database = new Database(getContext());
        database.Connect();
        database.SetGraphData(marks);
        for (int i = 0 ; i < 5 ;i++) {
            RatingBar unitBar = root.findViewById(units[i]) ;
            unitBar.setRating(marks[i]);
        }
    }




    //private GraphAdapter2 adapter ;

    private void Settings(View root){

        /*String[] dunit = new String[]{"الدوال", "المتتاليات ", "الاعداد المركبة ", "الهندسة في الفضاء", "الاحتمالات"};
        Marks = new float[5];
        adapter = new GraphAdapter2(getActivity(), dunit, Marks);
        GridView exoView = root.findViewById(R.id.grid_exo);
        exoView.setAdapter(adapter);*/

        ImageView backButton = root.findViewById(R.id.graph_icon);
        BackBar listener = new BackBar(getActivity());
        backButton.setOnClickListener(listener);
    }
/*
    private void OldWay(){
        database = new Database(getContext());
        database.Connect();
        database.SetGraphData(Marks);
        adapter.marks = Marks;
        adapter.notifyDataSetChanged();
    }

    */

}
