import java.util.Scanner;

public class ripassomain {
    public static void main(String[] args) {
        //______________________________________________

        /* // RIPASSO VERIFICA

        1. Scrivere un programma Java che richieda in input 3 numeri interi e generi due thread:
        uno che mandi in stampa i 3 numeri disposti in ordine crescente, l’altro in ordine decrescente.

        2. Scrivi un programma Java in modo tale che quando il thread viene attivato vengono stampati a video,
        con la cadenza di uno al secondo, i termini della successione di Fibonacci, partendo dal primo e fino ad arrivare al termine n-esimo.
        link: in allegato

        3. Otto amici decidono di fare una gara di velocità sulla pista di go-kart: il gestore della pista,
         per questioni di sicurezza, ha stabilito che possono correre solo 4 kart per volta e che ciascun pilota
         può effettuare al più 15 giri. Scrivi un programma che simuli la gara di velocità rispettando i vincoli imposti
         dal gestore della pista. Ciascun pilota, rappresentato da un thread, intraprende le seguenti azioni:
        a. se non c’è posto attende;
        b. sale sul kart e entra in pista (se in pista ci sono già 4 kart attende che uno dei piloti termini i giri a disposizione);
        c. effettua 15 giri di pista;
        d. lascia la pista.

        */
        Scanner input= new Scanner(System.in);
        // esercizio 1.
        /*


        int n1, n2, n3;

        System.out.println("Inserire il primo numero: ");
        n1= input.nextInt();
        System.out.println("Inserire il secondo numero: ");
        n2= input.nextInt();
        System.out.println("Inserire il terzo numero: ");
        n3=input.nextInt();

        new Thread(new StampaNumeri(n1, n2, n3,true)).start();
        new Thread(new StampaNumeri(n1, n2, n3, false)).start();
        */

        //es.2
        /*
        int n;
        System.out.println("Inserire il numero: ");
        n = input.nextInt();
        Thread f1 = new Thread(new Fibonacci(n));
        f1.start();
        */

        //es.3
        Thread kart1 = new Thread(new Kart("1","A", null));
        Thread kart2 = new Thread(new Kart("2","B", null));
        Thread kart3 = new Thread(new Kart("3","C", null));
        Thread kart4 = new Thread(new Kart("4","D", null));
        Thread kart5 = new Thread(new Kart("5","E", kart1));
        Thread kart6 = new Thread(new Kart("6","F", kart2));
        Thread kart7 = new Thread(new Kart("7","G", kart3));
        Kart c = new Kart("8","H", kart4);
        Thread kart8 = new Thread(c);

        kart1.start();
        kart2.start();
        kart3.start();
        kart4.start();
        kart5.start();
        kart6.start();
        kart7.start();
        kart8.start();

        Thread[] cc = c.getClassifica();
        for (int i = 0; i < 8; i++) {
            System.out.println(cc[i].getName());
        }




    }
}
