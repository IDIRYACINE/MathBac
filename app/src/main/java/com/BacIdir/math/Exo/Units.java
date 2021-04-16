package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.BacIdir.math.Controllers.UnitAdpter;
import com.BacIdir.math.R;

public class Units extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_units, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Settings(view);
    }


    private void Settings (View root){
        NavHostFragment host = (NavHostFragment) getParentFragment() ;
        NavController controller = host.getNavController();
        String[] Units = {"الدوال", "المتتاليات ", "الاعداد المركبة ", "الهندسة في الفضاء","الاحتمالات","تقييمك"};
        GridView gridView = root.findViewById(R.id.grid_units);
        UnitAdpter adpter = new UnitAdpter(getActivity(),controller,Units,2 );
        gridView.setAdapter(adpter);
    }

}
