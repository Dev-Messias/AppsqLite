package com.messias.appsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Model {

    private SQLiteDatabase db;
    private CriaBanco banco;

    // -- CONTRUTOR --- //
    public Model(Context context){
        banco = new CriaBanco(context);

    }

    public Model() {

    }

    public String inserir(String nome, String tel){
        ContentValues v;
        long result;

        db = banco.getWritableDatabase();

        v = new ContentValues();
        v.put("nome", nome);
        v.put("tel", tel);

        result = db.insert("cliente", null, v);
        db.close();

        if (result == -1){
            return  "erro ao inserir registro";
        }else{
            return "Registro inserido com sucesso";
        }
    }
}
