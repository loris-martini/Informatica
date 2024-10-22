public class Main {
    public static void main(String[] args) {


        //______________________________________________

        /* // COMPITI A CASA 1

        //esercizio dato
        EsercizioUno thr1=new EsercizioUno();
        thr1.start();
        System.out.println(Thread.currentThread().getName());

        //esercizio 1
        ContaThread thr2= new ContaThread("primoThread");
        ContaThread thr3= new ContaThread("seconodThread");
        thr2.start();
        thr3.start();

        //esercizio 2
        ContaThread thrNano1 = new ContaThread("Brontolo");
        ContaThread thrNano2 = new ContaThread("Dotto");
        ContaThread thrNano3 = new ContaThread("Eolo");
        ContaThread thrNano4 = new ContaThread("Gongolo");
        ContaThread thrNano5 = new ContaThread("Mammolo");
        ContaThread thrNano6 = new ContaThread("Pisolo");
        ContaThread thrNano7 = new ContaThread("Cucciolo");

        //esercizio 3
        thrNano1.start(); //  \
        thrNano2.start(); //   \
        thrNano3.start(); //    |
        thrNano4.start(); //    ------> partono in ordine ma finiscono in ordine sparso
        thrNano5.start(); //    |
        thrNano6.start(); //   /
        thrNano7.start(); //  /

        //esercizio 4
        Thread thrPari= new Thread(() -> {
            for(int i=0; i<=10; i++){
                if(i%2==0){
                    System.out.println(i);
                }
            }
        });
        Thread thrDispari= new Thread(() -> {
            for(int i=0; i<=10; i++){
                if(i%2!=0){
                    System.out.println(i);
                }
            }
        });
        thrPari.start();
        thrDispari.start();

        //esercizio 5
        Campana thrDin= new Campana("Din", 3);
        Campana thrDon= new Campana("Don", 3);
        Campana thrDan= new Campana("Dan", 3);
        thrDin.start();
        thrDon.start();
        thrDan.start();

        */
        //___________________________________________________

        ///* // LEZIONE IN CLASSE GIORNO 21 MARZO 2024

        //esercizio 5 con interfaccia ATTENZIONE iCampana != Campana

        //modo 1
        iCampana thriDon= new iCampana("Don", 10);
        Thread thriDonT= new Thread(thriDon);
        thriDonT.start();

        //modo 2
        Thread thriDin2= new Thread( new iCampana("Din", 10));
        thriDin2.start();

        //modo 3
        new Thread(new iCampana("Dan", 10)).start();

        //esercizo con metodo sleep() a cui passi come parametro i millisecondi
        new Thread(new sCampana("Dan", 10, 400)).start();

        //*/

        //______________________________________________

        /* // COMPITI A CASA 2

        //esercizi Sleep Method per 28/03/2024

        new Thread(new sCampana("Din", 10, 1000)).start();// \
        new Thread(new sCampana("Don", 10, 1050)).start();// |---> mandandolo più volte funziona in ordine fino a quando non intersecano i timer
        new Thread(new sCampana("Dan", 10, 1100)).start();// /

        //con --- (dun) fra ogni chiamata

        new Thread(new sCampana("Din", 10, 1000)).start();
        new Thread(new sCampana("---", 10, 1020)).start();
        new Thread(new sCampana("Don", 10, 1050)).start();
        new Thread(new sCampana("---", 10, 1070)).start();
        new Thread(new sCampana("Dan", 10, 1100)).start();
        new Thread(new sCampana("---", 10, 1120)).start();

        //esercizio Join Method per 28/03/2024 (non funziona, con join un thread aspetta la completa esecuzione dell'altro e quindi l'output sarà din din din don don don dan dan dan)

        sCampana SDinJ = new sCampana("Din", 3, 1000);
        sCampana SDonJ = new sCampana("Don", 3, 1000);
        sCampana SDanJ = new sCampana("Dan", 3, 1000);

        Thread thrSDinJ = new Thread(SDinJ);
        Thread thrSDonJ = new Thread(SDonJ);
        Thread thrSDanJ = new Thread(SDanJ);

        thrSDinJ.start();
        try {
            thrSDinJ.join();
        } catch (Exception e) { //il metodo join() richiede un costrutto try-catch
            e.getMessage();
        }
        thrSDonJ.start();
        try {
            thrSDonJ.join();
        } catch (Exception e) {
            e.getMessage();
        }
        thrSDanJ.start();

        //esercizi Priority per 28/03/2024
*/
        /*
        Counter counter1 = new Counter("Counter 1");
        Counter counter2 = new Counter("Counter 2");
        Counter counter3 = new Counter("Counter 3");

        counter1.setPriority(Thread.MIN_PRIORITY); //priorità minima         \
        counter2.setPriority(Thread.NORM_PRIORITY); //priorità normale       |----> in un esempio del genere la priorità non si nota tanto...
        counter3.setPriority(Thread.MAX_PRIORITY); //priorità massima        /

        counter1.start();
        counter2.start();
        counter3.start();

        try {
            Thread.sleep(5000); //il numero di iterazioni è basato su questo sleep, in base al numero di secondi cambia il numero di iterazioni
            counter1.interrupt(); //con interrupt() il thread si ferma
            counter2.interrupt();
            counter3.interrupt();
        } catch (Exception e) {
            e.getMessage();
        }


*/
    }
}