package poligoni;

public class PoligonoRegolare {
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
    public void setNLati(int nLati){
        this.nLati = nLati;
    }
    public float getLLati(){
        return lLati;
    }
    public void setLLati(float lLati){
        this.lLati = lLati;
    }
    public float perimetro(){
        return nLati * lLati;
    }

    public String toString(){
        return "Numero lati: " + nLati + " lunghi: " + lLati;
    }
}
