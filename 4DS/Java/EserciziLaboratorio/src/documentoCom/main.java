package documentoCom;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Prodotto arr[] = new Prodotto[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Prodotto("Salsiccia", (int)(Math.random() * 3), 22);
        }

        try {
            Azienda azienda = new Azienda("buonarroti", "Via Brigata Aqui 12", "michelangelo.buonarroti@gmail.com", "+39 3534539562", arr);
            DatiPrivato privato = new DatiPrivato("Cristiano", "Ronaldo", "Via Rio Santo 120", "ITL6453882567932478676");

            Scontrino scontrino = new Scontrino(azienda, new Data(), 100);
            Fattura fattura = new Fattura(azienda, new Data(), privato);

            scontrino.aggiungiProd(arr[0], 1);
            fattura.aggiungiProd(arr[0], 100);
            System.out.println(scontrino.print());
            System.out.println(fattura.print());
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e.getMessage());
        }
    }
}
