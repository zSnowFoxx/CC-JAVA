package clinicamedica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Clinica implements Serializable {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Agenda> agendas = new ArrayList<>();

    public Clinica() {
        if (administradores.isEmpty() && medicos.isEmpty()) {
            Administrador admPadrao = new Administrador("admin", "admin", "111.111.111-12",
                    '-', "01/01/2001", "admin", "email@example.com");
            this.administradores.add(admPadrao);
        }
    
    }
    
    public void addAdministrador(Administrador adm) {
        this.administradores.add(adm);
    }
    
    public void addPaciente(Paciente pac) {
        this.pacientes.add(pac);
    }
    
    public void addMedico(Medico med) {
        this.medicos.add(med);
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }
    
    public Administrador getAdmByUser(String user) {
        try {
            Administrador adm = null;
            for (int i = 0; i < administradores.size(); i++) {
                if (administradores.get(i).getUsuario().equals(user)) {
                    adm = administradores.get(i);
                    break;
                }
            }
            if (adm == null) { 
                throw new Exception(); 
            } else return adm;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    
    
    
}
