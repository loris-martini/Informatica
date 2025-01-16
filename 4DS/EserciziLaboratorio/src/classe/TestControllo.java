package classe;

import java.util.Scanner;
public class TestControllo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Seleziona il tipo di dato da inserire:");
            System.out.println("1. Email");
            System.out.println("2. Password");
            System.out.println("3. Targa auto");
            System.out.println("4. CAP");
            System.out.println("5. Indirizzo IP");
            System.out.println("6. URL");
            System.out.println("7. Codice fiscale");
            System.out.println("0. Esci");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Inserisci l'email:");
                    String email = input.nextLine();
                    if (Controllo.validateEmail(email)) {
                        System.out.println("Email valida.");
                    } else {
                        System.out.println("Email non valida.");
                    }
                    break;
                case 2:
                    System.out.println("Inserisci la password:");
                    String password = input.nextLine();
                    if (Controllo.validatePassword(password)) {
                        System.out.println("Password valida.");
                    } else {
                        System.out.println("Password non valida.");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci la targa dell'auto:");
                    String targa = input.nextLine();
                    if (Controllo.validateTarga(targa)) {
                        System.out.println("Targa valida.");
                    } else {
                        System.out.println("Targa non valida.");
                    }
                    break;
                case 4:
                    System.out.println("Inserisci il CAP:");
                    String cap = input.nextLine();
                    if (Controllo.validateCap(cap)) {
                        System.out.println("CAP valido.");
                    } else {
                        System.out.println("CAP non valido.");
                    }
                    break;
                case 5:
                    System.out.println("Inserisci l'indirizzo IP:");
                    String ipAddress = input.nextLine();
                    if (Controllo.validateIpAddress(ipAddress)) {
                        System.out.println("Indirizzo IP valido.");
                    } else {
                        System.out.println("Indirizzo IP non valido.");
                    }
                    break;
                case 6:
                    System.out.println("Inserisci l'URL:");
                    String url = input.nextLine();
                    if (Controllo.validateUrl(url)) {
                        System.out.println("URL valido.");
                    } else {
                        System.out.println("URL non valido.");
                    }
                    break;
                case 7:
                    System.out.println("Inserisci il codice fiscale:");
                    String codiceFiscale = input.nextLine();
                    if (Controllo.validateCodiceFiscale(codiceFiscale)) {
                        System.out.println("Codice fiscale valido.");
                    } else {
                        System.out.println("Codice fiscale non valido.");
                    }
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }

        } while (choice != 0);
    }
}
