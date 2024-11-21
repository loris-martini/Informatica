package aerodromo;
import java.util.Objects;

public class Aereomotore extends Aeromobile {
    private double potenzaCV;

    public Aereomotore(String sigla, double potenzaCV) {
        super(sigla);
        this.potenzaCV = potenzaCV;
    }

    public double getPotenzaCV() {
        return potenzaCV;
    }

    @Override
    protected boolean confrontaPrestazioni(Aeromobile altroAeromobile) {
        Aereomotore altroAereomotore = (Aereomotore) altroAeromobile;
        return potenzaCV > altroAereomotore.potenzaCV;
    }

    @Override
    public boolean equals(Object o) {

        boolean ret = false;
        if (o instanceof Aereomotore){
            Aereomotore aereomotore = (Aereomotore) o;
            if(super.equals(o) && this.potenzaCV == aereomotore.potenzaCV){
                ret = true;
            }
        }
        return ret;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), potenzaCV);
    }

    @Override
    public String toString() {
        return "Aereomotore{" +
                "sigla='" + getSigla() + '\'' +
                ", potenzaCV=" + potenzaCV +
                '}';
    }
}