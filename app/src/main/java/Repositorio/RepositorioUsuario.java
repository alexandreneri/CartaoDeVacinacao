package Repositorio;

import android.content.Context;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.neri.alexa.cartaodevacinacao.login.ConexaoFirebase;

import java.util.ArrayList;
import java.util.UUID;

import modal.Hospital;

import modal.VacinasTomadas;

public class RepositorioUsuario {

    private FirebaseAuth firebaseAuth;

    Firebase objRef;
    private ConexaoFirebase fire;

    public RepositorioUsuario(){



    }


    public void cadastroUser(String nome, String sexo, String data){
        String uidVacina  = (UUID.randomUUID().toString());
       VacinasTomadas u = new VacinasTomadas(nome,sexo,data);
       u.setUidVacina(uidVacina);

        objRef= new Firebase("https://cartaovacina-123.firebaseio.com/users");
        firebaseAuth = ConexaoFirebase.getFirebaseAuth();
        Firebase nRef = objRef.child(firebaseAuth.getUid()).child(uidVacina);
        nRef.setValue(u);
    }

    public ArrayList<VacinasTomadas> readJson (Context context){


        final ArrayList<VacinasTomadas> userAraayList = new ArrayList<>();

        Firebase.setAndroidContext(context);

        try {

            objRef = new Firebase("https://cartaovacina-123.firebaseio.com/users/" + ConexaoFirebase.getFirebaseAuth().getUid());


            objRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot d : dataSnapshot.getChildren()) {

                        String nome = d.child("nome").getValue().toString();
                        String sexo = d.child("sexo").getValue().toString();
                        String data = d.child("data").getValue().toString();
                        String ui = d.child("uidVacina").getValue().toString();



                        VacinasTomadas user = new VacinasTomadas(nome, sexo, data);
                        user.setUidVacina(ui);
                        userAraayList.add(user);


                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

        }catch (Exception e){

        }

        return  userAraayList;
  }


  public  void  atualizar (Context context, String nome, String dose , String data, String uidVacina){

        VacinasTomadas u = new VacinasTomadas(nome,dose,data);
        u.setUidVacina(uidVacina);

         Firebase.setAndroidContext(context);
         objRef = new Firebase ("https://cartaovacina-123.firebaseio.com/users/" + ConexaoFirebase.getFirebaseAuth().getUid());



         objRef.child(uidVacina).setValue(u);
  }

  public  void  deletar (Context context, String uidVacina){
      Firebase.setAndroidContext(context);
      objRef = new Firebase ("https://cartaovacina-123.firebaseio.com/users/" + ConexaoFirebase.getFirebaseAuth().getUid());

      objRef.child(uidVacina).removeValue();







    }




}
