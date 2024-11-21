package poligoni;

public class Pentagono extends PoligonoRegolare{
    public Pentagono(float lLati)throws Exception{
        super(5,lLati);
    }
    public Pentagono(Pentagono p)throws Exception{
        super(5, p.getLLati());
    }
    public double area(){
        return Math.pow(getLLati(), 2) * 1.72;
    }
    public String disegna(char x){
        String str = "";
        return str;
    }
    public double diagonale(){
        return (getLLati()*(Math.sqrt(5) - 1))/2;
    }
    public double apotema(){
        return getLLati() * 0.688;
    }

    public String toString() {
        return "Pentagono{" + getLLati() + "}";
    }
}
