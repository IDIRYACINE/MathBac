package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import com.BacIdir.math.Controllers.QuestAdapter;
import com.BacIdir.math.Controllers.UnitsAdpter;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class ExoQuest extends Fragment {

    private View root ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if ( savedInstanceState == null) {
             root = inflater.inflate(R.layout.fragment_quest,container,false);

        }

        return root;

    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int nQuest = Registre.Units[Registre.Unit].length;
        if (savedInstanceState == null) {


            GridView gridView = view.findViewById(R.id.grid_quest);
            QuestAdapter adpter = new QuestAdapter(getActivity(), nQuest, 3);
            gridView.setAdapter(adpter);

        }
    }
}
