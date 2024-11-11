package gui;
import javafx.application.Application;
import model.Forestilling;
import controller.Controller;
import model.Plads;
import model.PladsType;
import storage.Storage;


import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }
    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Forestilling evita = Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Forestilling lykkePer = Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Forestilling chess = Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        Plads pladsA = Controller.createPlads(1, 2, 500, PladsType.STANDARD);

        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");





        System.out.println(Storage.getKunder());
    }
}
