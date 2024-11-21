package opereDarteBIS;

public class Cornice {
    private double larghezza;
    private double altezza;
    private double profondita;

    public Cornice(double l, double a, double p)throws Exception{
        setLarghezza(l);
        setAltezza(a);
        setProfondita(p);
    }

    public Cornice(Cornice c1)throws Exception{
        setLarghezza(c1.getLarghezza());
        setAltezza(c1.getAltezza());
        setProfondita(c1.getProfondita());
    }

    private void setLarghezza(double larghezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }this.larghezza = larghezza;
    }
    private void setAltezza(double altezza) throws Exception{
        if(altezza <= 0){
            throw new Exception("Valore non valido!");
        }this.altezza = altezza;}
    private void setProfondita(double profondita) throws Exception{
        if(profondita <= 0){
            throw new Exception("Valore non valido!");
        }
        this.profondita = profondita;
    }

    public double getLarghezza() {
        return larghezza;
    }
    public double getAltezza() {
        return altezza;
    }
    public double getProfondita() {
        return profondita;
    }
}
