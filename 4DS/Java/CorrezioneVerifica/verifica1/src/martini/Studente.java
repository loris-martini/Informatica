package martini;

import java.util.Objects;

public class Studente extends Persona implements Cloneable{
    public Studente(String cognome, String nome, String codFisc, String data, String email) throws Exception {
        super(cognome, nome, codFisc, data, email);
        numeroIstanze++;
    }

    public Studente(Persona persona) throws Exception {
        super(persona);
        numeroIstanze++;
    }

    protected Studente clone() throws CloneNotSupportedException{
        numeroIstanze++;
        return (Studente) super.clone();
    }

    public int hashCode() {
        return Objects.hashCode(getCognome()) + Objects.hashCode(getNome()) + Objects.hashCode(getCodFisc()) + Objects.hashCode(getDataDiNascita()) + Objects.hashCode(getEmail());
    }

    public boolean equals(Object o){
        if(!(o instanceof Studente)){
            return false;
        }
        if(((Studente) o).getNome() == getNome() && ((Studente) o).getCognome() == getCognome() && ((Studente) o).getCodFisc() == getCodFisc() && ((Studente) o).getDataDiNascita() == getDataDiNascita() && ((Studente) o).getEmail() == getEmail()){
            return true;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try{
            numeroIstanze--;
        }finally {
            super.finalize();
        }
    }
}
