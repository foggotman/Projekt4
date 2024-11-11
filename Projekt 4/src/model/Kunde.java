package model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public void addKunde(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
            bestilling.setKunde(this);
        }
    }

    public void removeKunde(Bestilling bestilling) {
        if (bestillinger.contains(bestilling)) {
            bestillinger.remove(bestilling);
            bestilling.setKunde(null);
        }
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    @Override
    public String toString() {
        return navn + ", " + mobil + ", " + bestillinger + "\n";
    }
}

