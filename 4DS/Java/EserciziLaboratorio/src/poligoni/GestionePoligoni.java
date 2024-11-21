package poligoni;

public class GestionePoligoni {
    private PoligonoRegolare[] arrPoligoni;
    private int dimLog;

    public GestionePoligoni(int lun) throws Exception{
        if(lun <= 0){
            throw new Exception("Lunghezza errata!");
        }
        arrPoligoni = new PoligonoRegolare[lun];
        dimLog = 0;
    }

    public void inserisciPoligono(PoligonoRegolare p1) throws Exception, NullPointerException{
        if(p1 == null){
            throw new NullPointerException("Oggetto null!");
        }
        arrPoligoni[dimLog] = p1;
        dimLog++;
    }

    public double getLatoPiuLungo() {
        double max = arrPoligoni[0].getLLati();
        for (int i = 1; i < dimLog; i++) {
            if (arrPoligoni[i].getLLati() > max) {
                max = arrPoligoni[i].getLLati();
            }
        }
        return max;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < dimLog; i++) {
            s += "Poligono " + (i+1) + ":" + arrPoligoni[i].toString();
        }
        return s;
    }
}
