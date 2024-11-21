package aerodromo;
import java.util.Objects;

public abstract class Aeromobile implements CMP {
    private String sigla;

    public Aeromobile(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public boolean superiore(CMP x) {
        if (x == null || getClass() != x.getClass()) {
            return false;
        }
        Aeromobile altroAeromobile = (Aeromobile) x;
        return confrontaPrestazioni(altroAeromobile);
    }

    protected abstract boolean confrontaPrestazioni(Aeromobile altroAeromobile);

    @Override
    public boolean equals(Object o) {
        boolean ret = false;
        if (o instanceof Aeromobile){
            if(((Aeromobile) o).sigla.equals(sigla)){
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigla);
    }

    @Override
    public String toString() {
        return "Aeromobile{" +
                "sigla='" + sigla + '\'' +
                '}';
    }
}