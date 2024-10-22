
public class Persona {
    private String nome;
    private int eta;
    private String citta;
    private String numero;

    public Persona(String nome, int eta, String citta, String numero) throws Exception{
        if(eta <= 0){
            throw new Exception("Età non valida! ");
        }

        this.nome = nome;
        this.eta = eta;
        this.citta = citta;
        this.numero = numero;
    }

    //Getter

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public String getCitta() {
        return citta;
    }

    public String getNumero() {
        return numero;
    }

    //Setter

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
