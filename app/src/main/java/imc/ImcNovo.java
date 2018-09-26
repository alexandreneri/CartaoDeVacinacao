package imc;

public class ImcNovo implements ImcMetodo{
    @Override
    public double calcula(Imc imc) {
        return   imc.getPeso()/Math.pow( imc.getAltura(),2.5)*1.3;
    }
}
