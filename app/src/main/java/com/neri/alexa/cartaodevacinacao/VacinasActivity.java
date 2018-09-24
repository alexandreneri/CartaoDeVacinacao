package com.neri.alexa.cartaodevacinacao;


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

import java.sql.Time;
import java.util.ArrayList;

import adapter.VacinaAdapter;
import modal.Vacina;
import com.firebase.client.Firebase;


public class VacinasActivity extends AppCompatActivity {
    Firebase objetoRef;
    ArrayList<Vacina> vacinatest;
    ArrayList<String> test = new ArrayList<>();
    ListView lista;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);


        readJson();
        lista.setAdapter(adapter);
        lista.deferNotifyDataSetChanged();



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), vacinatest.get(position).getDose(),Toast.LENGTH_SHORT).show();

                Intent i = new Intent(VacinasActivity.this, Descricao_Vacina_Activity.class);
                i.putExtra("vacina", vacinatest.get(position).getVacina());
                i.putExtra("idade", vacinatest.get(position).getIdade());
                i.putExtra("dose", vacinatest.get(position).getDose());
                i.putExtra("quantidade",vacinatest.get(position).getDose_qtd());
                i.putExtra("doenca",vacinatest.get(position).getDoenca_protecao());
                i.putExtra("via",vacinatest.get(position).getVia_administracao());


                startActivity(i);
            }
        });









/*


            novaRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                  String msg  = dataSnapshot.getValue(String.class);

                    //test.add(msg);

                   // Map<String,String> mapa = dataSnapshot.getValue(Map.class);
                    //     String idade = mapa.get("idade");
                    // String dose = mapa.get("dose");


                    test.add(msg);

                 //   vacina.add(v);

                    lista.deferNotifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

*/
    }

    private  void readJson() {

        Firebase.setAndroidContext(this);
        objetoRef = new Firebase("https://cartaovacina-123.firebaseio.com/");
        vacinatest = new ArrayList<Vacina>();

        lista = (ListView) findViewById(R.id.listviewVacina);

        adapter = new VacinaAdapter(this, vacinatest);




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
                    vacinatest.add(va);


                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });







    }


}
