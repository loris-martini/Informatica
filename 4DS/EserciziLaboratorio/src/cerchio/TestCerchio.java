package cerchio;

import puntoSegmento.Punto;
import puntoSegmento.Segmento;

import java.util.Scanner;

public class TestCerchio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Punto p1;
        Cerchio c1 = null;
        float x, y, r;
        boolean flag = false;
        do {
            System.out.println("Inserisci il dentro del cerchio: ");
            System.out.println("X: ");
            x = input.nextFloat();
            System.out.println("Y: ");
            y = input.nextFloat();
            p1 = new Punto(x, y);

            System.out.println("Inserisci il raggio del cerchio: ");
            r = input.nextFloat();

            try {
                c1 = new Cerchio(p1, r);
                flag = true;
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }while(!flag);

        System.out.println(c1.toString());

        System.out.println("Circonferenza: " + c1.circonferenza());

        System.out.println("Area: " + c1.area());
        flag = false;
        do {
            try {
                System.out.println("Ridimensiona: ");
                x  = input.nextFloat();
                c1.ridimensiona(x);
                flag = true;
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }while(flag);
        System.out.println(c1.toString());

        System.out.println("Traslazione sugli assi cartesiani: ");
        System.out.println("X: ");
        x = input.nextFloat();
        System.out.println("Y: ");
        y = input.nextFloat();
        c1.trasla(x, y);

        System.out.println(c1.toString());

        System.out.println("Circonferenza: " + c1.circonferenza());

        System.out.println("Area: " + c1.area());
    }
}
