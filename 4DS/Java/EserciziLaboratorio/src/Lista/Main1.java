package Lista;

public class Main1 {
    public static void main(String[] args) {
        // Esempio di utilizzo delle classi
        try {
            MezzoDiTrasporto m = new MezzoDiTrasporto(500, "FIAT");
            System.out.println(m.info());

            Automobile a = new Automobile(800, "LAND ROVER");
            Persona persona1 = new Persona("Persona1");
            Persona persona2 = new Persona("Persona2");

            a.aggiungiPasseggero(persona1);
            a.aggiungiPasseggero(persona2);

            System.out.println(a.toString());

            a.ordinaPasseggeriCrescente();
            System.out.println("Passeggeri ordinati in ordine crescente: " + a.toString());

            a.ordinaPasseggeriDecrescente();
            System.out.println("Passeggeri ordinati in ordine decrescente: " + a.toString());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
