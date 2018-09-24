package com.neri.alexa.cartaodevacinacao;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.neri.alexa.cartaodevacinacao.login.ConexaoFirebase;

public class CadastroActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button btnCadastrar;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Boolean nbAtivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializaComponentes();
        onClicks();
    }

    private void onClicks(){

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                criarUser(email,senha);
            }
        });
    }

    private void criarUser(String email, String senha){
        auth.createUserWithEmailAndPassword(email,senha).
                addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            alert("cadastrado com sucesso");
                            Intent i = new Intent(CadastroActivity.this, TelaInicialActivity.class);
                            startActivity(i);
                            finish();

                        }else{
                            alert("Erro ao cadastrar");
                        }
                    }
                });
    }

    private void inicializaComponentes(){
        editEmail = (EditText) findViewById(R.id.editEmailCadastro);
        editSenha = (EditText) findViewById(R.id.editSenhaCadastro);
        btnCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        progressBar = (ProgressBar)findViewById(R.id.progressBarCadastrar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = ConexaoFirebase.getFirebaseAuth();
    }

    private void alert(String msg){
        Toast.makeText(CadastroActivity.this,msg,Toast.LENGTH_SHORT).show();

    }
}
