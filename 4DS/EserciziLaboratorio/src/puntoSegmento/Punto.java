package puntoSegmento;

public class Punto {
    private float x;
    private float y;

    public Punto(float newX, float newY){
        x = newX;
        y = newY;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public String toString(){
        return "(" + x + "; " + y + ")";
    }

    public void traslaPunto(float deltaX, float deltaY){
        x += deltaX;
        y += deltaY;
    }
}
