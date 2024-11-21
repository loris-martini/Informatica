package Lista;

import java.util.ArrayList;

public class Lista<T> {
    private ArrayList<T> lista;

    public Lista(Integer len){
        lista = new ArrayList<>(len);
    }

    public void add(T s){
        lista.add(s);
    }

    public void remove(int i){
        lista.remove(i);
    }

    public void remove(T content){
        lista.remove(content);
    }

    public int size(){
        return lista.size();
    }

    public boolean contains(T content){
        return lista.contains(content);
    }

    public int indexOf(T content){
        return lista.indexOf(content);
    }

    public boolean isEmpty(){
        return lista.isEmpty();
    }

    public String toString(){
        return lista.toString();
    }

    public void trimToSize(){
        lista.trimToSize();
    }

    public void sort(){

    }



}
