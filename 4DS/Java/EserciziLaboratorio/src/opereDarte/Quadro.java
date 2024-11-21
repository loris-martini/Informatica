package opereDarte;

public class Quadro extends OperaDarte{
    private float larghezza;
    private float altezza;

    public Quadro(String t, String a, float l, float al) throws Exception{
        super(t, a);
        setLarghezza(l);
        setAltezza(al);
    }

    public Quadro(Quadro s) throws Exception{
        super(s.getTitolo(), s.getArtista());
        setAltezza(s.getAltezza());
        setLarghezza(s.getLarghezza());
    }

    private void setLarghezza(float larghezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.larghezza = larghezza;
    }

    private void setAltezza(float altezza) throws Exception{
        if(larghezza <= 0){
            throw new Exception("Valore non valido!");
        }
        this.altezza = altezza;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public float getAltezza() {
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
