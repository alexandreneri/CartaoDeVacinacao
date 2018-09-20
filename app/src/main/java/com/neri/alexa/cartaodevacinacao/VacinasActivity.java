package com.neri.alexa.cartaodevacinacao;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import adapter.VacinaAdapter;
import modal.Vacina;


public class VacinasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);

     //   Type vacinaType = new TypeToken<ArrayList<Vacina>>(){}.getType();
     //   ArrayList<Vacina> vacina = gson.fromJson(bufferedReader,vacinaType);

        ArrayList<Vacina> vacina = new ArrayList<Vacina>();
          vacina.add(parserGson(readJson()));
            ListView lista = (ListView) findViewById(R.id.listviewVacina);
            ArrayAdapter adapter = new VacinaAdapter(this, vacina);
            lista.setAdapter(adapter);
    }

    private String readJson() {

        StringBuffer builder = new StringBuffer();
        try {
            InputStream is = getAssets().open("vacina.json");
            while (true) {
                int ch = is.read();
                if (ch== -1) break;
                else builder.append((char)ch);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private Vacina parserGson (String json){
        Gson gson = new Gson();
        Vacina vacina = gson.fromJson(json,Vacina.class);

        return  vacina;
    }


}
