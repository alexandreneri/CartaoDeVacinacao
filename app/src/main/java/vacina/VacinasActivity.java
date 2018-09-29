package vacina;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import adapter.VacinaAdapter;
import modal.Vacina;
import com.firebase.client.Firebase;
import com.neri.alexa.cartaodevacinacao.R;


public class VacinasActivity extends AppCompatActivity {
    Firebase objetoRef;
    ArrayList<Vacina> vacinaList;
    ListView lista;
    private ArrayAdapter adapter;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);

        inicializarComponentes();
        readJson();
        onClick();
    }

    private void onClick() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), vacinaList.get(position).getDose(),Toast.LENGTH_SHORT).show();

                Intent i = new Intent(VacinasActivity.this, Descricao_Vacina_Activity.class);
                i.putExtra("vacina", vacinaList.get(position).getVacina());
                i.putExtra("idade", vacinaList.get(position).getIdade());
                i.putExtra("dose", vacinaList.get(position).getDose());
                i.putExtra("quantidade",vacinaList.get(position).getDose_qtd());
                i.putExtra("doenca",vacinaList.get(position).getDoenca_protecao());
                i.putExtra("via",vacinaList.get(position).getVia_administracao());
                startActivity(i);
            }
        });
    }

    private void inicializarComponentes() {
        lista = (ListView) findViewById(R.id.listviewVacina);
    }

    private  void readJson() {

        Firebase.setAndroidContext(this);
        objetoRef = new Firebase("https://cartaovacina-123.firebaseio.com/vacinas");
        vacinaList = new ArrayList<>();

        objetoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot userVacina : dataSnapshot.getChildren()){

                    String idade = userVacina.child("idade").getValue().toString();
                    String vacina = userVacina.child("vacina").getValue().toString();
                    String dose = userVacina.child("dose").getValue().toString();
                    String qtdDose = userVacina.child("dose_qtd").getValue().toString();
                    String via = userVacina.child("via_administracao").getValue().toString();
                    String doenca = userVacina.child("doenca_protecao").getValue().toString();
                    Vacina va = new Vacina(idade,vacina,doenca,dose,qtdDose,via);
                    vacinaList.add(va);
                }
                setContexto();
                lista.setAdapter(adapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
    private void setContexto(){
        adapter = new VacinaAdapter(this, vacinaList);
    }
}
