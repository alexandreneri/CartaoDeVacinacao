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






  public  void  atualizar (Context context, String nome, String dose , String data, String uidVacina){


  }

  public  void  deletar (Context context, String uidVacina){








    }




}
