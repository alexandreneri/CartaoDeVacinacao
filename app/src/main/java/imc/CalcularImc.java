package imc;

public class CalcularImc {

    public  double realizaCalculo (Imc imc, ImcMetodo imcMetodo){
        double resultado = imcMetodo.calcula(imc);
        return resultado;
    }
}
