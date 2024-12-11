package punto;

public class PuntoColorato extends Punto{
    private String colore;

    public PuntoColorato(float x, float y, String colore){
        super(x,y);
        this.colore = colore;
    }

    public PuntoColorato(PuntoColorato p){
        super(p.getX(),p.getY());
        this.colore = p.colore;
    }

    public String getColore(){
        return colore;
    }

    public void setColore(String colore){
        this.colore = colore;
    }

    public String toString(){
        return super.toString() + " è di colore: " + colore;
    }
}
