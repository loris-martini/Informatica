package documentoCom;

public class Fattura extends DocumentoCommerciale {
    //attributi
    private DatiPrivato privato;

    //metodi
    public Fattura(Azienda a, Data d, DatiPrivato dat){
        super(a, d);
        this.totale=0;
        this.privato=dat;
    }

    public void setPrivato(DatiPrivato privato) {
        this.privato = privato;
    }
    public DatiPrivato getPrivato() {
        return privato;
    }

    public String print(){
        return super.toString() + "\nDATI PRIVATO: " + privato.toString();
    }

}
