package cartao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.neri.alexa.cartaodevacinacao.R;

import java.util.ArrayList;

import Repositorio.RepositorioUsuario;
import adapter.UsuarioAdapter;
import modal.VacinasTomadas;

public class CartaoVacinaActivity extends Activity {


    private Button btnCadastraUsuario;
    private ListView listView;
    private UsuarioAdapter usuarioAdapter;
    private RepositorioUsuario bancoDadosVacina;
    private ArrayList<VacinasTomadas> arrayListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_vacina);
        inicializacaoComponentes();
        json();
        onClicks();

        listView.deferNotifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CartaoVacinaActivity.this, AlterarUsuarioActivity.class);
                intent.putExtra("uidVacina", arrayListUser.get(position).getUidVacina());
             //   intent.putExtra("dose",arrayListUser.get(position).get);

                startActivity(intent);
            }
        });
    }

    private  void json(){

        bancoDadosVacina = new RepositorioUsuario();
        arrayListUser = bancoDadosVacina.readJson(this);
        usuarioAdapter= new UsuarioAdapter(this,arrayListUser);

            listView.setAdapter(usuarioAdapter);

    }




    private void onClicks() {
        btnCadastraUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartaoVacinaActivity.this, CadastraUsuarioActivity.class);
                startActivity(i);
            }
        });
    }

    private void inicializacaoComponentes() {
        btnCadastraUsuario = (Button) findViewById(R.id.buttonNovoPerfil);
        listView = (ListView) findViewById(R.id.listviewUsuario);
    }
}
