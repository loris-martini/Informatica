package documentoCom;

public class DatiPrivato {
    //attributi
    private String nome;
    private String cognome;
    private String indirizzo;
    private String iban;

    //metodi
    public DatiPrivato(String nome, String cognome, String indirizzo, String iban){
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        this.iban=iban;
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public String getIban() {
        return iban;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String toString() {
        return "\nNome: " + nome + " " + cognome + "\nIndirizzo: " + indirizzo + "\nIban: " + iban;
    }
}
