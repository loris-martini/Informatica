package poligoni;

public abstract class PoligonoRegolare {
    private int nLati;
    private float lLati;
    public PoligonoRegolare(int nLati, float lLati) throws Exception{
        if(nLati <= 3){
            throw new Exception("Numero Lati errati!");
        }
        if(lLati <= 0){
            throw new Exception("Lunghezza Lati errati!");
        }
        this.nLati = nLati;
        this.lLati = lLati;
    }
    public int getNLati(){
        return nLati;
    }
    public float getLLati(){
        return lLati;
    }
    public float perimetro(){return nLati * lLati;}
    public abstract double area();

    public abstract String disegna(char x);

    public String toString(){
        return "Numero lati: " + nLati + " lunghi: " + lLati;
    }
}
