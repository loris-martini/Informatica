package classe;

import java.util.Arrays;

public class Classe {
    private Studente[] studenti;
    private Studente capoClasse;
    private int dimLog;
    private final int maxStudenti = 24;

    public Classe(){
        dimLog = 0;
    }

    public Studente[] getStudenti() {
        return studenti;
    }

    public Studente getCapoClasse() {
        return capoClasse;
    }

    public void aggiungi(String nome, String cognome) throws Exception{
        if(dimLog <= maxStudenti){
            studenti[dimLog] = new Studente(nome, cognome);
            dimLog++;
        }
        throw new Exception("Classe piena!");
    }

    public void nominaCapoClasse(String nome, String cognome) {
        int i = 0;
        boolean flag = true;
        while (i < dimLog && flag) {
            if(nome.equals(studenti[i].getNome()) && cognome.equals(studenti[i].getCognome())){
                flag = false;
            }
            i++;
        }
        capoClasse = studenti[i-1];
    }

    public void invertiAttributi() throws Exception{
        String tmp;
        for (int i = 0; i < (studenti.length) - 1; i++) {
            tmp = studenti[i].getNome();
            studenti[i].setNome(studenti[i].getCognome());
            studenti[i].setCognome(tmp);
        }
    }

    public String toString() {
        return "Studenti: " + Arrays.toString(studenti) + "\nCapoclasse: " + capoClasse;
    }
}
