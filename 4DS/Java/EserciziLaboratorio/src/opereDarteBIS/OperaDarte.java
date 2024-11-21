package opereDarteBIS;

public abstract class OperaDarte {
    protected String titolo;
    protected String artista;

    public OperaDarte(String t, String a){
        setTitolo(t);
        setArtista(a);
    }

    public OperaDarte(opereDarte.OperaDarte od1){
        setTitolo(od1.getTitolo());
        setArtista(od1.getArtista());
    }


    private void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    private void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }

    public boolean equals(OperaDarte op){
        if(titolo.equals(op.titolo) && artista.equals(op.artista) && printIngombro() == op.printIngombro()){
            return true;
        }
        return false;
    }


    public abstract double printIngombro();


    public String toString() {
        return "Titolo: " + titolo + "\nArtista: " + artista;
    }
}

