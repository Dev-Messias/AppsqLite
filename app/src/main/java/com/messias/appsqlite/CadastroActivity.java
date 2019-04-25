package com.messias.appsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private Button btSalvar;
    private EditText ctNome, ctTel;
    Controller controller = new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ctNome = findViewById(R.id.ct_nome);
        ctTel = findViewById(R.id.ct_telefone);

        btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Model model = new Model(getBaseContext());
                Cliente c = new Cliente();
                c.setNome(ctNome.getText().toString());
                c.setNome(ctTel.getText().toString());controller.inserirBanco(c.getNome(), c.getTel());
                String result = model.inserir(c.getNome(),c.getTel());
                Toast.makeText(getBaseContext(), controller.toString(),Toast.LENGTH_LONG).show();*/
                Controller controller = new Controller();
                Cliente c = new Cliente();

                c.setNome(ctNome.getText().toString());
                c.setTel(ctTel.getText().toString());

                String result = controller.salvarCliente(c, getBaseContext());
                Toast.makeText(getBaseContext(), result,Toast.LENGTH_LONG).show();
            }
        });
    }
}
