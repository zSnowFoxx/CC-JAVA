package clinicamedica;

public class Administrador extends Usuario {

    public Administrador(String nome, String usuario, String cpf, char sexo, String dtNasc, String senha, String email) {
        super(nome, usuario, cpf, sexo, dtNasc, senha, email);
        this.setAdm(true);
    }
    
}
