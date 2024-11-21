package Lista;

import java.util.Comparator;

public class Persona implements Comparable<Persona> {
    private String nome;
    private String cognome;
    private Integer eta;

    public Persona(String n){
        setNome(n);
        setCognome("");
        setEta(0);
    }
    public Persona(String n, String c, Integer e){
        setNome(n);
        setCognome(c);
        setEta(e);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public int compareTo(Persona p){
        //return Integer.compare(this.eta, p.getEta());
        //return String.CASE_INSENSITIVE_ORDER.compare(this.nome, p.getNome());
        return String.CASE_INSENSITIVE_ORDER.compare(this.cognome, p.getCognome());
    }



    public String toString() {
        return "Nome: " + nome + "\nCognome: " + cognome + "\nEtà: " + eta;
    }
}
