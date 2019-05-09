package com.messias.appsqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListaActivity extends AppCompatActivity {

    ListView lista;
    Cursor cursor;
    String codigo;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        final Controller c = new Controller();
        cursor = c.listaClientes(getBaseContext());

        String[] campos = new String[]{"_id", "nome", "tel"};
        final int[] idViews = new int[]{R.id.id, R.id.nome, R.id.tel};

        SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_activity, cursor, campos, idViews, 0);

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(ad);

        // --- CLICK DO ITEM DA LISTA --- //
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             cursor.moveToPosition(position);
             codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
             AlertDialog.Builder builder = new AlertDialog.Builder(ListaActivity.this);
             builder.setTitle("");
             builder.setMessage("O que deseja fazer ?");
             builder.setPositiveButton("alterar", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                     Intent intent = new Intent(ListaActivity.this, CadastroActivity.class);
                     startActivity(intent);

                 }
             });

             builder.setNegativeButton("excluir", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                 }
             });
             alerta = builder.create();
             alerta.show();

            }
        });

    }
}
