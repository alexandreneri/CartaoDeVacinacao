package Hospital;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.neri.alexa.cartaodevacinacao.R;

import java.util.ArrayList;

import adapter.HospitalAdapter;
import adapter.VacinaAdapter;
import modal.Hospital;
import modal.Vacina;

public class HospitalActivity extends AppCompatActivity {

    private ArrayList<Hospital> hospital;
    private HospitalAdapter adapter;
    Firebase objetoRef;
    private  ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        inicializarComponentes();
        readJson();
        onClick();
    }

    private void onClick() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HospitalActivity.this, DescicaoHospitalActivity.class);
                intent.putExtra("unidade",hospital.get(position).getUnidade());
                intent.putExtra("bairro", hospital.get(position).getBairro());
                intent.putExtra("fone",hospital.get(position).getFone());
                intent.putExtra("endereco",hospital.get(position).getEndereco());
                startActivity(intent);
            }
        });
    }

    private void inicializarComponentes() {
        lista = (ListView) findViewById(R.id.listviewHospital);
    }


    private  void readJson() {
        Firebase.setAndroidContext(this);
        objetoRef = new Firebase("https://cartaovacina-123.firebaseio.com/hospital");
        hospital = new ArrayList<Hospital>();

        objetoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot userVacina : dataSnapshot.getChildren()){

                    String unidade = userVacina.child("unidade").getValue().toString();
                    String endereco = userVacina.child("endereco").getValue().toString();
                    String fone = userVacina.child("fone").getValue().toString();
                    String bairro = userVacina.child("bairro").getValue().toString();

                    Hospital h= new Hospital(bairro,endereco,fone,unidade);
                    hospital.add(h);
                }
                setContexto();
                lista.setAdapter(adapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    private void setContexto(){ adapter= new HospitalAdapter(this, hospital);}

}
