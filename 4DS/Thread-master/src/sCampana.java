public class sCampana implements Runnable{
    private String suono;
    private int volte;

    private int temp;
    public sCampana(String suono, int volte, int temp){
        this.suono=suono;
        this.volte=volte;
        this.temp=temp;
    }


    @Override
    public void run() {
        for(int i=0; i<volte; i++){
            System.out.println(suono);
            try{
                Thread.sleep(temp);
            }
            catch(InterruptedException e){
                return;
            }
        }
    }
}
