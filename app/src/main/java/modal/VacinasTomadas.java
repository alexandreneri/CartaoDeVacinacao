package modal;

public class VacinasTomadas {

    private  String nome;
    private  String sexo;
    private  String data;
    private  String uidVacina;
    private  String uidUsuario;

    public VacinasTomadas(String uidVacina, String uidUsuario) {
        this.uidVacina = uidVacina;
        this.uidUsuario = uidUsuario;
    }

    public String getUidVacina() {
        return uidVacina;
    }

    public void setUidVacina(String uidVacina) {
        this.uidVacina = uidVacina;
    }

    public String getUidUsuario() {
        return uidUsuario;
    }

    public void setUidUsuario(String uidUsuario) {
        this.uidUsuario = uidUsuario;
    }

    public VacinasTomadas(String nome, String sexo, String data){
        this.nome = nome;
        this.sexo = sexo;
        this.data = data;

    }

    public String getData() {
        return data;
    }

    public void setData(String id) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
