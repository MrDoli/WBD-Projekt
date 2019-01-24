package LoginGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SearchCarsController {
    @FXML
    private Button cancel;
    @FXML
    private Button accept;

    @FXML
    private TextField marka;
    @FXML
    private TextField model;
    @FXML
    private TextField rodzajNapedu;
    @FXML
    private TextField pojemnosc;
    @FXML
    private TextField rok;
    @FXML
    private ChoiceBox<String> status;
    @FXML
    private ChoiceBox<String> naSprzedaz;
    @FXML
    private ChoiceBox<String> doJazdyProbnej;


    @FXML
    private void close() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickAccept(ActionEvent event) {
        close();
    }

    public Car getCars() {
        Car car = new Car(0,"%", "%", "%", 0, 0, 0, "%", "%", "%", (float) 0.0, "%", 0);
        if (!marka.getText().isEmpty()) car.setMarka(marka.getText());
       // else car.setMarka("%");
        if (!model.getText().isEmpty()) car.setModel(model.getText());
        //else car.setModel("%");
        if (!rodzajNapedu.getText().isEmpty()) car.setRodzajNapedu(rodzajNapedu.getText());
        //else car.setRodzajNapedu("%");
        if (!pojemnosc.getText().isEmpty()) car.setPojemnosc(Float.parseFloat(pojemnosc.getText()));
        //else car.setPojemnosc(-1);
        if (!rok.getText().isEmpty()) car.setRok(Integer.parseInt(rok.getText()));
        //else car.setRok(-1);
        if (!status.getSelectionModel().isEmpty()) car.setStatus(status.getValue());
        //else car.setStatus("%");
        if (!naSprzedaz.getSelectionModel().isEmpty()) car.setNaSprzedaz(naSprzedaz.getValue());
        //else car.setNaSprzedaz("%");
        if (!doJazdyProbnej.getSelectionModel().isEmpty()) car.setDoJazdyProbnej(doJazdyProbnej.getValue());
        //else car.setDoJazdyProbnej("%");

        return car;
    }

    @FXML
    private void initialize() {
        ArrayList<String> statusArray = new ArrayList<>();
        statusArray.add("Nowy");
        statusArray.add("Używany");
        ObservableList<String> statusList = FXCollections.observableArrayList(statusArray);
        status.setItems(statusList);

        ArrayList<String> naSprzedazArray = new ArrayList<>();
        naSprzedazArray.add("T");
        naSprzedazArray.add("N");
        ObservableList<String> naSprzedazList = FXCollections.observableArrayList(naSprzedazArray);
        naSprzedaz.setItems(naSprzedazList);

        ArrayList<String> doJazdyProbnejArray = new ArrayList<>();
        doJazdyProbnejArray.add("T");
        doJazdyProbnejArray.add("N");
        ObservableList<String> doJazdyProbnejList = FXCollections.observableArrayList(doJazdyProbnejArray);
        doJazdyProbnej.setItems(doJazdyProbnejList);

    }
}
