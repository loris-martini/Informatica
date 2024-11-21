package aerodromo;
import java.util.Objects;

public class Aliante extends Aeromobile {
    private int efficienzaAereodinamica;

    public Aliante(String sigla, int efficienzaAereodinamica) {
        super(sigla);
        this.efficienzaAereodinamica = efficienzaAereodinamica;
    }

    public int getEfficienzaAereodinamica() {
        return efficienzaAereodinamica;
    }

    @Override
    protected boolean confrontaPrestazioni(Aeromobile altroAeromobile) {
        Aliante altroAliante = (Aliante) altroAeromobile;
        return this.efficienzaAereodinamica > altroAliante.efficienzaAereodinamica;
    }

    @Override
    public boolean equals(Object o) {
        boolean ret = false;
        if (o instanceof Aliante){
            Aliante aliante = (Aliante) o;
            if(super.equals(o) && efficienzaAereodinamica == aliante.efficienzaAereodinamica){
                ret = true;
            }
        }
        return ret;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), efficienzaAereodinamica);
    }

    @Override
    public String toString() {
        return "Aliante{" +
                "sigla='" + getSigla() + '\'' +
                ", efficienzaAereodinamica=" + efficienzaAereodinamica +
                '}';
    }
}