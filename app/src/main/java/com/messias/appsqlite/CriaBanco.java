package com.messias.appsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    // --- CRIANDO BASE DE DADOS COM O NOME EMPRESA BD --- //
    public CriaBanco (Context context){
        super(context, "empresa db",null,2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // --- CRIANDO TABELA NO BANDO DE DADOS COM TRÊS CAMPOS ID, NOME, TEL --- //
        String sql = "CREATE TABLE cliente (" +
                "_id integer primary key autoincrement not null," +
                "nome text," +
                "tel text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL("DROP TABLE IF EXISTS cliente");
       onCreate(db);
    }
}
