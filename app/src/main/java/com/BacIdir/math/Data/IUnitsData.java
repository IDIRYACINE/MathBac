package com.BacIdir.math.Data;

import android.app.Activity;
import android.content.Context;
import android.widget.RatingBar;

public abstract class IUnitsData {

    public static void GetUnitData(float[] Marks , Context context) {
        Database database = new Database(context);
        database.Connect();
        database.GetUnitsData(Marks);
    }

    public static void SaveExoMark(Activity activity,RatingBar markBar) {
        Database db = new Database(activity);
        db.Connect();
        db.SaveMark(markBar);
        db.Disconect();
    }


}
