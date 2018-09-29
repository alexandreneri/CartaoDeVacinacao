package cartao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.neri.alexa.cartaodevacinacao.R;

import Repositorio.RepositorioUsuario;

public class AlterarUsuarioActivity extends AppCompatActivity {

    private Button btnExcluir;
    private  Button btnAlterarVacina;
    private EditText editTextNome;
    private EditText editTextDose;
    private EditText editTextData;
    private RepositorioUsuario repositorioUsuario;
    String uidVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_usuario);

        Intent i = getIntent();

        uidVacina = (String) i.getSerializableExtra("uidVacina");

        inicializarComponentes();
        onClicks();

    }

    private void onClicks() {

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                repositorioUsuario.deletar(AlterarUsuarioActivity.this, uidVacina);


            }
        });


        btnAlterarVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String dose = editTextDose.getText().toString();
                String data = editTextData.getText().toString();

                repositorioUsuario.atualizar(AlterarUsuarioActivity.this, nome,dose,data,uidVacina);
            }
        });
    }


    private void excluirVacina() {
        Firebase firebase = new Firebase("https://cartaovacina-123.firebaseio.com/users/R93UZ6Xo1rhJcbWtKcnGhVFnZFa2/-LNSUwpZlw-0-fIsYnab");

    }

    private void inicializarComponentes() {

        editTextData = (EditText) findViewById(R.id.editText);
        editTextDose = (EditText) findViewById(R.id.editText2);
        editTextNome = (EditText) findViewById(R.id.editText3);

        repositorioUsuario = new RepositorioUsuario();
        btnAlterarVacina = (Button) findViewById(R.id.buttonAlterarVacina);
        btnExcluir = (Button) findViewById(R.id.buttonExcluir);
    }
}
