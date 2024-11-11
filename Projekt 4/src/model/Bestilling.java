package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public ArrayList<Plads> getPladser() {
        return pladser;
    }

    public void addPlads(Plads plads){
        pladser.add(plads);
    }

    public void removePlads(Plads plads){
        pladser.remove(plads);
    }

    public Bestilling(LocalDate dato) {
        this.dato = dato;
    }

    public LocalDate getDato() {
        return dato;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        if (this.kunde != kunde) {
            Kunde oldKunde = this.kunde;
            if (oldKunde != null) {
                oldKunde.removeKunde(this);
            }
            this.kunde = kunde;
            if (kunde != null) {
                kunde.addKunde(this);
            }
        }
    }

}
