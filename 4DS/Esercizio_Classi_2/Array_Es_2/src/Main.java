import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        boolean in = false;

        System.out.println("\nInserire la lunghezza dell'Array: ");
        n = input.nextInt();
        GestioneArray n1 = new GestioneArray(n);

        int cont, sce;
        cont = 0;
        do{
            System.out.println("\nCosa vuoi fare?");
            System.out.println("Premi 1: Riempire l'Array");
            System.out.println("Premi 2: Calcolare e visualizzare la somma di tutti gli elementi dell'array");
            System.out.println("Premi 3: Trovare e visualizzare il numero maggiore");
            System.out.println("Premi 4: Dire se la sequenza dei numeri inseriti è crescente");
            System.out.println("Premi 5: Ricercare all'interno dell'array un numero X fornito in input e visualizzare se esiste almeno una volta");
            System.out.println("Premi 0: Uscire");
            System.out.println("\nInserisci il numero dell'incarico: ");

            scelta = input.nextInt();
            if(scelta ==1 ){
                n1.inser();
                
                in = true;
            }

            else if(scelta == 2 && in){
                System.out.println("La somma di tutti i numeri dentro l'Array e`: " + n1.somma());
            }

            else if(scelta == 3 && in){
                System.out.println("Il numero piu` grande dentro l'Array e`: " + n1.nMag());
            }

            else if(scelta == 4 && in){
                if(n1.nCresc() == true){
                    System.out.println("L'Array e` crescente");
                }
                else{
                    System.out.println("L'Array non e` crescente");
                }
            }

            else if(scelta == 5 && in){
                System.out.println("\nInserisci il numero da ricercare:");
                n = input.nextInt();
                if(n1.riceN(n)){
                    System.out.println("Il numero da te inserito " + n + " e` presente");
                }
                else{
                    System.out.println("Il numero da te inserito " + n + " non e` presente");
                }
            }

            else if(scelta == 0){
                cont += 1;
            }
        }while(cont != 1);

        System.out.println("\nArrivederci");
    }
}