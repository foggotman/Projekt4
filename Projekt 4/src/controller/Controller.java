package controller;

import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Forestilling createForestilling(String navn, LocalDate slutDato, LocalDate startDato) {
        Forestilling forestilling = new Forestilling(navn, slutDato, startDato);
        Storage.addForestilling(forestilling);
        return forestilling;
    }
    public static ArrayList<Forestilling> getForestillinger(){
        return Storage.getForestillinger();
    }

    public static Kunde createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);
        return kunde;
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladstype){
        Plads plads = new Plads(række, nr, pris, pladstype);
        Storage.addPlads(plads);
        return plads;
    }
}
