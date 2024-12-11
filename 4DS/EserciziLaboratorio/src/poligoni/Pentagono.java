package poligoni;

public class Pentagono extends PoligonoRegolare{
    public Pentagono(float lLati)throws Exception{
        super(5,lLati);
    }
    public Pentagono(Pentagono p)throws Exception{
        super(5, p.getLLati());
    }
    public double area(){
        return Math.pow(super.getLLati(), 2) * 1.72;
    }
    public double diagonale(){
        return (super.getLLati()*(Math.sqrt(5) - 1))/2;
    }
    public double apotema(){
        return super.getLLati() * 0.688;
    }
}
