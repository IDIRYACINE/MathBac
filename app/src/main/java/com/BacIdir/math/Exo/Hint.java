package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.BacIdir.math.Controllers.ExoAdapter;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class Hint extends Fragment {

    private int[]data;
    private View root ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if ( savedInstanceState == null) {
            data = Registre.Hints[Registre.Unit];
            root = inflater.inflate(R.layout.fragment_hint,container,false);


        }

        return root;

    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {

            RecyclerView ExoView = view.findViewById(R.id.grid_exo);
            ExoAdapter adapter = new ExoAdapter(getActivity(), data);
            ExoView.setLayoutManager(new LinearLayoutManager(getActivity()));
            ExoView.setAdapter(adapter);

        }
    }

}
