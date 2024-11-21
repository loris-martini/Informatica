package opereDarteBIS;

public class Collezione {
    private String nome;
    private String luogo;
    private OperaDarte[] collection;
    private int dimLog;

    public Collezione(String n, String l, int num){
        setNome(n);
        setLuogo(l);
        collection = new OperaDarte[num];
        dimLog = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public void inserisci(OperaDarte od1)throws Exception { //aggregazione lasca
        if(od1 == null){
            throw new Exception("Opera nulla!");
        }
        collection[dimLog] = od1;
        dimLog++;
    }



    public double occupazione(OperaDarte od1) throws Exception{
        if(od1 == null){
            throw new Exception("OperaDarte nulla!");
        }

        for (int i = 0; i < dimLog; i++) {
            if(collection[i].equals(od1)){
                return collection[i].printIngombro();
            }
        }
        throw new Exception("Non trovato!");
    }

    public String stampaCollezione(){
        String s = "";
        for (int i = 0; i < dimLog; i++) {
            s += collection[i].toString();
        }
        return s;
    }
}
