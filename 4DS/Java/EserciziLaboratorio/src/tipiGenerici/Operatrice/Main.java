package tipiGenerici.Operatrice;

import tipiGenerici.Box.Persona;

public class Main {
    public static void main(String[] args) {
        try {
            Operatrice o = new Operatrice<Integer>(10,5);
            System.out.println(o.somma());
            System.out.println("\n" + o.sottrazione());
            System.out.println("\n" + o.moltiplicazione());
            System.out.println("\n" + o.divisione());
            System.out.println("\n" + o.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
