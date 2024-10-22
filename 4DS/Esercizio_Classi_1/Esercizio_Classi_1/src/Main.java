import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        int cond;
        boolean in = false;
        boolean done = false;

        NumeroIntero num = new NumeroIntero();

        do{
            System.out.println("1) Inserisci Numero\n" +
                    "2) Incrementa il numero\n" +
                    "3) Decrementa il numero\n" +
                    "4) Il numero è pari?\n" +
                    "5) Il numero è un numero primo?\n" +
                    "6) Visualizza il numero\n" +
                    "0) Esci");

            cond = input.nextInt();

            if (cond == 1){

                System.out.println("Inserisci il numero: ");
                n = input.nextInt();

                num.setNum(n);

                done = true;
                in = true;
            }



            if (cond == 2 && in == true){ //aggiungo
                System.out.println("Inserisci il numero da aggiungere: ");
                n = input.nextInt();

                num.aggiungi(n);

                done = true;
            }


            else if (cond == 3 && in == true){ //tolgo
                System.out.println("Inserisci il numero da togliere: ");
                n = input.nextInt();

                num.togli(n);

                done = true;
            }


            else if (cond == 4 && in == true){ //pari
                if (num.pari(n) == true){
                    System.out.println("Il numero è pari.");
                }else{
                    System.out.println("Il numero è dispari");
                }

                done = true;
            }


            else if (cond == 5 && in == true){ //primo
                if (num.primo(n) == true){
                    System.out.println("Il numero è primo.");
                }else{
                    System.out.println("Il numero non è primo");
                }

                done = true;
            }


            else if (cond == 6 && in == true){ //stampo
                num.stampa();

                System.out.println("Il numero è: " + n);

                done = true;
            }



            else if(done == false){
                System.out.println("Devi prima inserire un numero");
            }

        }while (cond != 0);
    }
}