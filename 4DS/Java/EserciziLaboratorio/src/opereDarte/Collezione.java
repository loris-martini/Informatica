package opereDarte;

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

    /*
    public void inserisciScultura(Scultura s1)throws Exception{
        if(s1 == null){
            throw new Exception("Opera nulla!");
        }
        collection[dimLog] = new Scultura(s1);
        dimLog++;
    }

    public void inserisciQuadro(Quadro q1)throws Exception{
        if(q1 == null){
            throw new Exception("Opera nulla!");
        }
        collection[dimLog] = new Quadro(q1);
        dimLog++;
    }
     */

    /*
    public void inserisci(OperaDarte od1)throws Exception { //aggregazione lasca
        if(od1 == null){
            throw new Exception("Opera nulla!");
        }
        collection[dimLog] = od1;
        dimLog++;
    }
     */

    public void inserisci(OperaDarte od1)throws Exception { //aggregazione stretta
        if(od1 == null){
            throw new Exception("Opera nulla!");
        }
        if(od1 instanceof Quadro){ //se od1
            collection[dimLog] = new Quadro((Quadro) od1);
        }
        else{
            collection[dimLog] = new Scultura((Scultura) od1);
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
