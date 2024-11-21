package documentoCom;

public class Scontrino extends DocumentoCommerciale{
    //attributi
    private float contanti;

    //metodi
    public Scontrino(Azienda a, Data d, float contanti){
        super(a, d);
        this.totale=0;
        this.contanti=contanti;
    }

    public float getContanti() {
        return contanti;
    }
    public void setContanti(float contanti) {
        this.contanti = contanti;
    }
    public double calcResto(){
        return contanti-totale;
    }

    public String print() {
        return super.toString() + "\nImporto pagato: " + contanti + "\nResto: " + calcResto();
    }
}
