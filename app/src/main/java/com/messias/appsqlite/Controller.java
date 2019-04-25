package com.messias.appsqlite;

import android.content.Context;
import android.database.Cursor;

public class Controller {

    public String salvarCliente(Cliente c, Context context){
        Model model = new Model(context);
        return model.inserir(c.getNome(),c.getTel());

    }
    public Cursor listaClientes(Context context){
        Model model = new Model(context);
        return model.listar();
    }

}
