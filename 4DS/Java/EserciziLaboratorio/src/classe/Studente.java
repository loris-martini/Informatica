package classe;

import java.lang.String;

public class Studente {
    private String nome;
    private String cognome;

    public Studente(String nome, String cognome) throws Exception{
        setNome(nome);
        setCognome(cognome);
    }

    public Studente(Studente s) throws Exception{
        this.nome = s.nome;
        this.cognome = s.cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setNome(String nome)throws Exception{
        controllo(nome.trim());
        this.nome = rimodella(nome.trim());
    }

    public void setCognome(String cognome)throws Exception{
        controllo(cognome.trim());
        this.cognome = rimodella(cognome.trim());
    }

    private void controllo(String s) throws Exception{
        if(s == null){
            throw new NullPointerException("Stringa vuota!");
        }
        if(s.equals(" ")){
            throw new Exception("Stringa vuota!");
        }
        if(s.length() <= 3){
            throw new Exception("Stringa troppo corta!");
        }

        try {
            String[] cog = s.split(" ");
            if (cog.length == 0) {
                throw new Exception("Stringa vuota!");
            }
            for(int i = 0; i < cog.length; i++) {
                if (!cog[i].matches("^[A-Za-zÀ-ÿ'\\s]+$")) { //espressioni regolari
                    throw new Exception("Stringa errato!");
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            throw new Exception("Sconosciuto!");
        }catch (Exception e){
            throw new Exception(" " + e.getMessage());
        }
    }

    private String rimodella(String s){
        String[] cog = s.split(" ");
        String newS = "";
        for(int i = 0; i < cog.length; i++) {
            cog[i] = cog[i].toLowerCase();
            newS += cog[i].substring(0, 1).toUpperCase() + cog[i].substring(1) + " ";
        }

        return newS;
    }

    public String toString() {
        return "Studente: \n" + nome + "\n" + cognome;
    }
}
