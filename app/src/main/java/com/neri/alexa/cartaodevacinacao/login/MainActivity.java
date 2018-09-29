package com.neri.alexa.cartaodevacinacao.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.neri.alexa.cartaodevacinacao.R;
import com.neri.alexa.cartaodevacinacao.TelaInicialActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button btnLogar;
    private TextView txtCadastro, txtRecuperarSenha;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Restira a actionBar
        setContentView(R.layout.activity_main);
        inicializaComponetes();
        eventoClicks();
    }

    private void eventoClicks(){
        txtRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ResetarSenhaActivity.class);
                startActivity(i);
            }
        });

        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CadastroActivity.class);
                startActivity(i);
            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  String email = editEmail.getText().toString().trim();
             //  String senha = editSenha.getText().toString().trim();
                String email = "alexandre944@gmail.com";
                        String senha = "23031992";
               login(email,senha);

            }
        });
    }
    private void alert(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    private  void login(String email, String senha){
//        alert("AGUARDE....");
         auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i = new Intent(MainActivity.this, TelaInicialActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    alert("Email ou senha errado");
                }
            }
        });
    }

    private void inicializaComponetes(){
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);
        txtCadastro = (TextView) findViewById(R.id.textViewCadastrar);
        btnLogar = (Button) findViewById(R.id.buttonLogin);
        txtRecuperarSenha = (TextView) findViewById(R.id.textViewEsqueciSenha);
    }

    protected void onStart() {
        super.onStart();
        auth = ConexaoFirebase.getFirebaseAuth();
    }
}
