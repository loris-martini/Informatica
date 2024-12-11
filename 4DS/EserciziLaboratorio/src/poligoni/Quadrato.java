package poligoni;

public class Quadrato extends PoligonoRegolare{
    public Quadrato(float lLati) throws Exception{
        super(4,lLati);
    }
    public Quadrato(Quadrato q)throws Exception{
        super(4,q.getLLati());
    }
    public float area(){
        return super.getLLati()*super.getLLati();
    }
    public double diagonale(){
        return Math.sqrt(super.getLLati());
    }
    public float apotema(){
        return super.getLLati()/2;
    }
}
