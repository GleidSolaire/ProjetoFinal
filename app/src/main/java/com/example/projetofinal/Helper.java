package com.example.projetofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public static  final String  DB = "db_produtos";
    public static  final String TABELA = "produtos";
    public  static  final  String ID = "ID_Produto";
    public  static  final  String NOME = "nome";
    public  static  final  String CATEGORIA = "categoria";
    public  static  final  String PRECO = "preco";
    public  static  final  int VERSAO =1;

    public Helper(@Nullable Context context) {
        super(context, DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = " CREATE TABLE IF NOT EXISTS " + TABELA + " ( "+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOME + " VARCHAR," +
                CATEGORIA + " VARCHAR,"+
                PRECO + " VARCHAR ); ";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABELA);

        onCreate(db);

    }


}
