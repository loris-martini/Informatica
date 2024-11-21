package poligoni;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPoligoni {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GestionePoligoni g1 = null;
        int scelta = -1;
        int lun;
        int nL;
        float lL;
        float dMag;
        float dMIn;
        boolean flag = false;
/*
        do {
            System.out.println("Quanti Poligoni vuoi inserire? ");
            lun = input.nextInt();
            try{
                g1 = new GestionePoligoni(lun);
                flag = true;
            }catch (Exception e){
                System.out.println("Errore: " + e.getMessage());
            }
        }while(!flag);
 */
        Quadrato q1 = null;
        Rombo r1 = null;
        Esagono e1 = null;
        Pentagono p1 = null;
/*
        try {
            PoligonoRegolare pr1;

            penta1 = new Pentagono(20);

            //System.out.println("Area Poligono regolare " + pr1.area());
            System.out.println("Area Pentagono " + penta1.area());

            //System.out.println("Perimetro Poligono regolare " + pr1.perimetro());
            System.out.println("Perimetro Pentagono " + penta1.perimetro());

            //System.out.println("Poligono regolare " + pr1.toString());
            System.out.println("Pentagono " + penta1.toString());

            //penta1 = pr1; //Non puoi
            pr1 = penta1;

            System.out.println("Area Poligono regolare " + pr1.area());
            System.out.println("Poligono regolare " + pr1.toString());

            //System.out.println("Apotema Poligono regolare " + pr1.apotema()); //Non puoi


        }catch (Exception e){
            System.out.println("Errore");
        }

 */
        do {
            try {
                System.out.println("\n1) Quadrato \n2) Rombo \n3) Esagono \n4) Pentagono \n0)Esci");
                System.out.println("--> ");
                scelta = input.nextInt();
                switch (scelta) {
                    case 0: //Esci
                        System.out.println("Arrivederci!");
                        break;
                    case 1: //Quadrato
                        System.out.println("Lunghezza lati: ");
                        lL = input.nextFloat();

                        q1 = new Quadrato(lL);

                        System.out.println(q1.toString() + "\nArea: " + q1.area() + "\nPerimetro: " + q1.perimetro());
                        System.out.println(q1.disegna('x'));
                        break;
                    case 2: //Rombo
                        System.out.println("Lunghezza lati: ");
                        lL = input.nextFloat();
                        System.out.println("Lunghezza diagonale maggiore: ");
                        dMag = input.nextFloat();
                        System.out.println("Lunghezza diagonale minore: ");
                        dMIn = input.nextFloat();

                        r1 = new Rombo(lL, dMag, dMIn);

                        System.out.println(r1.toString() + "\nArea: " + r1.area() + "\nPerimetro: " + r1.perimetro());
                        System.out.println(r1.disegna('x'));
                        break;
                    case 3: // Esagono
                        System.out.println("Lunghezza lati: ");
                        lL = input.nextInt();

                        e1 = new Esagono(lL);

                        System.out.println(e1.toString() + "\nArea: " + e1.area() + "\nPerimetro: " + e1.perimetro());
                        break;
                    case 4: //Pentagono
                        System.out.println("Lunghezza lati: ");
                        lL = input.nextInt();

                        p1 = new Pentagono(lL);

                        System.out.println(p1.toString() + "\nArea: " + p1.area() + "\nPerimetro: " + p1.perimetro());
                        break;
                    default:
                        System.out.println("Scelta errata!");

                }
            }catch (Exception e){
                System.out.println("Errore: " + e.getMessage());
            }
        }while(scelta != 0);
    }
}