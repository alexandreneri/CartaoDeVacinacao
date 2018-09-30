package modal;

public class VacinasTomadas {

    private  String nome;
    private  String dose;
    private  String data;
    private  String uid;

    public VacinasTomadas(String nome, String dose, String data, String uid){
        this.nome = nome;
        this.dose = dose;
        this.data = data;
        this.uid = uid;

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getData() {
        return data;
    }    public void setData(String id) {
        this.data = data;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDose() {
        return dose;
    }
    public void setSexo(String dose) {
        this.dose = dose;
    }
}
