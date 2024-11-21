package tipiGenerici.Box;

public class Persona {
    public String cognome;
    public String nome;

    public Persona(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        String info;

        info = "Cognome: " + this.cognome + "\n"
                + "Nome   : " + this.nome    + "\n";

        return info;
    }
}
