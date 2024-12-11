package puntoSegmento;

import java.util.Scanner;

public class TestSegmento {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Punto pA, pB;
        Segmento s1 = null;
        float x, y;
        boolean flag = false;
        do {
            System.out.println("Inserisci il 1° punto: ");
            System.out.println("X: ");
            x = input.nextFloat();
            System.out.println("Y: ");
            y = input.nextFloat();
            pA = new Punto(x, y);

            System.out.println("Inserisci il 2° punto: ");
            System.out.println("X: ");
            x = input.nextFloat();
            System.out.println("Y: ");
            y = input.nextFloat();
            pB = new Punto(x, y);
            try {
                s1 = new Segmento(pA, pB);
                flag = true;
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }while(!flag);

        System.out.println(s1.toString());
        System.out.println("Lunghezza: " + s1.calcolaLunghezza());
        System.out.println("Traslazione sugli assi cartesiani: ");
        System.out.println("X: ");
        x = input.nextFloat();
        System.out.println("Y: ");
        y = input.nextFloat();
        s1.traslaSegmento(x, y);
        System.out.println(s1.toString());
    }
}