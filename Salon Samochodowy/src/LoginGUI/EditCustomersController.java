package LoginGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditCustomersController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField ulica;
    @FXML
    private TextField numerBudynku;
    @FXML
    private TextField numerLokalu;
    @FXML
    private TextField kodPocztowy;
    @FXML
    private TextField miejscowosc;
    @FXML
    private TextField kraj;
    @FXML
    private TextField numerTel;
    @FXML
    private TextField email;
    @FXML
    private TextField pesel;
    @FXML
    private TextField rabat;


    private DBManager dbManager;
    private boolean isEdited;
    private Integer customerId;

    public void setDbManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void edit(Integer consumerId, String imie, String nazwisko, String ulica, String numerBudynku, String numerLokalu, String kodPocztowy, String miejscowosc, String kraj, String numerTel, String email, String pesel, String rabat) {
        this.imie.setText(imie);
        this.nazwisko.setText(nazwisko);
        this.ulica.setText(ulica);
        this.numerBudynku.setText(numerBudynku);
        this.numerLokalu.setText(numerLokalu);
        this.kodPocztowy.setText(kodPocztowy);
        this.miejscowosc.setText(miejscowosc);
        this.kraj.setText(kraj);
        this.pesel.setText(pesel);
        this.rabat.setText(rabat);
        this.numerTel.setText(numerTel);
        this.email.setText(email);

        this.customerId = consumerId;
        isEdited = true;
    }

    @FXML
    private void clickAccept() {
        String imie = this.imie.getText();
        String nazwisko = this.nazwisko.getText();
        String ulica = this.ulica.getText();
        String numerBudynku = this.numerBudynku.getText();
        String numerLokalu = this.numerLokalu.getText();
        String kodPocztowy = this.kodPocztowy.getText();
        String miejscowosc = this.miejscowosc.getText();
        String kraj = this.kraj.getText();
        String numerTel = this.numerTel.getText();
        String email = this.email.getText();
        String pesel = this.pesel.getText();
        String rabat = this.rabat.getText();

        if (!isEdited)
            dbManager.editCustomer(customerId, imie, nazwisko, ulica, numerBudynku, numerLokalu, kodPocztowy, miejscowosc, kraj, numerTel, email, pesel, rabat);
        else
            dbManager.editCustomer(customerId, imie, nazwisko, ulica, numerBudynku, numerLokalu, kodPocztowy, miejscowosc, kraj, numerTel, email, pesel, rabat);

        close();
    }

    @FXML
    private void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        isEdited = false;
        customerId = 0;
    }
}
