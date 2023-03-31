package clinicamedica;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Agenda {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date dia = new Date();
    private int crm;

    public Agenda(int crm) {
        this.crm = crm;
    }
    
    public void addHorarioLivre(String inicio, String fim) {
        
    }
    
}
