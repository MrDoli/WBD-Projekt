package LoginGUI;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public DBManager() {
        connection = DBConnection.connectToDB();

    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement selectCarStatement;
            PreparedStatement selectBrand_ModelStatement;
            PreparedStatement selectModelStatement;

            selectCarStatement = connection.prepareStatement("select * from \"Samochody\"");
            selectBrand_ModelStatement = connection.prepareStatement("select * from \"Marki_modeli\" where \"ID_marki_modelu\" = ?");
            selectModelStatement = connection.prepareStatement("select * from \"Modele\" where \"ID_modelu\" = ?");

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
                selectModelStatement.setInt(1, idModelu);
                ResultSet rs2 = selectModelStatement.executeQuery();
                rs2.next();
                String naped = rs2.getString(2);
                Float pojemnosc = rs2.getFloat(3);
                String wersjaWyposazenia = rs2.getString(4);
                Integer rok = rs2.getInt(5);
                Integer idMarkiModelu = rs2.getInt(6);
                selectBrand_ModelStatement.setInt(1, idMarkiModelu);
                rs2 = selectBrand_ModelStatement.executeQuery();
                String model = "";
                String marka = "";
                while (rs2.next()) {
                    model = rs2.getString(2);
                    marka = rs2.getString(3);
                }
                cars.add(new Car(id, status, naSprzedaz, doJazdyProbnej, przebieg, netto, brutto, marka, model, naped, pojemnosc, wersjaWyposazenia, rok));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void deleteCar(Integer id){
        try{
            PreparedStatement ps = connection.prepareStatement("delete from \"Salony_Samochodowe_Samochody\" where \"ID_Samochodu\" = ?");
            PreparedStatement deleteCarStatement = connection.prepareStatement("delete from \"Samochody\" where \"ID_Samochodu\" = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            deleteCarStatement.setInt(1,id);
            deleteCarStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement selectAddressStatement;
            PreparedStatement selectEmployeeStatement;

            selectEmployeeStatement = connection.prepareStatement("select * from \"Pracownicy\"");
            selectAddressStatement = connection.prepareStatement("select * from \"Adresy\" where \"ID_adresu\" = ?");
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
                selectAddressStatement.setInt(1, idAdresu);
                ResultSet rs2 = selectAddressStatement.executeQuery();
                String ulica = "";
                String miejscowosc = "";
                String kod = "";
                String kraj = "";
                Integer nrBudynku = 0;
                Integer nrLokalu = 0;
                while (rs2.next()) {
                    ulica = rs2.getString(2);
                    nrBudynku = rs2.getInt(3);
                    nrLokalu = rs2.getInt(4);
                    kod = rs2.getString(5);
                    miejscowosc = rs2.getString(6);
                    kraj = rs2.getString(7);
                }
                String adres = ulica + ' ' + nrBudynku + '/' + nrLokalu + ' ' + kod + ' ' + miejscowosc + ' ' + kraj;
                employees.add(new Employee(id, imie, nazwisko, stanowisko, numerTel, koniecUmowy, dataZatrudnienia, email, adres));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement selectAddressStatement;
            PreparedStatement selectCustomerStatement;

            selectCustomerStatement = connection.prepareStatement("select * from \"Klienci\"");
            selectAddressStatement = connection.prepareStatement("select * from \"Adresy\" where \"ID_adresu\" = ?");
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
                selectAddressStatement.setInt(1, idAdresu);
                ResultSet rs2 = selectAddressStatement.executeQuery();
                String ulica = "";
                String miejscowosc = "";
                String kod = "";
                String kraj = "";
                Integer nrBudynku = 0;
                Integer nrLokalu = 0;
                while (rs2.next()) {
                    ulica = rs2.getString(2);
                    nrBudynku = rs2.getInt(3);
                    nrLokalu = rs2.getInt(4);
                    kod = rs2.getString(5);
                    miejscowosc = rs2.getString(6);
                    kraj = rs2.getString(7);
                }
                String adres = ulica + ' ' + nrBudynku + '/' + nrLokalu + ' ' + kod + ' ' + miejscowosc + ' ' + kraj;
                customers.add(new Customer(id, imie, nazwisko, rabat, numerTel, email, pesel, adres));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


}
