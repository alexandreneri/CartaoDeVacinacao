package modal;

public class Hospital {
     private  String bairro;
     private  String endereco;
     private  String fone;
     private  String unidade;

    public Hospital(String bairro, String endereco, String fone, String unidade) {
        this.bairro = bairro;
        this.endereco = endereco;
        this.fone = fone;
        this.unidade = unidade;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
