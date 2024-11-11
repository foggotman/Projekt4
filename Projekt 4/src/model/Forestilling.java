package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;

    public Forestilling(String navn, LocalDate slutDato, LocalDate startDato) {
        this.navn = navn;
        this.slutDato = slutDato;
        this.startDato = startDato;
    }

    public void addBestilling(Bestilling bestilling){
        bestillinger.add(bestilling);
    }
    public boolean erPladsLedig(int række,int nr, LocalDate dato){
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato)){
                for (Plads plads : bestilling.getPladser()) {
                    if (plads.getRække() == række && plads.getNr() == nr) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Bestilling createBestilling(LocalDate bestillingsNr){
        Bestilling bestilling = new Bestilling(bestillingsNr);
        bestillinger.add(bestilling);
        return bestilling;
    }

    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();


    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    @Override
    public String toString() {
        return navn + ", " + startDato + " - " + slutDato + ", " + bestillinger;
    }
}
