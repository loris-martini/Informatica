public class Persona {
    private String nome;
    private String cognome;
    private Data dataDiNascita;
    protected static int numeroIstanze;

    public Persona()throws Exception{
        numeroIstanze++;
    }

    public Persona(String cognome, String nome, Data data)throws Exception{
        setCognome(cognome);
        setNome(nome);
        if(Data.differenzaInAnni(data, new Data()) > 0){
            throw new Exception("Data di nascita errata!");
        }
        setData(data);
        numeroIstanze++;
    }

    public void setNome(String nome) throws Exception{
        if(nome == null){
            throw new Exception("Parametro nullo!");
        }
        this.nome = nome;
    }

    public void setCognome(String cognome) throws Exception{
        if(cognome == null){
            throw new Exception("Parametro nullo!");
        }
        this.cognome = cognome;
    }

    public void setData(Data data) throws Exception{
        if(data == null){
            throw new Exception("Parametro nullo!");
        }
        dataDiNascita = new Data(data);
    }

    public String getNome() {
        if(nome == null){
            return null;
        }
        return nome;
    }

    public String getCognome() {
        if(cognome == null){
            return null;
        }
        return cognome;
    }

    public Data getDataDiNascita(){
        try {
            return new Data(dataDiNascita.getGiorno(), dataDiNascita.getMese(), dataDiNascita.getAnno());
        }catch (Exception e){
            return null;
        }
    }

    public int getNumeroIstanze() {
        return numeroIstanze;
    }

    public Boolean verificaOmonimia(Persona persona){
        if(persona.getNome().equals(nome) && persona.getCognome().equals(cognome)){
            return true;
        }
        return false;
    }

    public Integer calcolaEta()throws Exception{
        return Data.differenzaInAnni(dataDiNascita, new Data());
    }

    public String info(){
        return "\nCognome: " + cognome + "\nNome: " + nome + "\nData Di nascita: " + dataDiNascita.toString();
    }
}
