package interfaccie;

public class Rombo extends PoligonoRegolare {
    private float dMin;
    private float dMag;
    public Rombo(float lLati, float dMag, float dMin)throws Exception{
        super(4,lLati);
        if(dMag <= 0 || dMin <= 0){
            throw new Exception("Diagonali errate!");
        }
        this.dMag = dMag;
        this.dMin = dMin;
    }
    public Rombo(Rombo r)throws Exception{
        super(4,r.getLLati());
        this.dMag = r.dMag;
        this.dMin = r.dMin;
    }
    public double area(){
        return (dMin*dMag)/2;
    }
    public String disegna(char carattere){
        String stampa = "";
        for (int i = 0; i < dMin; i++) {
            for (int j = 0; j < dMag; j++) {
                if (i + j == (int)dMag/2 || i - j == (int)dMag/2 || j - i == (int)dMag/2 ||

                        i + j == dMag + (int)(dMag/3)) {

                    stampa += carattere;
                } else {
                    stampa += " ";
                }
            }
            stampa += "\n";
        }
        return stampa;
    }
    public double apotema(){
        return (area()*2)/super.perimetro();
    }
    public float getDMin(){
        return dMin;
    }
    public float getDMag(){
        return dMag;
    }
}
