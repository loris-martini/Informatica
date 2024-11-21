package Lista;

class MezzoDiTrasporto {
    static final float coef = 0.73f;
    private static int numeroIstanze = 0;

    private Integer cavalli;
    private String marca;

    public MezzoDiTrasporto() {
        this.cavalli = null;
        this.marca = null;
        numeroIstanze++;
    }

    public MezzoDiTrasporto(Integer cavalli, String marca) {
        this.cavalli = cavalli;
        this.marca = marca;
        numeroIstanze++;
    }

    public Integer getCavalli() {
        return cavalli;
    }

    public void setCavalli(Integer cavalli) throws Exception{
        if (cavalli >= 100 && cavalli <= 900) {
            this.cavalli = cavalli;
        } else {
            throw new Exception("I cavalli devono essere compresi tra 100 e 900.");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws Exception{
        if (marca.matches("[A-Z ]{3,}")) {
            this.marca = marca;
        } else {
            throw new Exception("La marca deve contenere almeno 3 caratteri maiuscoli dell'alfabeto.");
        }
    }

    public static int getNumeroIstanze() {
        return numeroIstanze;
    }

    public Integer calcolaKw() {
        return (int) (cavalli * coef);
    }

    public String info() {
        if (cavalli != null && marca != null) {
            return "Cavalli: " + cavalli + "\nMarca: " + marca;
        } else {
            throw new IllegalStateException("Tutte le caratteristiche devono essere presenti.");
        }
    }
}