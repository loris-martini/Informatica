package liquidi;

import java.util.Arrays;
import java.util.stream.Stream;

class Deposito {
    private Contenitore[] contenitori;

    public Deposito(Contenitore[] contenitori) throws Exception{
        if(contenitori == null){
            throw new Exception("Contenitori Vuoti!");
        }
        this.contenitori = contenitori;
    }

    public Stream<Contenitore> filtra(Contenitore c) {
        return Arrays.stream(contenitori).filter(contenitore -> contenitore.getPs() < c.getPs());
    }
}