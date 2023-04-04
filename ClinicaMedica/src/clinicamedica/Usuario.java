package clinicamedica;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public abstract class Usuario implements Serializable {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private String nome, cpf, email;
    private char sexo;
    private Date dtNasc;
    
    protected Usuario(){}
    protected Usuario(String nome, String cpf, char sexo, String dtNasc, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
        
        try {
            this.dtNasc = sdf.parse(dtNasc);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    "A data não está no formato correto: dd/mm/aaaa",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtNasc() {
        return sdf.format(dtNasc);
    }

    public void setDtNasc(String dtNasc) {
        try {
            this.dtNasc = sdf.parse(dtNasc);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    "A data não está no formato correto: dd/mm/aaaa",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String info(){
        String sexo = switch (this.sexo) {
            case 'M' -> "Masculino";
            case 'F' -> "Feminino";
            default -> "Outro";
        };
        return "--> Usuário <--"
                + "\nNome: " + this.getNome()
                + "\nCPF: " + this.getCpf()
                + "\nSexo: " + sexo
                + "\nData de Nascimento: " + this.getDtNasc();
    }
}