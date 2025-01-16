package poligoni;

public class Esagono extends PoligonoRegolare{
    public Esagono(float lLati)throws Exception{
        super(6, lLati);
    }
    public Esagono(Esagono e)throws Exception{
        super(6, e.getLLati());
    }
    public float diagonale(){
        return super.getLLati();
    }
    public double area(){
        return(super.perimetro()*apotema())/2;
    }
    public double apotema(){
        return 0.86*super.getLLati();
    }
}
