package LoginGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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


    // TODO Edit do usuniecia na moje
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

    //to dajesz na onAction w pliku xml dla buttona accept i
    @FXML
    private void clickAccept(ActionEvent event) {


        marka.getText(); // tak pobierasz zmienne z textfield-ow (mozesz je sobie do czegos przypisac jak tam wolisz zalezy co dalej chcesz robic)

        // de facto mozesz wrzucic to co masz u góry ale zamienic setText na getText

        // potem przekazujesz to do bazy danych

        // TODO funkcja do wysylania do bazy danych np sendData()

        // potem robisz repaint glownego okna (pobierasz jeszcze raz dane z bazy i je wyswietlasz) - tak jak przy usuwania bo mowiles ze tam ci dziala
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
