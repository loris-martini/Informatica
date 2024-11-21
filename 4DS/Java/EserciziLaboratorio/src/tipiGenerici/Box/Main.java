package tipiGenerici.Box;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
      /*Box<Integer> b1 = new Box<>(10);
      Box<Double>  b2 = new Box<>(5.50);
      Box<String>  b3 = new Box<>("testo");
      Box<Boolean> b4 = new Box<>(true);

      Persona p = new Persona("cognome", "nome");
      Box<Persona> b5 = new Box<>(p);

      System.out.println(b1.toString());
      System.out.println(b1.tipo());

      System.out.println(b2);
      System.out.println(b2.tipo());

      System.out.println(b3);
      System.out.println(b3.tipo());

      System.out.println(b4);
      System.out.println(b4.tipo());

      System.out.print(b5);
      System.out.println(b5.tipo());

      System.out.println(Box.verificaTipo(b5));*/

        Integer n = 10;

        Integer[] elementoInt = new Integer[]{10, 20, 30};

        try{
            System.out.println(Stampa.stampaElemento(n));

            System.out.println(Stampa.stampaElemento(elementoInt));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}