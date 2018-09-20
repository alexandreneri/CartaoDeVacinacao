package modal;
/**
 * Created by alexa on 19/09/2017.
 */
public class Vacina {
    private int idade;
    private String vacina;
    private String doenca_protecao;
    private int dose;
    private String dose_qtd;
    private String via_administracao;

    public Vacina(int idade, String vacina, String doenca_protecao, int dose, String dose_qtd, String via_administracao) {
        this.idade = idade;
        this.vacina = vacina;
        this.doenca_protecao = doenca_protecao;
        this.dose = dose;
        this.dose_qtd = dose_qtd;
        this.via_administracao = via_administracao;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getVacina() {
        return vacina;
    }
    public void setVacina(String vacina) {
        this.vacina = vacina;
    }
    public String getDoenca_protecao() {
        return doenca_protecao;
    }
    public void setDoenca_protecao(String doenca_protecao) {
        this.doenca_protecao = doenca_protecao;
    }
    public int getDose() {
        return dose;
    }
    public void setDose(int dose) {
        this.dose = dose;
    }
    public String getDose_qtd() {
        return dose_qtd;
    }
    public void setDose_qtd(String dose_qtd) {
        this.dose_qtd = dose_qtd;
    }
    public String getVia_administracao() {
        return via_administracao;
    }
    public void setVia_administracao(String via_administracao) {
        this.via_administracao = via_administracao;
    }
}
