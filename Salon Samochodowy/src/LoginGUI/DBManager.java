package LoginGUI;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;


public class DBManager {

    private static final int SALON = 1;
    private static final int FABRYKA = 1;

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

    public void addCar(String marka, String model, String rodzajNapedu, Float pojemnosc, String wersjaWyposazenia, Integer rok, String status, String naSprzedaz, String doJazdyProbnej, Integer przebieg, Integer netto, Integer brutto) {
        try {
            PreparedStatement selectNewMarkaModelu = connection.prepareStatement("select max(\"ID_marki_modelu\") from \"Marki_modeli\"");
            PreparedStatement selectNewModel = connection.prepareStatement("select max(\"ID_modelu\") from \"Modele\"");
            PreparedStatement selectMarkaModelu = connection.prepareStatement("select \"ID_marki_modelu\" from \"Marki_modeli\" where \"Model\" = ? and \"Marka\" = ?");
            PreparedStatement insertMarkaModelu = connection.prepareStatement("insert into \"Marki_modeli\" values (\"Marki_modeli_SEQ\".nextval, ?, ?)");
            PreparedStatement selectModel = connection.prepareStatement("select \"ID_modelu\" from \"Modele\" where \"Rodzaj_napedu\"=? and \"Pojemnosc_silnika\"=? and \"Wersja_wyposazenia\"=? and \"Rok_produkcji\"=? and \"ID_marki_modelu\"=?");
            PreparedStatement insertModel = connection.prepareStatement("insert into \"Modele\" values (\"Modele_SEQ\".nextval, ?, ?, ?, ?, ?, ?)");
            PreparedStatement insertCar = connection.prepareStatement("insert into \"Samochody\" values (\"Samochody_SEQ\".nextval, ?, ?, ?, ?, ?, ?, ?)");

            insertCar.setString(1, status);
            insertCar.setString(2, naSprzedaz);
            insertCar.setString(3, doJazdyProbnej);
            insertCar.setInt(4, przebieg);
            insertCar.setInt(5, netto);
            insertCar.setInt(6, brutto);

            insertModel.setString(1,rodzajNapedu);
            insertModel.setFloat(2,pojemnosc);
            insertModel.setString(3,wersjaWyposazenia);
            insertModel.setInt(4,rok);
            insertModel.setInt(6,FABRYKA);

            selectMarkaModelu.setString(1, model);
            selectMarkaModelu.setString(2, marka);
            ResultSet rs = selectMarkaModelu.executeQuery();
            Integer idModelu;
            Integer idMarkiModelu;
            if (rs.next()) {
                idMarkiModelu = rs.getInt(1);
                selectModel.setString(1, rodzajNapedu);
                selectModel.setFloat(2, pojemnosc);
                selectModel.setString(3, wersjaWyposazenia);
                selectModel.setInt(4, rok);
                selectModel.setInt(5, idMarkiModelu);
                ResultSet rs2 = selectModel.executeQuery();
                if (rs2.next()) {
                    idModelu = rs2.getInt(1);
                }else {
                    insertModel.setInt(5,idMarkiModelu);
                    insertModel.executeUpdate();
                    ResultSet rs3 = selectNewModel.executeQuery();
                    rs3.next();
                    idModelu = rs3.getInt(1);
                }
            } else {
                insertMarkaModelu.setString(1,model);
                insertMarkaModelu.setString(2,marka);
                insertMarkaModelu.executeUpdate();
                ResultSet rs4 = selectMarkaModelu.executeQuery();
                rs4.next();
                idMarkiModelu = rs4.getInt(1);
                insertModel.setInt(5,idMarkiModelu);
                insertModel.executeUpdate();
                rs4 = selectNewModel.executeQuery();
                idModelu = rs4.getInt(1);
            }
            insertCar.setInt(7,idModelu);
            insertCar.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from \"Salony_Samochodowe_Samochody\" where \"ID_Samochodu\" = ?");
            PreparedStatement deleteCarStatement = connection.prepareStatement("delete from \"Samochody\" where \"ID_Samochodu\" = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            deleteCarStatement.setInt(1, id);
            deleteCarStatement.executeUpdate();

        } catch (SQLException e) {
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
