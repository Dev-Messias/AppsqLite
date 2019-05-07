package com.messias.appsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListaActivity extends AppCompatActivity {

    ListView lista;
    Cursor cursor;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        final Controller c  =new Controller();
        cursor = c.listaClientes(getBaseContext());

        String[] campos = new String[]{"_id","nome","tel"};
        int[] idViews = new int[]{R.id.id,R.id.nome,R.id.tel};

        SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_activity,cursor,campos,idViews,0);

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(ad);
    }
}
