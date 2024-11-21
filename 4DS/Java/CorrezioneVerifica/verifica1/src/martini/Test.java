package martini;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Prenotazione pt1 = null;
        Persona p1 = null;
        String nome, cognome, codFis, dataN, email, data, ora;

        int sc = -1;


        do{
            try {
                System.out.println("1) Inserisci Prenotazione\n2) Stampa Prenotazine \n3) Controlla Omonimia0) Esci\nScelta: ");
                input = new Scanner(System.in);
                try {
                    sc = input.nextInt();
                }catch (Exception e){
                    throw new Exception("Inserire un valore intero!");
                }

                switch (sc) {
                    case 0:
                        System.out.println("Arrivederci!");
                        break;
                    case 1:
                        System.out.println("Nome: ");
                        input = new Scanner(System.in);
                        nome = input.nextLine();

                        System.out.println("Cognome: ");
                        input = new Scanner(System.in);
                        cognome = input.nextLine();

                        System.out.println("Codice Fiscale: ");
                        input = new Scanner(System.in);
                        codFis = input.nextLine();

                        System.out.println("Data di nascita: ");
                        input = new Scanner(System.in);
                        dataN = input.nextLine();

                        System.out.println("E-mail: ");
                        input = new Scanner(System.in);
                        email = input.nextLine();

                        p1 = new Persona(cognome, nome, codFis, dataN, email);

                        System.out.println("Persona aggiunta con successo!");
                        System.out.println("Data: ");
                        input = new Scanner(System.in);
                        data = input.nextLine();

                        System.out.println("Ora: ");
                        input = new Scanner(System.in);
                        ora = input.nextLine();

                        pt1 = new Prenotazione(p1, data, ora);
                        System.out.println("Prenotazione aggiunta con successo!");
                        break;
                    case 2:
                        try {
                            System.out.println(pt1.toString());
                        }catch (Exception e){
                            throw new Exception("Devi prima inserire una prenotazione!");
                        }
                        break;
                    case 3:
                        try {
                            if (p1.verificaOmonimia(p1)) {
                                System.out.println("SI");
                            } else {
                                System.out.println("NO");
                            }
                        }catch (Exception e){
                            throw new Exception("Devi prima inserire una persona!");
                        }
                        break;
                    default:
                        System.out.println("Scelta Errata!");
                }
            }catch (Exception e){
                System.out.println("Errore: " + e.getMessage());
            }

        }while(sc != 0);
    }
}
