package clinicamedica;

public class Medico extends Usuario {
    private int crm;
    private String especialidade;
    private Agenda agenda;
    
    public Medico(){}
    public Medico(String nome, int crm, String cpf, char sexo, String dtNasc, String especialidade, String email, Agenda agenda) {
        super(nome, cpf, sexo, dtNasc, email);
        this.crm = crm;
        this.especialidade = especialidade;
        this.agenda = agenda;
    }

    public int getCRM() {
        return crm;
    }

    public void setCRM(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    
    
    
}
