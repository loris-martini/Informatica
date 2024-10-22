class Counter extends Thread {
    private String name;
    private int count;

    public Counter(String name) {
        count = 0;
        this.name = name;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            count++;
            System.out.println(name + ": " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { //InterruptedException è l'eccezione che viene lanciata da un thread se viene interrotto
                //se il thread viene interrotto, usciamo dal loop
                break;
            }
        }
    }
}