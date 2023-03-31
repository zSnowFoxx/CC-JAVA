package clinicamedica;

import java.io.Serializable;
import java.util.ArrayList;

public class Clinica implements Serializable {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Agenda> agendas = new ArrayList<>();

    public Clinica() {
        if (administradores.isEmpty() && medicos.isEmpty()) {
            
        }
    
    }
    
    
}
