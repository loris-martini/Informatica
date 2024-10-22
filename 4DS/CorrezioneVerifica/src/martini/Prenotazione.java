package martini;

public class Prenotazione {
    private Persona persona;
    private String data;
    private String ora;

    public Prenotazione(Persona p1, String data, String ora)throws Exception{
        setPersona(p1);
        setData(data);
        setOra(ora);
    }

    //SETTER
    public void setPersona(Persona p1) throws Exception{
        persona = new Persona(p1);
    }

    public void setData(String data) throws Exception{
        if(data == null){
            throw new Exception("Stringa nulla!");
        }
        data = data.trim(); //elimino spazi prima e dopo
        if(data.equals("")){
            throw new Exception("Stringa vuota!");
        }
        this.data = "";

        String[] s = data.split("/");

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
                    this.data += s[i] + "/";
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
                    this.data += s[i] + "/";
                    break;
                case 2:
                    if(!s[i].matches("[0-9]*")){
                        throw new Exception("Anno errato!");
                    }
                    this.data += s[i];
                    break;
                default:
                    throw new Exception("Data errata!");
            }
        }
    }

    public void setOra(String ora) throws Exception{
        if(ora == null){
            throw new Exception("Stringa nulla!");
        }
        ora = ora.trim(); //elimino spazi prima e dopo
        if(ora.equals("")){
            throw new Exception("Stringa vuota!");
        }
        this.ora = "";

        String[] s = ora.split(":");

        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
            switch (i){
                case 0:
                    if(s[i].charAt(0) == '0' || s[i].charAt(0) == '1'){
                        if(!s[i].matches("[0-9]*")){
                            throw new Exception("(Ora) errata!");
                        }
                    }else {
                        if (s[i].charAt(0) == '2') {
                            if (!s[i].matches("[0-4]")) {
                                throw new Exception("(Ora) errata!");
                            }
                        } else {
                            throw new Exception("(Ora) errata!");
                        }
                    }
                    this.ora += s[i] + ":";
                    break;
                case 1:
                    if(!s[i].matches("[0-6][0-9]")){
                        throw new Exception("(Minuto) errato!");
                    }
                    this.ora += s[i] + ":";
                    break;
                case 2:
                    if(!s[i].matches("[0-6][0-9]")){
                        throw new Exception("(Secondo) errato!");
                    }
                    this.ora += s[i];
                    break;
                default:
                    throw new Exception("Ora errata!");
            }
        }
    }

    //GETTER
    public Persona getPersona() throws Exception{
        return new Persona(persona);
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }


    public String toString() {
        String str = "[" + persona.toString() + ", " + data + ", " + ora + "]";
        return str;
    }
}
