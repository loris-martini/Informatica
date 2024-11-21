package opereDarteBIS;

public class Scultura extends OperaDarte {
    private double larghezza;
    private double altezza;
    private double profondita;
    private Supporto supporto;

    public Scultura(Supporto s, String t, String a, double l, double al, double p)throws Exception{
        super(t, a);
        setSupporto(s);
        setLarghezza(l);
        setAltezza(al);
        setProfonfita(p);
    }

    public Scultura(Scultura s)throws Exception{
        super(s.getTitolo(), s.getArtista());
        setSupporto(s.getSupporto());
        setAltezza(s.getAltezza());
        setLarghezza(s.getLarghezza());
        setProfonfita(s.getProfonfita());
    }

    private void setSupporto(Supporto s) throws Exception{
        if(s == null){
            throw new Exception("Supporto vuoto!");
        }
        supporto = new Supporto(s);
    }
    private void setLarghezza(double larghezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.larghezza = larghezza;
    }

    private void setAltezza(double altezza) throws Exception{
        if(altezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.altezza = altezza;
    }

    private void setProfonfita(double profonfita) throws Exception{
        if(profonfita <= 0){
            throw new Exception("Valore non valido!");
        }
        this.profondita = profonfita;
    }

    public Supporto getSupporto()throws Exception{
        Supporto s1 = new Supporto(supporto);
        return s1;
    }
    public double getLarghezza() {
        return larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getProfonfita() {
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