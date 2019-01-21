package LoginGUI;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    Connection connection;
    private PreparedStatement selectCarStatement;
    private PreparedStatement insertCarStatement;
    private PreparedStatement selectBrand_ModelStatement;
    private PreparedStatement insertBrand_ModelStatement;
    private PreparedStatement selectEmployeeStatement;
    private PreparedStatement insertEmployeeStatement;
    private PreparedStatement selectCustomerStatement;
    private PreparedStatement selectAddressStatement;
    private PreparedStatement insertAddressStatement;
    private PreparedStatement selectShowroom_CarStatement;
    private PreparedStatement insertShowroom_CarStatement;
    private PreparedStatement selectPayStatement;
    private PreparedStatement insertPayStatement;

    public DBManager(){
        try {
            connection = DBConnection.connectToDB();
            selectCarStatement = connection.prepareStatement("select * from \"Samochody\"");
            selectBrand_ModelStatement = connection.prepareStatement("select * from \"Marki_modeli\" where \"ID_marki_modelu\" = ?");
            selectAddressStatement = connection.prepareStatement("select * from \"Adresy\" where \"ID_adresu\" = ?");
            selectEmployeeStatement = connection.prepareStatement("select * from \"Pracownicy\"");
            selectCustomerStatement = connection.prepareStatement("select * from \"Klienci\"");
            //insertCarStatement  = connection.prepareStatement("insert into pacjenci (id, status, nas) values(?,?,?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Car> getCars(){
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = selectCarStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String status = rs.getString(2);
                String naSprzedaz = rs.getString(3);
                String doJazdyProbnej = rs.getString(4);
                Integer przebieg = rs.getInt(5);
                Integer netto = rs.getInt(6);
                Integer brutto = rs.getInt(7);
                Integer idModelu = rs.getInt(8);
                selectBrand_ModelStatement.setInt(1,idModelu);
                ResultSet rs2 = selectBrand_ModelStatement.executeQuery();
                String model = "";
                String marka = "";
                while(rs2.next()){
                    model = rs2.getString(2);
                    marka = rs2.getString(3);
                }
                cars.add(new Car(id,status,naSprzedaz,doJazdyProbnej,przebieg,netto,brutto,idModelu, marka, model));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cars;
    }
    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            ResultSet rs = selectEmployeeStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String imie = rs.getString(2);
                String nazwisko = rs.getString(3);
                String stanowisko = rs.getString(4);
                String numerTel = rs.getString(5);
                String koniecUmowy = rs.getString(6);
                String dataZatrudnienia = rs.getString(7);
                String email = rs.getString(8);
                Integer idAdresu = rs.getInt(10);
                selectAddressStatement.setInt(1,idAdresu);
                ResultSet rs2 = selectAddressStatement.executeQuery();
                String ulica = "";
                String miejscowosc = "";
                String kod = "";
                String kraj = "";
                Integer nrBudynku = 0;
                Integer nrLokalu = 0;
                while(rs2.next()){
                    ulica = rs2.getString(2);
                    nrBudynku = rs2.getInt(3);
                    nrLokalu = rs2.getInt(4);
                    kod = rs2.getString(5);
                    miejscowosc = rs2.getString(6);
                    kraj = rs2.getString(7);
                }
                String adres = ulica+' '+nrBudynku+'/'+nrLokalu+' '+kod+' '+miejscowosc+' '+kraj;
                employees.add(new Employee(id,imie,nazwisko,stanowisko,numerTel,koniecUmowy,dataZatrudnienia,email,adres));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }
    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet rs = selectCustomerStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String imie = rs.getString(2);
                String nazwisko = rs.getString(3);
                Integer rabat = rs.getInt(4);
                String numerTel = rs.getString(5);
                String email = rs.getString(6);
                String pesel = rs.getString(7);
                Integer idAdresu = rs.getInt(8);
                selectAddressStatement.setInt(1,idAdresu);
                ResultSet rs2 = selectAddressStatement.executeQuery();
                String ulica = "";
                String miejscowosc = "";
                String kod = "";
                String kraj = "";
                Integer nrBudynku = 0;
                Integer nrLokalu = 0;
                while(rs2.next()){
                    ulica = rs2.getString(2);
                    nrBudynku = rs2.getInt(3);
                    nrLokalu = rs2.getInt(4);
                    kod = rs2.getString(5);
                    miejscowosc = rs2.getString(6);
                    kraj = rs2.getString(7);
                }
                String adres = ulica+' '+nrBudynku+'/'+nrLokalu+' '+kod+' '+miejscowosc+' '+kraj;
                customers.add(new Customer(id,imie,nazwisko,rabat,numerTel,email,pesel,adres));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

}
