package martini;

import org.apache.commons.validator.routines.EmailValidator;

public class Persona {
    private String cognome;
    private String nome;
    private String codFisc;
    private String dataDiNascita;
    private String email;
    protected static int numeroIstanze = 0;

    //COSTRUTTORI
    public Persona(){ //Inizializzo l'oggetto
        cognome = "";
        nome = "";
        codFisc = "";
        numeroIstanze++;
    }

    public Persona(String cognome, String nome, String codFisc, String data, String email) throws Exception{
        setCognome(cognome);
        setNome(nome);
        setCodFisc(codFisc);
        setDataDiNascita(data);
        setEmail(email);
        numeroIstanze++;
    }

    public Persona(Persona persona) throws Exception{
        setCognome(persona.cognome);
        setNome(persona.nome);
        setCodFisc(persona.codFisc);
        setDataDiNascita(persona.dataDiNascita);
        setEmail(persona.email);
        numeroIstanze++;
    }

    //SETTER
    public void setCognome(String cognome) throws Exception{
        controlloNominativi(cognome);
        this.cognome = "";

        String[] s = cognome.split(" ");
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim(); //per evitare più spazi tra una parola e l'altra
            s[i] = s[i].toLowerCase();
            this.cognome += s[i].substring(0,1).toUpperCase() + s[i].substring(1) + " ";
        }
    }

    public void setNome(String nome) throws Exception{
        controlloNominativi(nome);
        this.nome = "";

        String[] s = nome.split(" ");

        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim(); //per evitare più spazi tra una parola e l'altra
            s[i] = s[i].toLowerCase();
            this.nome += s[i].substring(0,1).toUpperCase() + s[i].substring(1) + " ";
        }
    }

    public void setCodFisc(String codFisc) throws Exception{
        if(codFisc == null){
            throw new Exception("Stringa nulla!");
        }
        codFisc = codFisc.trim(); //elimino spazi prima e dopo
        if(codFisc.equals("")){
            throw new Exception("Stringa vuota!");
        }

        if(!codFisc.matches("[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]")){
            throw new Exception("Codice Fiscale errato!");
        }

        this.codFisc = codFisc;
    }

    public void setDataDiNascita(String dataDiNascita) throws Exception{
        if(dataDiNascita == null){
            throw new Exception("Stringa nulla!");
        }
        dataDiNascita = dataDiNascita.trim(); //elimino spazi prima e dopo
        if(dataDiNascita.equals("")){
            throw new Exception("Stringa vuota!");
        }
        this.dataDiNascita = "";

        String[] s = dataDiNascita.split("/");

        if(s[2].length() != 4){
            throw new Exception("Anno errato!");
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
            switch (i){
                case 0:
                    if(s[i].charAt(0) == '0' || s[i].charAt(0) == '1' || s[i].charAt(0) == '2') {
                        if(s[i+1].equals("02")){
                            int anno = (s[i+2].charAt(0)-48)*1000 + (s[i+2].charAt(1)-48)*100 + (s[i+2].charAt(2)-48)*10 + s[i+2].charAt(3)-48;
                            if(anno % 4 ==  0){ //bisestile
                                if (!s[i].matches("[0-2][0-9]*")) {
                                    throw new Exception("Giorno errato!");
                                }
                            }else {
                                if (!s[i].matches("[0-2][0-8]*")) {
                                    throw new Exception("Giorno errato!");
                                }
                            }
                        }else {
                            if (!s[i].matches("[0-9]*")) {
                                throw new Exception("Giorno errato!");
                            }
                        }
                    }else{
                        if(s[i].charAt(0) == '3'){
                            if (!s[i].matches("3[0-1]")) {
                                throw new Exception("Giorno errato!");
                            }
                        }else{
                            throw new Exception("Giorno errato!");
                        }
                    }
                    this.dataDiNascita += s[i] + "/";
                    break;
                case 1:
                    if(s[i].charAt(0) == '1'){
                        if(!s[i].matches("[0-2]*")){
                            throw new Exception("Mese errato!");
                        }
                    }else {
                        if (s[i].charAt(0) == '0') {
                            if (!s[i].matches("0[0-9]*")) {
                                throw new Exception("Mese errato!");
                            }
                        } else {
                            throw new Exception("Mese errato!");
                        }
                    }
                    this.dataDiNascita += s[i] + "/";
                    break;
                case 2:
                    if(!s[i].matches("[0-9]*")){
                        throw new Exception("Anno errato!");
                    }
                    this.dataDiNascita += s[i];
                    break;
                default:
                    throw new Exception("Data errata!");
            }
        }
    }

    public void setEmail(String email) throws Exception{
        EmailValidator e = EmailValidator.getInstance();
        if(!e.isValid(email)){
            throw new Exception("Email non valida!");
        }
        this.email = email;
    }

    //GETTER
    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCodFisc() {
        return codFisc;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public static int getNumeroIstanze() {
        return numeroIstanze;
    }

    /*
    public Integer calcolaEta(){
        Integer eta;
    }
     */

    private void controlloNominativi(String nominativo)throws Exception{
        if(nominativo == null){
            throw new Exception("Stringa nulla!");
        }
        nominativo = nominativo.trim(); //elimino spazi prima e dopo
        if(nominativo.equals("")){
            throw new Exception("Stringa vuota!");
        }

        String[] s = nominativo.split(" ");

        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim(); //per evitare più spazi tra una parola e l'altra
            s[i] = s[i].toLowerCase();
            if (!s[i].matches("[a-z]*")){
                throw new Exception("Stringa Errata!"); //se non rispetta la condizione lancia un'eccezione
            }
        }
    }

    public boolean verificaOmonimia(Persona persona){
        if(persona.getNome().equals(persona.getCognome())){
            return true;
        }else {
            return false;
        }
    }

    public String toString() {
        return "[" + cognome + ", " + nome + ", " + codFisc + "]";
    }
}
