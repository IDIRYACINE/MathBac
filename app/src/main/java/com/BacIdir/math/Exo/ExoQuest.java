package com.BacIdir.math.Exo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.BacIdir.math.Controllers.BackBar;
import com.BacIdir.math.Controllers.QuestAdapter;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class ExoQuest extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_quest,container,false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            Settings(view);
        }

    private RecyclerView questGrid ;
    private void Settings(View root){
        int nQuest = Registre.Units[Registre.currentUnit].length ;
        questGrid = root.findViewById(R.id.grid_quest);
        questGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
        QuestAdapter adpter = new QuestAdapter(getActivity(), nQuest, 3);
        questGrid.setAdapter(adpter);

        ImageView backButton = root.findViewById(R.id.quest_icon);
        BackBar listener = new BackBar(getActivity());
        backButton.setOnClickListener(listener);
        Registre.exoQuest =this;

    }

    public void UpdateQuest(int position){
        questGrid.getChildAt(position).setBackgroundColor(Registre.unlockedQuestColor);
    }



}
