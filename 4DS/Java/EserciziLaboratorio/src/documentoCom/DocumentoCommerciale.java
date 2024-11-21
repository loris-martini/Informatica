package documentoCom;

import java.util.ArrayList;

public abstract class DocumentoCommerciale {
    protected ArrayList<Prodotto> listaProdotti;
    protected double totale;
    protected Azienda azienda;
    protected Data data;

    public DocumentoCommerciale(Azienda a, Data d) {
        azienda = a;
        data = d;
        totale = 0;
        listaProdotti=new ArrayList<>();
    }

    public void aggiungiProd(Prodotto prodotto, int numero) throws Exception {
        if(ricercaProdInAzienda(prodotto)){
            listaProdotti.add(prodotto);
            totale += prodotto.getPrezzo() * numero;
        }
        else{
            throw new Exception("Prodotto non presente all'interno della dispensa!");
        }
    }

    public void rimuoviProd(Prodotto prodotto) throws Exception {
        if(ricercaProdInAzienda(prodotto)){
            if(listaProdotti.contains(prodotto)){
                listaProdotti.remove(prodotto);
                totale -= prodotto.getPrezzo();
            }
            else{
                throw new Exception("Prodotto non presente all'interno dello scontrino!");
            }
        }
        else{
            throw new Exception("Prodotto non presente all'interno della dispensa!");
        }
    }

    private boolean ricercaProdInAzienda(Prodotto prodotto){
        for(int i = 0; i <= azienda.listaProdotti.length; i++){
            if(prodotto == azienda.listaProdotti[i]){
                return true;
            }
        }
        return false;
    }

    public abstract String print();

    public String toString() {
        String s = "";
        s += "Supermercato: " + azienda.getNome();
        s += "\nIndirizzo: " + azienda.getIndirizzo();
        s += "\nMail: " + azienda.getMail();
        s += "\nTelefono: " + azienda.getTelefono();

        s += "\nDettagli Spesa:";
        for (Prodotto prodotto : listaProdotti) {
            s += "\n" + prodotto.toString();
        }

        s += "\nTOTALE COMPLESSIVO: " + totale + " EUR";

        return s;
    }
}
