package martini;

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
        Studente s =  (Studente) super.clone();
        return s;
    }

    public int hashCode() {
        return hashCode(0) + hashCode(1)+ hashCode(2) + hashCode(3) + hashCode(4);
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
        super.finalize();
    }
}
