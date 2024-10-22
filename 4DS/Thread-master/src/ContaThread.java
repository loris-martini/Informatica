public class ContaThread extends Thread{
    public ContaThread(String nome){
        setName(nome);
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        for(int i=0; i<7; i++){
            System.out.print((i+1)+" ");
        }
    }
}
