import model.Forestilling;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Forestilling forestilling1 = new Forestilling("Batman", LocalDate.now(), LocalDate.now());
        forestilling1.createBestilling(LocalDate.now());

    }
}