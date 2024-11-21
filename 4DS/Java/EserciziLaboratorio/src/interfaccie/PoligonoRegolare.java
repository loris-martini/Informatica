package interfaccie;

public abstract class PoligonoRegolare implements Confrontabile {
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


    public Boolean confrontaMaggiore(Confrontabile obj)throws Exception{
        if(!(obj instanceof PoligonoRegolare)){
            throw new Exception("Oggetto non appartenente alla classe PoligonoRegolare!");
        }
        if(((PoligonoRegolare) obj).area() > area()){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean confrontaMinore(Confrontabile obj)throws Exception{
        if(!(obj instanceof PoligonoRegolare)){
            throw new Exception("Oggetto non appartenente alla classe PoligonoRegolare!");
        }
        if(((PoligonoRegolare) obj).area() < area()){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean confrontaUguale(Confrontabile obj)throws Exception{
        if(!(obj instanceof PoligonoRegolare)){
            throw new Exception("Oggetto non appartenente alla classe PoligonoRegolare!");
        }
        if(((PoligonoRegolare) obj).area() == area()){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "Numero lati: " + nLati + " lunghi: " + lLati;
    }
}
