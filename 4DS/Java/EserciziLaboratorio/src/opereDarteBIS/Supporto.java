package opereDarteBIS;

public class Supporto {
    private double larghezza;
    private double altezza;
    private double spessore;

    public Supporto(double l, double a, double p)throws Exception{
        setLarghezza(l);
        setAltezza(a);
        setSpessore(p);
    }

    public Supporto(Supporto c1)throws Exception{
        setLarghezza(c1.getLarghezza());
        setAltezza(c1.getAltezza());
        setSpessore(c1.getProfondita());
    }

    private void setLarghezza(double larghezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }this.larghezza = larghezza;
    }

    private void setAltezza(double altezza) throws Exception{
        if(altezza <= 0){
            throw new Exception("Valore non valido!");
        }this.altezza = altezza;
    }

    private void setSpessore(double profondita) throws Exception{
        if(spessore <= 0){
            throw new Exception("Valore non valido!");
        }
        this.spessore = profondita;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getProfondita() {
        return spessore;
    }
}
