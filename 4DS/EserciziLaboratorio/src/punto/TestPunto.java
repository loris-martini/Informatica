package punto;

import java.util.Scanner;
import java.lang.Exception;

public class TestPunto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int scelta = -1;
        float x, y, z;
        String color;
        boolean flag;

        do {
            System.out.println("1) Crea un Punto \n2) Crea un Punto Colorato \n3) Crea un Punto 3D \n0) Esci");
            try {
                scelta = input.nextInt();
                switch (scelta){
                    case 0:
                        System.out.println("Arrivederci!");
                        break;
                    case 1:
                        flag = true;
                        do{
                            try{
                                System.out.println("Inserisci la X: ");
                                x = input.nextFloat();

                                System.out.println("Inserisci la Y: ");
                                y = input.nextFloat();

                                Punto p1 = new Punto(x, y);

                                System.out.println(p1.toString());

                                //traslo il punto
                                System.out.println("Shifta il punto sull'asse X: ");
                                x = input.nextFloat();

                                System.out.println("Shifta il punto sull'asse Y: ");
                                y = input.nextFloat();

                                p1.shift(x, y);
                                System.out.println("Punto Shiftato: ");
                                System.out.println(p1.toString());

                                flag = false;
                            }catch (Exception e){
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }while(false);
                        break;
                    case 2:
                        flag = true;
                        do{
                            try{
                                System.out.println("Inserisci la X: ");
                                x = input.nextFloat();

                                System.out.println("Inserisci la Y: ");
                                y = input.nextFloat();

                                System.out.println("Inserisci il colore: ");
                                input = new Scanner(System.in);
                                color = input.nextLine();

                                PuntoColorato p1 = new PuntoColorato(x, y, color);

                                System.out.println(p1.toString());

                                flag = false;
                            }catch (Exception e){
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }while(false);
                        break;
                    case 3:
                        flag = true;
                        do{
                            try{
                                System.out.println("Inserisci la X: ");
                                x = input.nextFloat();

                                System.out.println("Inserisci la Y: ");
                                y = input.nextFloat();

                                System.out.println("Inserisci la Z: ");
                                z = input.nextFloat();

                                Punto3D p1 = new Punto3D(x, y, z);

                                //traslo il punto
                                System.out.println("Shifta il punto sull'asse X: ");
                                x = input.nextFloat();

                                System.out.println("Shifta il punto sull'asse Y: ");
                                y = input.nextFloat();

                                System.out.println("Shifta il punto sull'asse Z: ");
                                z = input.nextFloat();

                                p1.shift(x, y, z);
                                System.out.println("Punto Shiftato: ");
                                System.out.println(p1.toString());

                                flag = false;
                            }catch (Exception e){
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }while(false);
                        break;
                    default:
                        throw new Exception("Scelta errata!");
                }
            }catch (Exception e){
                System.out.println("Errore: " + e.getMessage());
            }
        }while(scelta != 0);
    }
}
