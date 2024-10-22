public class Kart implements Runnable{
    private static Thread[] classifica = new Thread[8];
    private static int dimLog;
    private String nomeKart;
    private String nomePilota;

    private Thread c;

    public Kart(){

    }
    public Kart (String nomeKart, String nomePilota, Thread c){
        this.nomeKart = nomeKart;
        this.nomePilota = nomePilota;
        this.c = c;
    }

    @Override
    public void run() {
        if (c!=null){
            try {c.join();} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
        for (int i = 0; i<15; i++){
            if(i == 14){
                System.out.println((dimLog+1)+"°) " + "Il kart "+nomeKart+" guidato da "+nomePilota+" é ARRIVATO AL TRAGUARDO!");
                classifica[dimLog] = Thread.currentThread();
                dimLog++;
            }else {
                System.out.println("Il kart "+nomeKart+" guidato da "+nomePilota+" ha effettuato "+(i+1)+" giri!");
                            }
        }
    }

    public Thread[] getClassifica(){
        return classifica.clone();
    }
}
