package tipiGenerici.Box;

public class Box <T> {
    private T t;

    public Box() {

    }

    public Box(T t) {
        this.t = t;
    }

    public T get(){
        return t;
    };

    public void set(T t){
        this.t = t;
    };

    public Class tipo(){
        return t.getClass();
    }

    static public <T> T verificaTipo(T valore){

        return (T)valore.getClass();
    }

    public String toString(){
        return t.toString();
    }
}