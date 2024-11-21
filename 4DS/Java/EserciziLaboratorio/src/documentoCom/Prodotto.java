package documentoCom;

public class Prodotto {
    //attributi
    String nome;
    float prezzo;
    int ivaperc;

    //metodi
    public Prodotto(String nome, float prezzo, int ivaperc){
        this.nome=nome;
        this.prezzo=prezzo;
        this.ivaperc=ivaperc;
    }

    public String getNome() {
        return nome;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public int getIvaperc() {
        return ivaperc;
    }

    public String toString() {
        return nome+" [prezzo: "+prezzo+" iva: "+ivaperc+"]";
    }
}
