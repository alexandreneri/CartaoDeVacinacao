package imc;

import android.provider.ContactsContract;

public class ImcFachada {
     protected ImcMetodo imcNovo;
     protected ImcMetodo imcTradicional;
     protected CalcularImc calcularImc;

     public  void inicializarComponentes(){

         imcNovo = new ImcNovo();
         imcTradicional = new ImcTradicional();
         calcularImc = new CalcularImc();

     }

     public double calcularImcNovo (Imc imc){
       return calcularImc.realizaCalculo(imc , imcNovo);

     }

     public double calcularImcTradicional (Imc imc){
         return calcularImc.realizaCalculo(imc ,  imcTradicional);
     }

}
