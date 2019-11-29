package com.example.projetofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Gateway {

    private static  Gateway gateway;
    private SQLiteDatabase db;

    public Gateway (Context context){

        Helper helper = new Helper(context);
        db = helper.getWritableDatabase();
    }

    public  static  Gateway getInstance(Context context){

        if (gateway == null) {
            gateway = new Gateway(context);
        }
        return gateway;
    }

    public SQLiteDatabase getDb() {
        return this.db;
    }


}
