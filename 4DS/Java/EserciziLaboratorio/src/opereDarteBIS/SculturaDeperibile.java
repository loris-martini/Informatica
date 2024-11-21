package opereDarteBIS;

public class SculturaDeperibile extends Scultura{
    private double fact; // m^3/gg
    private int etaGG; //giorni

    public SculturaDeperibile(Supporto s, String t, String a,float l, float al, float p, double f, int e) throws Exception{
        super(s, t, a, l, al, p);
        setFact(f);
        setEta(e);
    }

    public SculturaDeperibile(SculturaDeperibile sd1) throws Exception {
        super(sd1. getSupporto(), sd1.getTitolo(), sd1.getArtista(), sd1.getLarghezza(), sd1.getAltezza(), sd1.getProfonfita());
        setFact(sd1.getFact());
        setEta(sd1.getEta());
    }

    private void setFact(double fact) throws Exception{
        if(fact <= 0){
            throw new Exception("Valore non valido!");
        }
        this.fact = fact;
    }

    private void setEta(int eta) throws Exception{
        if(eta <= 0){
            throw new Exception("Valore non valido!");
        }
        this.etaGG = eta;
    }

    public double getFact() {
        return fact;
    }

    public int getEta() {
        return etaGG;
    }

    public double printIngombro(){
        return super.printIngombro()-(etaGG*fact);
    }

    /*
    public String toString(){
        return
    }
     */
}
