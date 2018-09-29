package vacina;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

public class Descricao_Vacina_Activity extends AppCompatActivity {

    private TextView tNome;
    private TextView tIdade;
    private TextView tDose;
    private TextView tQuantidade;
    private TextView tAdministracao;
    private TextView tDoenca;
    private TextView tSite;
    private String nome;
    private String idade;
    private String dose;
    private String quantidade;
    private String doenca;
    private String via;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao__vacina);
        
        inicializacaoComponentes();
        getValoresIntent();
        setTextView();
        onClick();
    }

    private void setTextView() {
        tNome.setText(nome);
        tIdade.setText("Idade: "+idade);
        tQuantidade.setText("Quanditade: "+ quantidade);
        tDoenca.setText("Doença Proteção: "+doenca);
        tAdministracao.setText("Via Administração: "+via);
        tDose.setText("Dose:" +dose);
        tSite.setText("http://portalarquivos.saude.gov.br/campanhas/vacinareproteger/");
    }

    private void onClick() {
        tSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://portalarquivos.saude.gov.br/campanhas/vacinareproteger/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void inicializacaoComponentes() {
        tNome = (TextView) findViewById(R.id.textViewNomeVacina);
        tIdade = (TextView) findViewById(R.id.textViewIdade);
        tDose = (TextView) findViewById(R.id.textViewDose);
        tQuantidade = (TextView) findViewById(R.id.textviewDoseview);
        tAdministracao = (TextView) findViewById(R.id.textViewadministracao);
        tDoenca = (TextView) findViewById(R.id.textViewdoenca);
        tSite = (TextView) findViewById(R.id.textViewSite);
    }

    public void getValoresIntent() {
        intent = getIntent();
        nome = (String) intent.getSerializableExtra("vacina");
        idade = (String) intent.getSerializableExtra("idade");
        dose = (String) intent.getSerializableExtra("dose");
        quantidade = (String) intent.getSerializableExtra("quantidade");
        doenca = (String) intent.getSerializableExtra("doenca");
         via  = (String) intent.getSerializableExtra("via");
    }
}
