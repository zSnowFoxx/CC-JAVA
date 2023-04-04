package clinicamedica;

public class Agenda {
    private boolean[][] calendario = new boolean[5][16];

    public Agenda() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 16; j++) {
                calendario[i][j] = false;
            }
        }
    }
    
    public void addHorarioLivre(int dia, int horario) {
        calendario[dia][horario] = true;
    }
    
    public void addHorarioOcupado(int dia, int horario) {
        calendario[dia][horario] = false;
    }
    
}
