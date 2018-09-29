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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descicao_hospital);

        inicializacaoComponentes();

        Intent intent = getIntent();

        String unidade = (String) intent.getSerializableExtra("unidade");
        String bairro = (String) intent.getSerializableExtra("bairro");
        final String fone = (String) intent.getSerializableExtra("fone");
        final String endereco = (String) intent.getSerializableExtra("endereco");


        tUnidade.setText(unidade);
        tbairro.setText(bairro);
        tFone.setText(fone);
        tEndereco.setText(endereco);


        tFone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + fone);
                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (ActivityCompat.checkSelfPermission(DescicaoHospitalActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(intent);
            }
        });
/*
        tEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(endereco);
                Intent intent = new Intent(Intent.Maps)
            }
        });

*/


    }

    private  void inicializacaoComponentes(){
        tUnidade = (TextView) findViewById(R.id.textViewNomeHospital);
        tbairro = (TextView) findViewById(R.id.textViewBairro);
        tFone = (TextView) findViewById(R.id.textViewFone);
        tEndereco=(TextView) findViewById(R.id.textViewEndereco);

    }





}
