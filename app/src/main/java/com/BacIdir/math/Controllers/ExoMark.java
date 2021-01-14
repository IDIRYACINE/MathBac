package com.BacIdir.math.Controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class ExoMark extends AlertDialog implements View.OnClickListener {

    private Context activity ;

    public ExoMark(@NonNull Context context) {
        super(context);
        this.activity = context ;
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogue_mark);

        Button yes = findViewById(R.id.btn_submit);
        yes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_submit:
                Save();
                dismiss();
                break;
        }
        dismiss();
    }


    private void Save(){

        Database db = new Database(activity);
        RatingBar bar = this.findViewById(R.id.exo_star);
        ContentValues values = new ContentValues();

        float rating = bar.getRating();

        values.put("mark",rating);

        db.Connect();



        if (db.UpdateData(Database.T[Registre.Unit],values,Registre.Exo) == 0){
            values.put("exo",Registre.Exo);
            db.InsertData(Database.T[Registre.Unit],values); }

        else {db.UpdateData(Database.T[Registre.Unit],values,Registre.Exo);}



        db.Disconect();






    }

}
