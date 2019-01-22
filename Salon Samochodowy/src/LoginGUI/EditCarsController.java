package LoginGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class EditCarsController {

    @FXML
    private Button cancel;
    @FXML
    private Button accept;

    @FXML
    private TextField marka;
    @FXML
    private TextField model;
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

    @FXML
    public void edit(String marka, String model, String status, String naSprzedaz, String doJazdyProbnej, Integer przebieg, Integer netto, Integer brutto) {
        this.marka.setText(marka);
        this.model.setText(model);
        this.przebieg.setText(przebieg.toString());
        this.netto.setText(netto.toString());
        this.brutto.setText(brutto.toString());
        if (status.equals("Nowy")) this.status.setValue("Nowy");
        else if (status.equals("Używany") || status.equals("Uzywany")) this.status.setValue("Używany");
        if (naSprzedaz.equals("T")) this.naSprzedaz.setSelected(true);
        else this.naSprzedaz.setSelected(false);
        if (doJazdyProbnej.equals("T")) this.doJazdyProbnej.setSelected(true);
        else this.doJazdyProbnej.setSelected(false);
    }

    @FXML
    private void initialize() {
        ArrayList<String> statusArray = new ArrayList<>();
        statusArray.add("Nowy");
        statusArray.add("Używany");
        ObservableList<String> statusList = FXCollections.observableArrayList(statusArray);
        status.setItems(statusList);
    }
}
