package Hospital;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

import java.net.URL;
import java.util.List;

public class DescicaoHospitalActivity extends AppCompatActivity {
    private TextView tUnidade;
    private TextView tbairro;
    private TextView tFone;
    private TextView tEndereco;
    private String unidade;
    private String bairro;
    private String endereco;
    private String fone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descicao_hospital);

        inicializacaoComponentes();
        getValuesIntent();
        setTextView();
    }

    private void setTextView() {
        tUnidade.setText(unidade);
        tbairro.setText(bairro);
        tFone.setText(fone);
        tEndereco.setText(endereco);
    }


    private  void inicializacaoComponentes(){
        tUnidade = (TextView) findViewById(R.id.textViewNomeHospital);
        tbairro = (TextView) findViewById(R.id.textViewBairro);
        tFone = (TextView) findViewById(R.id.textViewFone);
        tEndereco=(TextView) findViewById(R.id.textViewEndereco);
    }

    public void getValuesIntent() {
        Intent intent = getIntent();
        unidade = (String) intent.getSerializableExtra("unidade");
        bairro = (String) intent.getSerializableExtra("bairro");
        fone = (String) intent.getSerializableExtra("fone");
        endereco = (String) intent.getSerializableExtra("endereco");
    }
}
