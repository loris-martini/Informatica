package opereDarteBIS;

import opereDarte.OperaDarte;

public class Quadro extends OperaDarte {
    private double larghezza;
    private double altezza;
    private Cornice cornice;

    public Quadro(Cornice c, String t, String a, double l, double al) throws Exception{
        super(t, a);
        setCornice(c);
        setLarghezza(l);
        setAltezza(al);
    }

    public Quadro(opereDarte.Quadro s) throws Exception{
        super(s.getTitolo(), s.getArtista());
        setAltezza(s.getAltezza());
        setLarghezza(s.getLarghezza());
    }

    private void setCornice(Cornice c) throws Exception{
        cornice = new Cornice(c);
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

    public Cornice getCornice() throws Exception{return new Cornice(cornice);}

    public double getLarghezza() {
        return larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public double printIngombro(){
        return larghezza*altezza;
    }

    public String toString(){
        //return "Titolo: " + titolo + "\nArtista: " + artista + "Larghezza: " + larghezza + "Altezza: " + altezza;
        return super.toString() + "\nLarghezza: " + larghezza + "Altezza: " + altezza;
    }
}
