public class iCampana implements Runnable{
    private String suono;
    private int volte;
    public iCampana(String suono, int volte){
        this.suono=suono;
        this.volte=volte;
    }


    @Override
    public void run() {
        for(int i=0; i<volte; i++){
            System.out.println(suono);
        }
    }
}

