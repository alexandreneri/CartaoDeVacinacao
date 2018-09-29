package cartao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.neri.alexa.cartaodevacinacao.R;

import Repositorio.RepositorioUsuario;
import adapter.HospitalAdapter;
import adapter.UsuarioAdapter;

public class CadastraUsuarioActivity extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextSexo;
    private Button btnCadastro;
     private EditText editTextData;



    private RepositorioUsuario bancoDadosVacina;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_usuario);

         inicializacaoComponentes();
         onClick();



    }





    private void onClick() {

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bancoDadosVacina = new RepositorioUsuario();
                String nome = editTextNome.getText().toString();
                String sexo = editTextSexo.getText().toString();
                String data = editTextData.getText().toString();


                bancoDadosVacina.cadastroUser(nome, sexo, data);


                finish();
            }

        });
    }






    private void inicializacaoComponentes(){
        Firebase.setAndroidContext(this);

        btnCadastro = (Button) findViewById(R.id.buttonSalvarUsuario);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextSexo =  (EditText) findViewById(R.id.editTextSexo);
        editTextData = (EditText) findViewById(R.id.editTextData);



    }
}
