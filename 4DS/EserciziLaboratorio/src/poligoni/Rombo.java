package poligoni;

public class Rombo extends PoligonoRegolare{
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
    public float area(){
        return (dMin*dMag)/2;
    }
    public float apotema(){
        return (area()*2)/super.perimetro();
    }
    public float getDMin(){
        return dMin;
    }
    public float getDMag(){
        return dMag;
    }
}
