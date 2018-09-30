package cartao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.neri.alexa.cartaodevacinacao.R;
import com.neri.alexa.cartaodevacinacao.login.ConexaoFirebase;

import java.util.UUID;
import modal.VacinasTomadas;


public class AdicionarVacinaActivity extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextDose;
    private EditText editTextData;
    private Button btnCadastro;

    private FirebaseAuth firebaseAuth;
    Firebase objRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_vacina);

         inicializacaoComponentes();
         onClick();
    }

    private void onClick() {

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editTextNome.getText().toString();
                String dose = editTextDose.getText().toString();
                String data = editTextData.getText().toString();
                addVacina(nome,dose,data);
                Intent intent = new Intent(AdicionarVacinaActivity.this , CartaoVacinaActivity.class);
                startActivity(intent);

                finish();
            }

        });
    }

    private void addVacina(String nome, String dose, String data){

        String uid  = (UUID.randomUUID().toString());
        VacinasTomadas u = new VacinasTomadas(nome,dose,data,uid);
        objRef= new Firebase("https://cartaovacina-123.firebaseio.com/users");
        firebaseAuth = ConexaoFirebase.getFirebaseAuth();
        Firebase nRef = objRef.child(firebaseAuth.getUid()).child(uid);
        nRef.setValue(u);
    }

    private void inicializacaoComponentes(){
        btnCadastro = (Button) findViewById(R.id.buttonSalvarUsuario);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextDose =  (EditText) findViewById(R.id.editTextDose);
        editTextData = (EditText) findViewById(R.id.editTextData);
    }
}
