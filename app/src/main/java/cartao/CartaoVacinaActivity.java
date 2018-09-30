package cartao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.neri.alexa.cartaodevacinacao.R;
import com.neri.alexa.cartaodevacinacao.login.ConexaoFirebase;

import java.util.ArrayList;
import adapter.VacinasTomadasAdapter;
import modal.VacinasTomadas;

public class CartaoVacinaActivity extends Activity {

    Firebase objRef;
    private ArrayList<VacinasTomadas> vacinasTomadasArrayList;
    private VacinasTomadasAdapter vacinasTomadasAdapter;
    private Button btnCadastraUsuario;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_vacina);

        inicializacaoComponentes();
        readJson();
        onClicks();
    }

    private  void readJson(){
       vacinasTomadasArrayList = new ArrayList<>();
       Firebase.setAndroidContext(this);

       try {
            objRef = new Firebase("https://cartaovacina-123.firebaseio.com/users/" + ConexaoFirebase.getFirebaseAuth().getUid());

            objRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot d : dataSnapshot.getChildren()) {

                        String nome = d.child("nome").getValue().toString();
                        String dose = d.child("dose").getValue().toString();
                        String data = d.child("data").getValue().toString();
                        String uid = d.child("uid").getValue().toString();

                        VacinasTomadas vacinasTomadas = new VacinasTomadas(nome, dose, data,uid);
                        vacinasTomadasArrayList.add(vacinasTomadas);
                    }
                   getContexto();
                    listView.setAdapter(vacinasTomadasAdapter);
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {
                }
            });

        }catch (Exception e){
        }
    }

    private void getContexto (){
        vacinasTomadasAdapter= new VacinasTomadasAdapter(this,vacinasTomadasArrayList);
    }

    private void onClicks() {
        btnCadastraUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartaoVacinaActivity.this, AdicionarVacinaActivity.class);
                startActivity(i);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CartaoVacinaActivity.this, AlterarVacinaActivity.class);
                intent.putExtra("uid", vacinasTomadasArrayList.get(position).getUid());
                intent.putExtra("nome", vacinasTomadasArrayList.get(position).getNome());
                intent.putExtra("dose", vacinasTomadasArrayList.get(position).getDose());
                intent.putExtra("data", vacinasTomadasArrayList.get(position).getData());
                 startActivity(intent);
            }
        });
    }

    private void inicializacaoComponentes() {
        btnCadastraUsuario = (Button) findViewById(R.id.buttonNovoVacinasTomadas);
        listView = (ListView) findViewById(R.id.listviewVacinasTomadas);
    }
}
