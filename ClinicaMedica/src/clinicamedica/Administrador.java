package clinicamedica;

public class Administrador extends Usuario {
    private String usuario, senha;
    
    public Administrador(){}
    public Administrador(String nome, String usuario, String cpf, char sexo, String dtNasc, String senha, String email) {
        super(nome, cpf, sexo, dtNasc, email);
        this.usuario = usuario;
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
}
