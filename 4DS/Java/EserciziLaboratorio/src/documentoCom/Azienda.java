package documentoCom;

import java.util.Arrays;


class Azienda {
    private String nome;
    private String indirizzo;
    private String mail;
    private String telefono;
    protected Prodotto[] listaProdotti;

    public Azienda(String n, String i, String m, String t, Prodotto[] lP) throws Exception{
        if(n == null){
            throw new Exception("Nome Errato!");
        }
        nome = n;

        if(i == null){
            throw new Exception("Indirizzo Errato!");
        }
        indirizzo = i;

        if(m == null){
            throw new Exception("Mail Errata!");
        }
        mail = m;

        if(t == null){
            throw new Exception("Telefono Errato!");
        }
        telefono = t;

        if(lP == null){
            throw new Exception("Prodotti Errati!");
        }
        listaProdotti = lP.clone();
    }


    public void aggiungiProd(Prodotto prodotto) throws Exception {
        if(prodotto == null){
            throw new Exception("Prodotto Errato!");
        }
        if(ricerca(prodotto) == -1){
            throw new Exception("Il prodotto esiste di già!");
        }
        else{
            int newLung = listaProdotti.length+1;
            listaProdotti = java.util.Arrays.copyOf(listaProdotti, newLung);
            listaProdotti[newLung-1] = prodotto;
        }
    }
    public void rimuoviProd(Prodotto prodotto) throws Exception {
        int index = ricerca(prodotto);
        if(index != -1){
            throw new Exception("Il prodotto non esiste!");
        }
        else{
            Prodotto tmpProd = null;
            for(int i = index; i < listaProdotti.length - 1; i++){
                listaProdotti[i] = listaProdotti[i+1];
            }
            int newLung = listaProdotti.length - 1;
            listaProdotti = java.util.Arrays.copyOf(listaProdotti, newLung);
        }
    }

    private int ricerca(Prodotto prodotto){
        int i = 0;
        int found = -1;
        while(i <= listaProdotti.length) {
            if (prodotto == listaProdotti[i]) {
                found = i;
            }
            i++;
        }
        return found;
    }


    public String getNome() {
        return nome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public String getMail() {
        return mail;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getListaProdotti() {
        return Arrays.toString(listaProdotti);
    }
}
