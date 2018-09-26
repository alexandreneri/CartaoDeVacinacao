package imc;

import android.provider.ContactsContract;

public class Imc {
    private double altura;
    private double peso;
    private  double resultado;

    public Imc(double altura, double peso){
        this.altura = altura;
        this.peso = peso;


    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {

        return altura;
    }
}
