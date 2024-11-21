package library;

public class User {
    private String nome, cognome, id;

    public User (String nome, String cognome, String id) {
        setNome(nome);
        setCognome(cognome);
        this.id = id;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }
}
