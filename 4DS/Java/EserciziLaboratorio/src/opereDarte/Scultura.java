package opereDarte;

public class Scultura extends OperaDarte{
    private float larghezza;
    private float altezza;
    private float profondita;

    public Scultura(String t, String a,float l, float al, float p)throws Exception{
        super(t, a);
        setLarghezza(l);
        setAltezza(al);
        setProfonfita(p);
    }

    public Scultura(Scultura s)throws Exception{
        super(s.getTitolo(), s.getArtista());
        setAltezza(s.getAltezza());
        setLarghezza(s.getLarghezza());
        setProfonfita(s.getProfonfita());
    }

    public void setLarghezza(float larghezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.larghezza = larghezza;
    }

    public void setAltezza(float altezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.altezza = altezza;
    }

    public void setProfonfita(float profonfita) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.profondita = profonfita;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public float getAltezza() {
        return altezza;
    }

    public float getProfonfita() {
        return profondita;
    }

    public double printIngombro(){
        return larghezza*altezza*profondita;
    }

    public String toString(){
        //return "Titolo: " + titolo + "\nArtista: " + artista + "Larghezza: " + larghezza + "Altezza: " + altezza + "Profondità :" + profondita;
        return super.toString() + "\nLarghezza: " + larghezza + "Altezza: " + altezza + "Profondità :" + profondita;
    }
}
