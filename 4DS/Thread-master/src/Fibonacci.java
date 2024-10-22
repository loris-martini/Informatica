public class Fibonacci implements Runnable{
    private int volte;

    public Fibonacci(int nVolte){
        volte = nVolte;
    }

    @Override
    public void run() {
        for (int i = 0; i < volte; i++) {
            System.out.println(fibonacci(i+1));
            try{Thread.sleep(1000);}catch (InterruptedException e){return;}
        }
    }
    private int fibonacci(int n){
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
