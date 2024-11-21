package opereDarteBIS;

import java.util.Scanner;

public class TestOpere {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double l, a, s ,p;
        String ar, t;
        Quadro q;
        Scultura sc;
        SculturaDeperibile sd;
        Cornice c;
        Supporto sp;

        try {
            System.out.println("Inserisci la Cornice: ");
            System.out.println("Larghezza: ");
            l = input.nextDouble();
            System.out.println("Altezza: ");
            a = input.nextDouble();
            System.out.println("Spessore: ");
            s = input.nextDouble();

            c = new Cornice(l, a, s);

            System.out.println("Inserisci il Quadro: ");
            System.out.println("Titolo: ");
            t = input.nextLine();
            System.out.println("Artista: ");
            ar = input.nextLine();
            System.out.println("Larghezza: ");
            l = input.nextDouble();
            System.out.println("Altezza: ");
            a = input.nextDouble();

            q = new Quadro(c, t, ar, l, a);

            System.out.println("Inserisci il Supporto: ");
            System.out.println("Larghezza: ");
            l = input.nextDouble();
            System.out.println("Altezza: ");
            a = input.nextDouble();
            System.out.println("Profondita: ");
            s = input.nextDouble();

            sp = new Supporto(l, a, s);

            System.out.println("Inserisci la Scultura: ");
            System.out.println("Titolo: ");
            t = input.nextLine();
            System.out.println("Artista: ");
            ar = input.nextLine();
            System.out.println("Larghezza: ");
            l = input.nextDouble();
            System.out.println("Altezza: ");
            a = input.nextDouble();
            System.out.println("Profondita: ");
            s = input.nextDouble();

            sc = new Scultura(sp, t, ar, l, a, s);

        }catch (Exception e){
            System.out.println("Errore: " + e.getMessage());
        }

    }
}
