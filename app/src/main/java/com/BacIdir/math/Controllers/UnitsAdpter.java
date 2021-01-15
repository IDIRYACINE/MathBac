package com.BacIdir.math.Controllers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class UnitsAdpter extends BaseAdapter implements View.OnClickListener{

    private Context context ;
    private String[] objects ;
    private LayoutInflater inflater ;
    private int nColumns ;
    private NavController controller ;


    public UnitsAdpter(Context context ,NavController controller ,String[] objects ,int nColumns){
        this.context = context ;
        this.inflater = LayoutInflater.from(context);
        this.objects = objects ;
        this.nColumns = nColumns ;
        this.controller = controller ;
    }

    @Override
    public int getCount() {
        return objects.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int nRows = objects.length % nColumns == 0 ? objects.length /nColumns : (objects.length+1) / nColumns;
        int height = (parent.getHeight() - 40 ) / nRows;

        convertView = inflater.inflate(R.layout.blueprint_unit,parent,false);
        convertView.getLayoutParams().height = height;
        Integer pos = position ;
        convertView.setTag(pos);
        convertView.setOnClickListener(this);

        if (position == objects.length - 1){convertView.getLayoutParams().width = parent.getWidth();}

        ImageView icon = convertView.findViewById(R.id.unit_icon);
        TextView title = convertView.findViewById(R.id.unit_title);
        icon.getLayoutParams().width = (parent.getWidth() - 10 ) / nColumns;
        icon.getLayoutParams().height = height / 2;

        title.setText(objects[position]);

        return convertView;
    }


    @Override
    public void onClick(View v) {
        Registre.Unit = (int) v.getTag();
        controller.navigate(R.id.exoQuest,null,new  NavOptions.Builder().setPopUpTo(R.id.exoQuest,true).build());
    }
}
