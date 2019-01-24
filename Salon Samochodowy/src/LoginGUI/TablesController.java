package LoginGUI;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;


public class TablesController {

    @FXML
    private Button carAddButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button carEditButton;
    @FXML
    private Button carDeleteButton;
//    @FXML private Button customerAddButton;
//    @FXML private Button customerEditButton;
//    @FXML private Button customerDeleteButton;
//    @FXML private Button employeeAddButton;
//    @FXML private Button employeeEditButton;
//    @FXML private Button employeeDeleteButton;

    @FXML
    private TableView<Car> carsTableView;
    @FXML
    private TableColumn<Car, Integer> carId;
    @FXML
    private TableColumn<Car, String> status;
    @FXML
    private TableColumn<Car, String> naSprzedaz;
    @FXML
    private TableColumn<Car, String> doJazdyProbnej;
    @FXML
    private TableColumn<Car, Integer> przebieg;
    @FXML
    private TableColumn<Car, Integer> netto;
    @FXML
    private TableColumn<Car, Integer> brutto;
    @FXML
    private TableColumn<Car, String> model;
    @FXML
    private TableColumn<Car, String> marka;
    @FXML
    private TableColumn<Car, String> naped;
    @FXML
    private TableColumn<Car, Float> pojemnosc;
    @FXML
    private TableColumn<Car, String> wersjaWyposazenia;
    @FXML
    private TableColumn<Car, Integer> rokProdukcji;

    @FXML
    private TableView<Employee> employeeTableView;
    @FXML
    private TableColumn<Employee, Integer> employeeId;
    @FXML
    private TableColumn<Employee, String> imie;
    @FXML
    private TableColumn<Employee, String> nazwisko;
    @FXML
    private TableColumn<Employee, String> stanowisko;
    @FXML
    private TableColumn<Employee, String> numerTel;
    @FXML
    private TableColumn<Employee, String> dataZatrudnienia;
    @FXML
    private TableColumn<Employee, String> koniecUmowy;
    @FXML
    private TableColumn<Employee, String> email;
    @FXML
    private TableColumn<Employee, String> adres;

    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, Integer> customerId;
    @FXML
    private TableColumn<Customer, String> customerImie;
    @FXML
    private TableColumn<Customer, String> customerNazwisko;
    @FXML
    private TableColumn<Customer, Integer> customerRabat;
    @FXML
    private TableColumn<Customer, String> customerNumerTel;
    @FXML
    private TableColumn<Customer, String> customerEmail;
    @FXML
    private TableColumn<Customer, String> customerPesel;
    @FXML
    private TableColumn<Customer, String> customerAdres;


    private DBManager dbManager = new DBManager();

    private void getCars() {
        ObservableList<Car> cars = FXCollections.observableArrayList(dbManager.getCars());
        carsTableView.setItems(cars);
    }

    @FXML
    private void deleteCar() {
        if (carsTableView.getSelectionModel().getSelectedItems().isEmpty()) return;

        dbManager.deleteCar(carsTableView.getSelectionModel().getSelectedItem().getId());
        getCars();

    }

    private void getEmployees() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(dbManager.getEmployees());
        employeeTableView.setItems(employees);
    }

    @FXML
    private void deleteEmployee() {
        if (employeeTableView.getSelectionModel().getSelectedItems().isEmpty()) return;

        dbManager.deleteEmployee(employeeTableView.getSelectionModel().getSelectedItem().getId());
        getEmployees();
    }

    private void getCustomers() {
        ObservableList<Customer> customers = FXCollections.observableArrayList(dbManager.getCustomers());
        customerTableView.setItems(customers);
    }

    @FXML
    private void deleteCustomer() {
        if (customerTableView.getSelectionModel().getSelectedItems().isEmpty()) return;

        dbManager.deleteCustomer(customerTableView.getSelectionModel().getSelectedItem().getId());
        getCustomers();
    }

    @FXML
    private void openCarEditWindow(ActionEvent event, boolean edit) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditCars.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        EditCarsController editCarsController = loader.getController();
        editCarsController.setDbManager(dbManager);

        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        if (edit) {
            Integer carId = carsTableView.getSelectionModel().getSelectedItem().getId();
            String marka = carsTableView.getSelectionModel().getSelectedItem().getMarka();
            String model = carsTableView.getSelectionModel().getSelectedItem().getModel();
            String rodzajNapedu = carsTableView.getSelectionModel().getSelectedItem().getRodzajNapedu();
            Float pojemnosc = carsTableView.getSelectionModel().getSelectedItem().getPojemnosc();
            String wersjaWyposazenia = carsTableView.getSelectionModel().getSelectedItem().getWersjaWyposazenia();
            Integer rok = carsTableView.getSelectionModel().getSelectedItem().getRok();
            String status = carsTableView.getSelectionModel().getSelectedItem().getStatus();
            String naSprzedaz = carsTableView.getSelectionModel().getSelectedItem().getNaSprzedaz();
            String doJazdyProbnej = carsTableView.getSelectionModel().getSelectedItem().getDoJazdyProbnej();
            Integer przebieg = carsTableView.getSelectionModel().getSelectedItem().getPrzebieg();
            Integer netto = carsTableView.getSelectionModel().getSelectedItem().getNetto();
            Integer brutto = carsTableView.getSelectionModel().getSelectedItem().getBrutto();

            editCarsController.edit(carId, marka, model, rodzajNapedu, pojemnosc, wersjaWyposazenia, rok, status, naSprzedaz, doJazdyProbnej, przebieg, netto, brutto);
        }
        stage.showAndWait();
        getCars();
    }

    @FXML
    private void addCar(ActionEvent event) throws IOException {
        openCarEditWindow(event, false);
    }

    @FXML
    private void editCar(ActionEvent event) throws IOException {
        if (carsTableView.getSelectionModel().getSelectedItems().isEmpty()) return;
        openCarEditWindow(event, true);
    }

    private void openCustomerEditWindow(ActionEvent event, boolean edit) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditCustomers.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        EditCustomersController editCustomersController = loader.getController();
        editCustomersController.setDbManager(dbManager);

        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());

        if(edit){
//            Integer id = customerTableView.getSelectionModel().getSelectedItem().getId();
//            String imie = customerTableView.getSelectionModel().getSelectedItem().getImie();
//            String nazwisko = customerTableView.getSelectionModel().getSelectedItem().getNazwisko();
//            String email = customerTableView.getSelectionModel().getSelectedItem().getEmail();
//            String rabat = customerTableView.getSelectionModel().getSelectedItem().getRabat();
//            String numerTel = customerTableView.getSelectionModel().getSelectedItem().getNumerTel();
//            String pesel = customerTableView.getSelectionModel().getSelectedItem().getPesel();


        }

        stage.showAndWait();
        getCustomers();

    }

    @FXML private void addCustomer(ActionEvent event) throws IOException{
        openCustomerEditWindow(event, false);
    }

    @FXML private void editCustomer(ActionEvent event) throws IOException{
        if(customerTableView.getSelectionModel().getSelectedItems().isEmpty()) return;

        openCustomerEditWindow(event, true);
    }

    @FXML
    private void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
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
        model.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getModel()));
        marka.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMarka()));
        naped.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRodzajNapedu()));
        pojemnosc.setCellValueFactory(cellData -> cellData.getValue().pojemnoscProperty().asObject());
        wersjaWyposazenia.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getWersjaWyposazenia()));
        rokProdukcji.setCellValueFactory(cellData -> cellData.getValue().rokProperty().asObject());

        employeeId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        imie.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getImie()));
        nazwisko.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNazwisko()));
        stanowisko.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStanowisko()));
        numerTel.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNumerTel()));
        koniecUmowy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getKoniecUmowy()));
        dataZatrudnienia.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDataZatrudnienia()));
        email.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEmail()));
        adres.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAdres()));

        customerId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        customerImie.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getImie()));
        customerNazwisko.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNazwisko()));
        customerRabat.setCellValueFactory(cellData -> cellData.getValue().rabatProperty().asObject());
        customerNumerTel.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNumerTel()));
        customerEmail.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEmail()));
        customerPesel.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPesel()));
        customerAdres.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAdres()));

        getCars();
        getEmployees();
        getCustomers();
    }
}
