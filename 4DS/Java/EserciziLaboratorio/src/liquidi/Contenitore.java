package liquidi;

abstract class Contenitore implements Confrontabile{
    private String tipo;
    private String codice;
    private String nome;
    private int qta;
    private int ps;

    public Contenitore(String codice, String nome, int qta, int ps, String tipo) {
        this.codice = codice;
        this.nome = nome;
        this.qta = qta;
        this.ps = ps;
        this.tipo = tipo;
    }

    public Boolean confrontaMaggiore(Confrontabile obj) throws Exception{
        if(((Contenitore) obj).getTipo().equals("Bidone")){
            if(((Contenitore) obj).getQta() > getQta()){
                return true;
            }else{
                return false;
            }
        }
        else if (((Contenitore) obj).getTipo().equals("Lattina")) {
            if(((Contenitore) obj).getQta() > getQta()){
                return true;
            }else{
                return false;
            }
        }
        else{
            throw new Exception("L'oggetto passato non è sia Lattina che Bidone!");
        }
    }


    public Boolean confrontaMinore(Confrontabile obj) throws Exception{
        if(((Contenitore) obj).getTipo().equals("Bidone")){
            if(((Contenitore) obj).getQta() < getQta()){
                return true;
            }else{
                return false;
            }
        }
        else if (((Contenitore) obj).getTipo().equals("Lattina")) {
            if(((Contenitore) obj).getQta() < getQta()){
                return true;
            }else{
                return false;
            }
        }
        else{
            throw new Exception("L'oggetto passato non è sia Lattina che Bidone!");
        }
    }


    public Boolean confrontaUguale(Confrontabile obj) throws Exception{
        if(((Contenitore) obj).getTipo().equals("Bidone")){
            if(((Contenitore) obj).getQta() == getQta()){
                return true;
            }else{
                return false;
            }
        }
        else if (((Contenitore) obj).getTipo().equals("Lattina")) {
            if(((Contenitore) obj).getQta() == getQta()){
                return true;
            }else{
                return false;
            }
        }
        else{
            throw new Exception("L'oggetto passato non è sia Lattina che Bidone!");
        }
    }


    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public int getQta() {
        return qta;
    }

    public int getPs() {
        return ps;
    }

    public String getTipo() {
        return tipo;
    }
}

