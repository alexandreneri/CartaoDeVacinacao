package imc;

import android.provider.ContactsContract;

public class Imc {
    private double altura;
    private double peso;


    public Imc(double altura, double peso){
        this.altura = altura;
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
    public double getAltura() {
        return altura;
    }
}
