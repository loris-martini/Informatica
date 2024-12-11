package cerchio;
import puntoSegmento.Punto;

import java.util.concurrent.ExecutionException;

public class Cerchio {
    private Punto centro;
    private float raggio;
    final double pi = 3.1415;

    public Cerchio(Punto c, float r) throws Exception {
        if(r <= 0){
           throw new Exception("Cerchio inesistente!");
        }
        centro = new Punto(c.getX(), c.getY());
        raggio = r;
    }
    private Punto Cerchio(Punto p){
        Punto newP = new Punto(p.getX(),p.getY());
        return newP;
    }

    public Punto getCentro(){
        return Cerchio(centro);
    }

    public float getRaggio(){
        return raggio;
    }

    public void setCentro(Punto c){
        centro.setX(c.getX());
        centro.setY(c.getY());
    }

    public void setRaggio(float r){
        raggio = r;
    }

    public double area(){
        return ((raggio*raggio)*pi);
    }

    public double circonferenza(){
        return (2*pi)*raggio;
    }

    public void ridimensiona(float aum) throws Exception{
        if(aum < 0){
            throw new Exception("Ridimensione invalida!");
        }
        raggio = raggio*(1 + aum);
    }

    public void trasla(float deltaX, float deltaY){
        centro.traslaPunto(deltaX, deltaY);
    }

    public String toString(){
        return "Centro: " + centro.toString() + "\nRaggio: " + raggio;
    }
}
