package com.neri.alexa.cartaodevacinacao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Descricao_Vacina_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao__vacina);


        Intent intent = getIntent();
        String nome = (String) intent.getSerializableExtra("nome");
        String idade = (String) intent.getSerializableExtra("idade");
        String dose = (String) intent.getSerializableExtra("dose");
        String quantidade = (String) intent.getSerializableExtra("quantidade");

        /*
        TextView Tsite = (TextView)findViewById(R.id.textVIewSite) ;
        TextView Tnome = (TextView) findViewById(R.id.textViewNome);
        TextView Tidade = (TextView) findViewById(R.id.textViewIdade);
        TextView Tdose = (TextView) findViewById(R.id.textViewDose);
        TextView Tquantidade = (TextView) findViewById(R.id.TextViewQtd);

        Tnome.setText(nome);
        Tidade.setText(idade);

        Tdose.setText(dose);
        Tquantidade.setText(quantidade);
        Tsite.setText("http://portalarquivos.saude.gov.br/campanhas/vacinareproteger/");

        Tsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://portalarquivos.saude.gov.br/campanhas/vacinareproteger/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                startActivity(intent);
            }
        }); */

    }
}
