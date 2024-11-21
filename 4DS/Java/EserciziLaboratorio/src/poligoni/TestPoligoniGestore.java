package poligoni;

import java.util.Scanner;

public class TestPoligoniGestore {
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

        Quadrato q1 = null;
        Rombo r1 = null;
        Esagono e1 = null;
        Pentagono p1 = null;

        do {
            try {
                System.out.println("\n1) Inserisci \n2) Elimina \n3) Visulizza \n4) Lato più lungo  \n0)Esci");
                System.out.println("--> ");
                scelta = input.nextInt();
                switch (scelta) {
                    case 0: //Esci
                        System.out.println("Arrivederci!");
                        break;
                    case 1:
                        int s = -1;
                        System.out.println("\n1) Quadrato \n2) Rombo \n3) Esagono \n4) Pentagono \n0)Esci");
                        System.out.println("--> ");
                        s = input.nextInt();
                        switch (s) {
                            case 0: //Esci
                                System.out.println("Uscito dall'inserimento!");
                                break;
                            case 1: //Quadrato
                                System.out.println("Lunghezza lati: ");
                                lL = input.nextFloat();
                                g1.inserisciPoligono(new Quadrato(lL));
                                break;
                            case 2: //Rombo
                                System.out.println("Lunghezza lati: ");
                                lL = input.nextFloat();
                                System.out.println("Lunghezza diagonale maggiore: ");
                                dMag = input.nextFloat();
                                System.out.println("Lunghezza diagonale minore: ");
                                dMIn = input.nextFloat();
                                g1.inserisciPoligono(new Rombo(lL, dMag, dMIn));
                                break;
                            case 3: // Esagono
                                System.out.println("Lunghezza lati: ");
                                lL = input.nextInt();
                                g1.inserisciPoligono(new Esagono(lL));
                                break;
                            case 4: //Pentagono
                                System.out.println("Lunghezza lati: ");
                                lL = input.nextInt();
                                g1.inserisciPoligono(new Pentagono(lL));
                                break;
                            default:
                                System.out.println("Scelta errata!");

                        }
                        break;
                    case 2:
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
