package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import com.BacIdir.math.Controllers.GraphAdapter2;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.R;

public class Graphs extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_graphs, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Settings(view);
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

    private volatile float[] Marks ;
    private GraphAdapter2 adapter ;
    private Database database;
    private void Settings(View root){
        String[] dunit = new String[]{"الدوال", "المتتاليات ", "الاعداد المركبة ", "الهندسة في الفضاء", "الاحتمالات"};
        Marks = new float[5];
        adapter = new GraphAdapter2(getActivity(), dunit, Marks);
        GridView exoView = root.findViewById(R.id.grid_exo);
        exoView.setAdapter(adapter);
    }


    private final Runnable SetGraphValues = new Runnable() {
        @Override
        public void run() {
            database = new Database(getContext());
            database.Connect();
            database.SetGraphData(Marks);
            adapter.marks = Marks;
            adapter.notifyDataSetChanged();
        }
    };



}
