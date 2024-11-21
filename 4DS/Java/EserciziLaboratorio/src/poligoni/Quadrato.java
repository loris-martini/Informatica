package poligoni;

public class Quadrato extends PoligonoRegolare{
    public Quadrato(float lLati) throws Exception{
        super(4,lLati);
    }
    public Quadrato(Quadrato q)throws Exception{
        super(4,q.getLLati());
    }
    public double area(){
        return getLLati()*getLLati();
    }
    public String disegna(char carattere){
        String stampa = "";
        float lato = getLLati();
        for(int i = 0; i < lato; i++){
            if(i == 0||i == lato - 1){
                for(int j = 0; j < lato; j++){
                    stampa += carattere + " ";
                }
                stampa += "\n";
            }
            else{
                stampa += carattere + " ";
                for(int r = 0; r < lato - 2; r++){
                    stampa += "  ";
                }
                stampa += carattere + "\n";
            }
        }
        return stampa;

    }
    public double diagonale(){
        return Math.sqrt(getLLati());
    }
    public float apotema(){
        return getLLati()/2;
    }
}
