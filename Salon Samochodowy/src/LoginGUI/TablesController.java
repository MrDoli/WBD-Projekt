package LoginGUI;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.util.ArrayList;


public class TablesController {

    @FXML private Button addButton;
    @FXML private Button cancelButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;

    @FXML private TableView <Car> carsTableView;
    @FXML private TableColumn <Car, Integer> carId;
    @FXML private TableColumn <Car, String> status;
    @FXML private TableColumn <Car, String> naSprzedaz;
    @FXML private TableColumn <Car, String> doJazdyProbnej;
    @FXML private TableColumn <Car, Integer> przebieg;
    @FXML private TableColumn <Car, Integer> netto;
    @FXML private TableColumn <Car, Integer> brutto;
    @FXML private TableColumn <Car, String> model;
    @FXML private TableColumn <Car, String> marka;

    @FXML private TableView<Employee> employeeTableView;
    @FXML private TableColumn<Employee, Integer> employeeId;
    @FXML private TableColumn<Employee, String> imie;
    @FXML private TableColumn<Employee, String> nazwisko;
    @FXML private TableColumn<Employee, String> stanowisko;
    @FXML private TableColumn<Employee, String> numerTel;
    @FXML private TableColumn<Employee, String> dataZatrudnienia;
    @FXML private TableColumn<Employee, String> koniecUmowy;
    @FXML private TableColumn<Employee, String> email;
    @FXML private TableColumn<Employee, String> adres;


    private DBManager dbManager = new DBManager();

    private void getCars(){
        ObservableList<Car> cars = FXCollections.observableArrayList(dbManager.getCars());
        carsTableView.setItems(cars);
    }
    private void getEmployees(){
        ObservableList<Employee> employees = FXCollections.observableArrayList(dbManager.getEmployees());
        employeeTableView.setItems(employees);
    }

    @FXML
    private void initialize() {

        carId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        status.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStatus()));
        naSprzedaz.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNaSprzedaz()));
        doJazdyProbnej.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDoJazdyProbnej()));
        przebieg.setCellValueFactory(cellData -> cellData.getValue().przebiegProperty().asObject());
        netto.setCellValueFactory(cellData -> cellData.getValue().nettoProperty().asObject());
        brutto.setCellValueFactory(cellData -> cellData.getValue().bruttoProperty().asObject());
        model.setCellValueFactory(cellData ->  new ReadOnlyStringWrapper(cellData.getValue().getModel()));
        marka.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMarka()));

        employeeId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        imie.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getImie()));
        nazwisko.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNazwisko()));
        stanowisko.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStanowisko()));
        numerTel.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNumerTel()));
        koniecUmowy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getKoniecUmowy()));
        dataZatrudnienia.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDataZatrudnienia()));
        email.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEmail()));
        adres.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAdres()));


        getCars();
        getEmployees();
    }
}
