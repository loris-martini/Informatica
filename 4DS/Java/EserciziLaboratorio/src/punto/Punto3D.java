package punto;

public class Punto3D extends Punto{
    private float z;

    public Punto3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public Punto3D(Punto3D p){
        super(p.getX(),p.getY());
        z = p.z;
    }

    public float getZ(){
        return z;
    }

    public void setZ(float z){
        this.z = z;
    }

    public void shift(float dX, float dY, float dZ){
        z += dZ;
        super.shift(dX,dY);
    }

    public String toString(){
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}
