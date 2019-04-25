package com.messias.appsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    ListView lista;
    Cursor cursor;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }
}
