package imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

public class ImcActivity extends AppCompatActivity {

    EditText editTextAltura;
    EditText editTextPeso;
    TextView textViewResultado;
    Button btnNovoImc;
    Button btnTradicionalImc;

    ImcFachada imcFachada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        inicializacaoComponentes();
        imcFachada = new ImcFachada();
        imcFachada.inicializarComponentes();

        onClick();

    }

    private void onClick() {

        btnTradicionalImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = String.valueOf( imcFachada.calcularImcNovo(pegaValoreseRetornaImc()));
                textViewResultado.setText(resultado);
            }
        });


        btnNovoImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String resultado = String.valueOf(imcFachada.calcularImcTradicional(pegaValoreseRetornaImc()));
                textViewResultado.setText(resultado);
            }
        });
    }

    private Imc pegaValoreseRetornaImc(){

        double altura = Double.parseDouble(editTextAltura.getText().toString());
        double peso =  Double.parseDouble(editTextPeso.getText().toString());

        Imc imc = new Imc(altura,peso);




        return  imc;
    }


    private void inicializacaoComponentes(){
        editTextAltura = (EditText) findViewById(R.id.editTextAltura);
        editTextPeso = (EditText) findViewById(R.id.editTextPeso);
        textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        btnNovoImc = (Button) findViewById(R.id.buttonNovoImc);
        btnTradicionalImc = (Button) findViewById(R.id.buttonTradicionalImc);
    }
}
