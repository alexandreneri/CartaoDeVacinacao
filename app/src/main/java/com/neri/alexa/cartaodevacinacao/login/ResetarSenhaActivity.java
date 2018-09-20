package com.neri.alexa.cartaodevacinacao.login;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.neri.alexa.cartaodevacinacao.R;

public class ResetarSenhaActivity extends AppCompatActivity {

    private EditText editEmail;
    private Button btnRecuperarSenha;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetar_senha);
        inicializaComponentes();
        onClicks();
    }
    private void onClicks(){
        btnRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                resetSenha(email);

            }
        });


    }

    private void resetSenha(String email){

        auth.sendPasswordResetEmail(email).addOnCompleteListener(ResetarSenhaActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    alert("Um email foi enviado para sua caixa de email");
                }else{
                    alert("seu email esta errado");
                }

            }
        });
    }

    private  void alert(String s){
        Toast.makeText(ResetarSenhaActivity.this,s, Toast.LENGTH_SHORT).show();

    }

    private void inicializaComponentes(){
        editEmail = (EditText) findViewById(R.id.editTextEmailResetar);
        btnRecuperarSenha = (Button) findViewById(R.id.buttonResetar);
        }

    @Override
    protected void onStart() {
        super.onStart();
        auth =  ConexaoFirebase.getFirebaseAuth();
    }
}
