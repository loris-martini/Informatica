import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input;
        input = new Scanner(System.in);
        //INSERT INTO Contatti (nome, cognome, codice_fiscale, data_nascita, ora_nascita, diplomato)
        //VALUES ('Mario', 'Rossi', 'RSSMRA80A01H501A', '1980-01-01', '12:00:00', 1);
        System.out.println("In che tabella vuoi inserire i dati: (contatto(1) / numeroditelefono(2) / gruppi(3)?");

        int i = input.nextInt();

        switch (i){
            case 1:
                System.out.println("Inserisci i valori: ");

                System.out.println("nome: ");
                input = new Scanner(System.in);
                String nome = input.nextLine();

                System.out.println("cognome: ");
                input = new Scanner(System.in);
                String cognome = input.nextLine();

                System.out.println("cf: ");
                input = new Scanner(System.in);
                String cf = input.nextLine();
                if(!cf.equals("^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$")){
                    return;
                }

                System.out.println("dataDiNascita: ");
                input = new Scanner(System.in);
                String dataDiNascita = input.nextLine();
                if(!dataDiNascita.equals("^(?:(?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                    return;
                }

                System.out.println("oraDiNascita: ");
                input = new Scanner(System.in);
                String oraDiNascita = input.nextLine();
                if(!oraDiNascita.equals("^([01]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])$")){
                    return;
                }

                System.out.println("diplomato(0 / 1): ");
                input = new Scanner(System.in);
                int diplomato = input.nextInt();
                if(!(diplomato == 1 || diplomato == 0)){
                    return;
                }

                System.out.println("INSERT INTO contatto (nome, cognome, cf, dataDiNascita, oraDiNascita, diplomato) VALUES " +
                        "('"+nome+"', '"+cognome+"', '"+cf+"', '"+dataDiNascita+"', '"+oraDiNascita+"', '"+diplomato+"');");
                break;
            case 2:
                System.out.println("Inserisci i valori: ");

                System.out.println("operatore: ");
                String operatore = input.nextLine();

                System.out.println("tipo: ");
                String tipo = input.nextLine();
                if(!(tipo.equals("Personale") || tipo.equals("Casa") || tipo.equals("Lavoro"))){
                    return;
                }

                System.out.println("numTelefono: ");
                String numTelefono = input.nextLine();
                if(!numTelefono.equals("^((\\+|00)39)?( |-)?(3[0-9]{2})( |-)?([0-9]{6,7})$")){
                    return;
                }

                System.out.println("INSERT INTO numeroditelefono (operatore, tipo, numero) VALUES " +
                        "('"+operatore+"', '"+tipo+"', '"+numTelefono+"');");
                break;
            case 3:
                System.out.println("nome: ");
                String nomeG = input.nextLine();
                System.out.println("INSERT INTO gruppi(nome) VALUES " +
                        "(" + nomeG+");");
                break;
        }
    }
}