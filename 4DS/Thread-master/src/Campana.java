public class Campana extends Thread{
    private String suono;
    private int volte;
    public Campana(String suono, int volte){
        this.suono=suono;
        this.volte=volte;
    }

    @Override
    public void run() {
        for(int i=0; i<volte; i++){
            System.out.println(suono);
            try {
                Thread.sleep(1000); // Aggiungiamo un piccolo ritardo per una migliore visualizzazione
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

