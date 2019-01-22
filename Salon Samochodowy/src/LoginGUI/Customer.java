package LoginGUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
    private SimpleIntegerProperty id;
    private SimpleStringProperty imie;
    private SimpleStringProperty nazwisko;
    private SimpleIntegerProperty rabat;
    private SimpleStringProperty numerTel;
    private SimpleStringProperty email;
    private SimpleStringProperty pesel;
    private SimpleStringProperty adres;

    public Customer(Integer id, String imie, String nazwisko, Integer rabat, String numerTel, String email, String pesel, String adres) {
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.rabat = new SimpleIntegerProperty(rabat);
        this.numerTel = new SimpleStringProperty(numerTel);
        this.email = new SimpleStringProperty(email);
        this.pesel = new SimpleStringProperty(pesel);
        this.adres = new SimpleStringProperty(adres);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getImie() {
        return imie.get();
    }

    public SimpleStringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public SimpleStringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public int getRabat() {
        return rabat.get();
    }

    public SimpleIntegerProperty rabatProperty() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat.set(rabat);
    }

    public String getNumerTel() {
        return numerTel.get();
    }

    public SimpleStringProperty numerTelProperty() {
        return numerTel;
    }

    public void setNumerTel(String numerTel) {
        this.numerTel.set(numerTel);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPesel() {
        return pesel.get();
    }

    public SimpleStringProperty peselProperty() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }

    public String getAdres() {
        return adres.get();
    }

    public SimpleStringProperty adresProperty() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }
}
