package Lista;

import java.util.ArrayList;
import java.util.Collections;

class Automobile extends MezzoDiTrasporto {
    private ArrayList<Persona> passeggeri;

    public Automobile() {
        super();
        this.passeggeri = new ArrayList<>();
    }

    public Automobile(Integer cavalli, String marca) {
        super(cavalli, marca);
        this.passeggeri = new ArrayList<>();
    }

    public ArrayList<Persona> getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(ArrayList<Persona> passeggeri) {
        this.passeggeri = passeggeri;
    }

    public void aggiungiPasseggero(Persona passeggero) throws Exception{
        if (passeggeri.size() < 4) {
            passeggeri.add(passeggero);
        } else {
            throw new Exception("Massimo 4 passeggeri consentiti.");
        }
    }

    public void rimuoviUltimoPasseggero() {
        if (!passeggeri.isEmpty()) {
            passeggeri.remove(passeggeri.size() - 1);
        }
    }

    public void rimuoviPasseggero(Persona passeggero) {
        passeggeri.remove(passeggero);
    }

    public void ordinaPasseggeriCrescente() {
        Collections.sort(passeggeri, (p1, p2) -> p1.toString().compareToIgnoreCase(p2.toString()));
    }

    public void ordinaPasseggeriDecrescente() {
        Collections.sort(passeggeri, (p1, p2) -> p2.toString().compareToIgnoreCase(p1.toString()));
    }

    @Override
    public String toString() {
        return super.info() + "\nPasseggeri: " + passeggeri.toString();
    }
}