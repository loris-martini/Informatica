package Lista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer len = 10;
        ArrayList<Persona> rubrica = new ArrayList<>(len);

        Persona p1 = new Persona("laura", "ciao", 16);
        Persona p2 = new Persona("marco", "muraro", 32);
        Persona p3 = new Persona("bosco", "andrea", 45);

        rubrica.add(p3);
        rubrica.add(p2);
        rubrica.add(p1);

        for (Persona pp: rubrica) {
            System.out.println(pp.toString());
        }

        System.out.println("\n");

        Collections.sort(rubrica);

        for (Persona pp: rubrica) {
            System.out.println(pp.toString());
        }

    }
}
