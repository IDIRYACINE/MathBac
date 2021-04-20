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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_hint, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Settings(view);
    }


    private void Settings(View root){
        int[] data = Registre.Hints[Registre.currentUnit];
        ExoAdapter adapter = new ExoAdapter(getActivity(), data);
        RecyclerView exoView = root.findViewById(R.id.grid_exo);
        exoView.setLayoutManager(new LinearLayoutManager(getActivity()));
        exoView.setAdapter(adapter);
    }
}
