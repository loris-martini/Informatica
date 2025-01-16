package puntoSegmento;

import java.lang.Math;

public class Segmento {
    private Punto puntoA;
    private Punto puntoB;

    public Segmento(Punto p1, Punto p2) throws Exception{
        if(p1.getX() == p2.getX() && p1.getY()==p2.getY()){
           throw new Exception("Collisione!");
        }
        puntoA = new Punto(p1.getX(),p1.getY());
        puntoB = new Punto(p2.getX(),p2.getY());
    }

    private Punto Segmento(Punto p){
        Punto newP = new Punto(p.getX(),p.getY());
        return newP;
    }

    public void setPuntoA(Punto p){
        puntoA.setX(p.getX());
        puntoA.setY(p.getY());
    }
    public void setPuntoB(Punto p){
        puntoB.setX(p.getX());
        puntoB.setY(p.getY());
    }

    public Punto getPuntoA(){
        return Segmento(puntoA);
    }
    public Punto getPuntoB(){
        return Segmento(puntoB);
    }
    public float calcolaLunghezza(){
        return (float)Math.sqrt(Math.pow(puntoB.getX()-puntoA.getX(), 2) + Math.pow((puntoB.getY()-puntoA.getY()),2));
    }
    public void traslaSegmento(float deltaX, float deltaY){
        puntoA.traslaPunto(deltaX,deltaY);
        puntoB.traslaPunto(deltaX,deltaY);
    }

    public String toString(){
        return "[" + puntoA.toString() + ", " + puntoB.toString() + "]";
    }
}
