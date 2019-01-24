package LoginGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EditCarsController {

    @FXML
    private Button cancel;
    @FXML
    private Button accept;

    @FXML
    private ComboBox<String> marka;
    @FXML
    private ComboBox<String> model;
    @FXML
    private ComboBox<String> rodzajNapedu;
    @FXML
    private ComboBox<String> pojemnosc;
    @FXML
    private ComboBox<String> wersjaWyposazenia;
    @FXML
    private ComboBox<String> rok;
    @FXML
    private ChoiceBox<String> status;
    @FXML
    private CheckBox naSprzedaz;
    @FXML
    private CheckBox doJazdyProbnej;
    @FXML
    private TextField przebieg;
    @FXML
    private TextField netto;
    @FXML
    private TextField brutto;

    private Integer carId;
    private DBManager dbManager;
    private boolean isEdited;

    public void setDbManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @FXML
    public void edit(Integer carId, String marka, String model, String rodzajNapedu, Float pojemnosc, String wersjaWyposazenia, Integer rok, String status, String naSprzedaz, String doJazdyProbnej, Integer przebieg, Integer netto, Integer brutto) {
        this.marka.getSelectionModel().select(marka);
        this.model.getSelectionModel().select(model);
        this.rodzajNapedu.getSelectionModel().select(rodzajNapedu);
        this.pojemnosc.getSelectionModel().select(pojemnosc.toString());
        this.wersjaWyposazenia.getSelectionModel().select(wersjaWyposazenia);
        this.rok.getSelectionModel().select(rok.toString());
        if (status.toUpperCase().equals("NOWY")) this.status.getSelectionModel().select(0);
        else this.status.getSelectionModel().select(1);
        this.przebieg.setText(przebieg.toString());
        this.netto.setText(netto.toString());
        this.brutto.setText(brutto.toString());
        if (naSprzedaz.equals("T")) this.naSprzedaz.setSelected(true);
        else this.naSprzedaz.setSelected(false);
        if (doJazdyProbnej.equals("T")) this.doJazdyProbnej.setSelected(true);
        else this.doJazdyProbnej.setSelected(false);
        this.carId =carId;
        isEdited = true;
    }

    @FXML
    private void clickAccept(ActionEvent event) {
        String marka = this.marka.getValue();
        String model = this.model.getValue();
        String rodzajNapedu = this.rodzajNapedu.getValue();
        Float pojemnosc = Float.parseFloat(this.pojemnosc.getValue());
        String wersjaWyposazenia = this.wersjaWyposazenia.getValue();
        Integer rok = Integer.parseInt(this.rok.getValue());
        String status = this.status.getValue();
        String naSprzedaz;
        if (this.naSprzedaz.isSelected()) naSprzedaz = "T";
        else naSprzedaz = "N";
        String doJazdyProbnej;
        if (this.doJazdyProbnej.isSelected()) doJazdyProbnej = "T";
        else doJazdyProbnej = "N";
        Integer przebieg = Integer.parseInt(this.przebieg.getText());
        Integer netto = Integer.parseInt(this.netto.getText());
        Integer brutto = Integer.parseInt(this.brutto.getText());

        if(!isEdited)dbManager.editCar(0,marka, model, rodzajNapedu, pojemnosc, wersjaWyposazenia, rok, status, naSprzedaz, doJazdyProbnej, przebieg, netto, brutto);
        else dbManager.editCar(this.carId,marka, model, rodzajNapedu, pojemnosc, wersjaWyposazenia, rok, status, naSprzedaz, doJazdyProbnej, przebieg, netto, brutto);
        close();
    }

    @FXML
    private void close() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        isEdited = false;
        carId = 0;
        ArrayList<String> statusArray = new ArrayList<>();
        statusArray.add("Nowy");
        statusArray.add("Używany");
        ObservableList<String> statusList = FXCollections.observableArrayList(statusArray);
        status.setItems(statusList);

    }
}
