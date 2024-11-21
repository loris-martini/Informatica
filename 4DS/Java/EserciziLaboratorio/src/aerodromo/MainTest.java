package aerodromo;
public class MainTest {

    public static void main(String[] args) {
        Aeromobile[] aeromobili = new Aeromobile[4];

        aeromobili[0] = new Aliante("AL1", 20);
        aeromobili[1] = new Aereomotore("AM1", 200.5);
        aeromobili[2] = new Aereomotore("AM2", 150.0);
        aeromobili[3] = new Aliante("AL2", 15);


        System.out.println("Aeromobili nell'array:");
        for (int i = 0; i<4; i++) {
            System.out.println(aeromobili[i].toString());
        }

        // Test del metodo superiore
        System.out.println("\nRisultati del confronto di prestazioni:");

        if (aeromobili[0].superiore(aeromobili[1])) {
            System.out.println(aeromobili[0].getSigla() + " è superiore a " + aeromobili[1].getSigla());
        } else {
            System.out.println(aeromobili[0].getSigla() + " non è superiore a " + aeromobili[1].getSigla());
        }

        if (aeromobili[2].superiore(aeromobili[1])) {
            System.out.println(aeromobili[2].getSigla() + " è superiore a " + aeromobili[1].getSigla());
        } else {
            System.out.println(aeromobili[2].getSigla() + " non è superiore a " + aeromobili[1].getSigla());
        }
    }
}