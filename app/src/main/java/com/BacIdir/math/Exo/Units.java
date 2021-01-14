package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.BacIdir.math.Controllers.UnitsAdpter;
import com.BacIdir.math.R;

public class Units extends Fragment {

    private View root ;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {


        if ( savedInstanceState == null) {
            root = inflater.inflate(R.layout.fragment_units,container,false);


        }

        return root;

    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null){

            NavHostFragment host = (NavHostFragment) getParentFragment() ;
        NavController controller = host.getNavController();


        String[] Units = {"الدوال", "المتتاليات ", "الاحتمالات", "الاعداد المركبة ", "الهندسة في الفضاء "};

        GridView gridView = view.findViewById(R.id.grid_units);
        UnitsAdpter adpter = new UnitsAdpter(getActivity(),controller,Units,2 );
        gridView.setAdapter(adpter);

    }
    }

}
