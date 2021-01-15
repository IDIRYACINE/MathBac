package com.BacIdir.math.Exo;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.BacIdir.math.Controllers.ExoAdapter;
import com.BacIdir.math.Controllers.GraphAdapter;
import com.BacIdir.math.Controllers.GraphAdapter2;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.R;

public class Graphs extends Fragment {

    private View root ;
    private String[] Dunit ;
    private float[] Marks ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if ( savedInstanceState == null) {
            root = inflater.inflate(R.layout.fragment_graphs,container,false);
            // get data
            Dunit = new String[] {"الدوال", "المتتاليات ", "الاعداد المركبة ", "الهندسة في الفضاء","الاحتمالات"};//{"الدوال", "المتتاليات ", "الاحتمالات", "الاعداد المركبة ", "الهندسة في الفضاء "};
            Marks = new float[5];
            getData();

        }

        return root;

    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {

            GridView ExoView = view.findViewById(R.id.grid_exo);
            GraphAdapter2 adapter = new GraphAdapter2(getActivity(), Dunit,Marks);
            ExoView.setAdapter(adapter);

        }
    }

    private void getData(){

        Database db = new Database(getContext());
        db.Connect();
        String[] tables = Database.T;
        int position = 0 ;
        float mark = 0;

        for (int i = 0 ; i < tables.length ; i++){
            Cursor cursor = db.FetchData(tables[i],new String[]{"mark"}) ;

            if (cursor.getCount()>0){
                while (cursor.moveToPosition(position)){

                    mark += cursor.getInt(0);
                    position += 1 ;

                }
                mark = mark / position ;
                Marks[i] = mark ;
                position = 0;
                mark = 0 ;

            }

        }


    }

}
