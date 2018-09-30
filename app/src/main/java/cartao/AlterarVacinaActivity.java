package cartao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.neri.alexa.cartaodevacinacao.R;
import com.neri.alexa.cartaodevacinacao.login.ConexaoFirebase;

import Repositorio.RepositorioUsuario;
import modal.VacinasTomadas;

public class AlterarVacinaActivity extends AppCompatActivity {

    private TextView tNome;
    private TextView tDose;
    private TextView tData;
    private Button btnExcluir;
    private Button btnAlterarVacina;
    private EditText editTextNome;
    private EditText editTextDose;
    private EditText editTextData;
    private String uid;
    private String nome;
    private String dose;
    private String data;

    Firebase objRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_vacina);

        getValueIntent();
        inicializarComponentes();
        setTextView();
        onClicks();
    }

    private void setTextView() {
        tNome.setText("Vacina: "+nome);
        tDose.setText("Dose: "+dose);
        tData.setText("Data Vacinacao: "+data);
    }

    private void onClicks() {
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirVacina();
                Intent intent = new Intent(AlterarVacinaActivity.this , CartaoVacinaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAlterarVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeVacina = editTextNome.getText().toString();
                String doseVacina = editTextDose.getText().toString();
                String dataVacina = editTextData.getText().toString();
                atualizarVacina(nomeVacina,doseVacina,dataVacina);
                Intent intent = new Intent(AlterarVacinaActivity.this , CartaoVacinaActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }

    private void atualizarVacina( String nome, String dose, String data){
        VacinasTomadas u = new VacinasTomadas(nome,dose,data,uid);
        Firebase.setAndroidContext(this);
        objRef = new Firebase ("https://cartaovacina-123.firebaseio.com/users/" + ConexaoFirebase.getFirebaseAuth().getUid());
        objRef.child(uid).setValue(u);
    }

    private void excluirVacina() {
        Firebase.setAndroidContext(this);
        objRef = new Firebase ("https://cartaovacina-123.firebaseio.com/users/" + ConexaoFirebase.getFirebaseAuth().getUid());
        objRef.child(uid).removeValue();
    }

    private void inicializarComponentes() {
        editTextData = (EditText) findViewById(R.id.editTextAlterarData);
        editTextDose = (EditText) findViewById(R.id.editTextAlterarDose);
        editTextNome = (EditText) findViewById(R.id.editTextAlterarNomeVacina);
        btnAlterarVacina = (Button) findViewById(R.id.buttonAlterarVacina);
        btnExcluir = (Button) findViewById(R.id.buttonExcluir);
        tNome = (TextView) findViewById(R.id.textViewAlterarNome);
        tData = (TextView) findViewById(R.id.textViewAlterarData);
        tDose = (TextView) findViewById(R.id.textViewAlterarDose);
    }

    public void getValueIntent() {
        Intent i = getIntent();
        uid = (String) i.getSerializableExtra("uid");
        nome = (String) i.getSerializableExtra("nome");
        dose = (String) i.getSerializableExtra("dose");
        data =  (String) i.getSerializableExtra("data");
    }
}
