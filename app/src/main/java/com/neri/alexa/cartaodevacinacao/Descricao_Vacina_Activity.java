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
        String nome = (String) intent.getSerializableExtra("vacina");
        String idade = (String) intent.getSerializableExtra("idade");
        String dose = (String) intent.getSerializableExtra("dose");
        String quantidade = (String) intent.getSerializableExtra("quantidade");
        String doenca = (String) intent.getSerializableExtra("doenca");
        String via  = (String) intent.getSerializableExtra("via");



        TextView Tnome = (TextView) findViewById(R.id.textViewNomeVacina);
        TextView Tidade = (TextView) findViewById(R.id.textViewIdade);
        TextView Tdose = (TextView) findViewById(R.id.textViewDose);
        TextView Tquantidade = (TextView) findViewById(R.id.textviewDoseview);
        TextView TviaAdministracao = (TextView) findViewById(R.id.textViewadministracao);
        TextView tDoenca = (TextView) findViewById(R.id.textViewdoenca);

       TextView tSite = (TextView) findViewById(R.id.textViewSite);

        Tnome.setText(nome);
        Tidade.setText("Idade: "+idade);
        Tquantidade.setText("Quanditade: "+ quantidade);
        tDoenca.setText("Doença Proteção: "+doenca);
        TviaAdministracao.setText("Via Administração: "+via);
        Tdose.setText("Dose:" +dose);

        tSite.setText("http://portalarquivos.saude.gov.br/campanhas/vacinareproteger/");

        tSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://portalarquivos.saude.gov.br/campanhas/vacinareproteger/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
