package documentoCom;

public interface GestoreDiCassa {
    String print();
    void aggiungiProd(Prodotto prodotto, int numero) throws Exception;
    void rimuoviProd(Prodotto prodotto) throws Exception;
}
