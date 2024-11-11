package model;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType pladstype;

    public Plads(int række, int nr, int pris, PladsType pladstype) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladstype = pladstype;
    }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public PladsType getPladstype() {
        return pladstype;
    }

    @Override
    public String toString() {
        return  "" + række + nr + pris + pladstype;
    }
}


