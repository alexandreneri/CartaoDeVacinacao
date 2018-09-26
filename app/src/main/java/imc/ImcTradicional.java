package imc;

public class ImcTradicional implements  ImcMetodo {

   public double calcula(Imc imc) {
        return imc.getPeso() / Math.pow(imc.getAltura(),2);
    }
}
