package poligoni;

public class GestionePoligoni {
    private PoligonoRegolare[] arrPoligoni;
    private int dimLog;

    public GestionePoligoni(int lun) {
        arrPoligoni = new PoligonoRegolare[lun];
        dimLog = 0;
    }

    public void inserisciPoligono(PoligonoRegolare p1) {
        arrPoligoni[dimLog].setLLati(p1.getLLati());
        arrPoligoni[dimLog].setNLati(p1.getNLati());
        dimLog++;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < dimLog; i++) {
            s += "Poligono " + (i+1) + ":" + arrPoligoni[i].toString();
        }
        return s;
    }
}
