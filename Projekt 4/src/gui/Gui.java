package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Forestilling;
import model.Kunde;
import storage.Storage;

import java.time.LocalDate;


public class Gui extends Application {
    ListView<Forestilling> forestillingerListView = new ListView<>();
    ListView<Kunde> kunderListView = new ListView<>();
    TextField navnForestillingTXF = new TextField();
    TextField startDatoTXF = new TextField();
    TextField slutDatoTXF = new TextField();
    TextField navnKundeTXF = new TextField();
    TextField tlfNrTXF = new TextField();




    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Gui Demo 1");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    private void initContent(GridPane pane) {
        // enable this to show grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);
        // add a label to the pane (at col=0, row=0)
        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);
        forestillingerListView.getItems().addAll(Storage.getForestillinger());
        pane.add(forestillingerListView, 0 , 1);

        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 2, 0);
        kunderListView.getItems().addAll(Storage.getKunder());
        pane.add(kunderListView, 2, 1);

        Label lblForestillingNavn = new Label("Navn");
        pane.add(lblForestillingNavn, 0, 2);
        pane.add(navnForestillingTXF, 1, 2);
        Label lblStartDato = new Label("Start Dato (yyyy-MM-dd): ");
        pane.add(lblStartDato, 0, 3);
        pane.add(startDatoTXF, 1, 3);
        Label lblSlutDato = new Label("Slut Dato (yyyy-MM-dd)");
        pane.add(lblSlutDato, 0, 4);
        pane.add(slutDatoTXF, 1, 4);

        Label lblKundeNavn = new Label("Navn: ");
        pane.add(lblKundeNavn, 2, 2);
        pane.add(navnKundeTXF, 3, 2);
        Label lblTlfNr = new Label("Telefonnr: ");
        pane.add(lblTlfNr,2, 3);
        pane.add(tlfNrTXF, 3, 3);






        // add a button to the pane (at col=1, row=1)
        Button btnOpretForestilling = new Button("Opret Forestilling");
        pane.add(btnOpretForestilling, 0, 5);
        GridPane.setMargin(btnOpretForestilling, new Insets(10, 10, 0, 10));

        Button btnOpretKunde = new Button("Opret Kunde");
        pane.add(btnOpretKunde, 2, 5);
        GridPane.setMargin(btnOpretKunde, new Insets(10, 10, 0, 10));
        //connect a method to the button
        btnOpretForestilling.setOnAction(event -> this.opretForestilling());
        btnOpretKunde.setOnAction(event -> this.opretKunde());


    }
    public void opretForestilling(){
        String navn = navnForestillingTXF.getText();
        String startDatoString = startDatoTXF.getText();
        String slutDatoString = slutDatoTXF.getText();

        LocalDate startDato = LocalDate.parse(startDatoString);
        LocalDate slutDato = LocalDate.parse(slutDatoString);

        Forestilling nyForestilling = Controller.createForestilling(navn, startDato, slutDato);

        navnForestillingTXF.clear();
        startDatoTXF.clear();
        slutDatoTXF.clear();

        forestillingerListView.getItems().add(nyForestilling);
    }
    public void opretKunde(){
        String navn = navnKundeTXF.getText();
        String tlfNr = tlfNrTXF.getText();

        Kunde nyKunde = Controller.createKunde(navn, tlfNr);

        navnKundeTXF.clear();
        tlfNrTXF.clear();

        kunderListView.getItems().add(nyKunde);
    }





}
