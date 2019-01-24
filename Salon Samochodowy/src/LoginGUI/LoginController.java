package LoginGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    @FXML
    private Button administrator = new Button();
    @FXML
    private Button wlascicielSalonu = new Button();
    @FXML
    private Button kierownik = new Button();
    @FXML
    private Button ksiegowa = new Button();
    @FXML
    private Button sprzedawca = new Button();
    @FXML
    private Button klient = new Button();
    @FXML
    private VBox vBox = new VBox();

    private DBManager dbManager = new DBManager();

    public LoginController() {
    }

    private void openTablesWindow(ActionEvent event, boolean isKlient, boolean idAdministrator) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Tables.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        TablesController tablesController = loader.getController();

        stage.setScene(scene);

        tablesController.setDbManager(dbManager);

        if (idAdministrator) {
            tablesController.setOwner(true);
        } else if (isKlient) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Logowanie");
            dialog.setHeaderText("Wpisz swoje ID");
            dialog.setContentText("ID klienta:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                Integer customerId = Integer.parseInt(result.get());
                tablesController.setCustId(customerId);
            } else {
                System.out.print("Error");
            }
        }

        stage.show();
        close();

    }

    @FXML
    private void clickedKlient(ActionEvent event) throws IOException {
        openTablesWindow(event, true, false);
    }

    @FXML
    private void clickedAdministrator(ActionEvent event) throws IOException {
        openTablesWindow(event, false, true);
    }

    private void close() {
        Stage stage = (Stage) administrator.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        kierownik.setDisable(true);
        ksiegowa.setDisable(true);
        sprzedawca.setDisable(true);
        wlascicielSalonu.setDisable(true);

    }

}
