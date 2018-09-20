package com.neri.alexa.cartaodevacinacao;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.neri.alexa.cartaodevacinacao.login.ConexaoFirebase;
import com.neri.alexa.cartaodevacinacao.login.MainActivity;

public class TelaInicialActivity extends AppCompatActivity {

    private Button btnSair, btnVacina, btnHospital, btnCartao, btnImc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        inicializaComponetes();
        onClicks();

    }

    private void onClicks(){
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexaoFirebase.logOut();
                Intent i = new Intent(TelaInicialActivity.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });

        btnVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaInicialActivity.this, VacinasActivity.class);
                startActivity(i);
            }
        });

        btnHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(TelaInicialActivity.this, HospitalActivity.class);
                startActivity(i);
            }
        });

        btnCartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaInicialActivity.this, CartaoVacinaActivity.class);
                startActivity(i);
            }
        });



        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaInicialActivity.this, ImcActivity.class);
                startActivity(i);
            }
        });


    }



    private void inicializaComponetes(){
        btnSair = (Button) findViewById(R.id.buttonSair);
        btnVacina = (Button) findViewById(R.id.buttonVacinas);
        btnHospital = (Button) findViewById(R.id.buttonHospital);

        btnCartao = (Button) findViewById(R.id.buttonCartaoVacina);
        btnImc = (Button) findViewById(R.id.buttonImc);

    }
}
