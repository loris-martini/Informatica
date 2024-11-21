import java.util.Scanner;

public class Martini{
    public static void main(String[] args) {
        try {

            //Ho creato la classe Data per far funzioanre il codice (quindi ho dovuto aggiugnere alcune eccezioni)

            Scanner input = new Scanner(System.in);
            Data data = new Data(12,12,1212);
            Persona p = new Persona("Rossi", "Marco", data);
            Studente s = new Studente(4, false, "Rossi", "Marco" , data);
            StudenteObj so = new StudenteObj(4, false, "Rossi", "Marco" , data);

            System.out.println("\nData: ");
            System.out.println(data.toString());

            System.out.println("\nPersona: ");
            System.out.println(p.info());

            System.out.println("aggiungi voto: ");
            float v = input.nextFloat();
            s.aggiungiVoto(v);
            //s.aggiungiVoto(v);
            //s.aggiungiVoto(v);

            System.out.println("\nStudente: ");
            System.out.println(s.info());

            System.out.println("\nStudenteObj: ");
            System.out.println(so.toString());
        }catch (Exception e){
            System.out.println("\nErrore: " + e.getMessage());
        }
    }
}
