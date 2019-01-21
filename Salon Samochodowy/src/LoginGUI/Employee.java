package LoginGUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
    private SimpleIntegerProperty id;
    private SimpleStringProperty imie;
    private SimpleStringProperty nazwisko;
    private SimpleStringProperty stanowisko;
    private SimpleStringProperty numerTel;
    private SimpleStringProperty koniecUmowy;
    private SimpleStringProperty dataZatrudnienia;
    private SimpleStringProperty email;
    private SimpleStringProperty adres;

    public Employee(Integer id, String imie, String nazwisko, String stanowisko, String numerTel, String koniecUmowy, String dataZatrudnienia, String email, String adres){
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.stanowisko = new SimpleStringProperty(stanowisko);
        this.numerTel = new SimpleStringProperty(numerTel);
        this.koniecUmowy = new SimpleStringProperty(koniecUmowy);
        this.dataZatrudnienia = new SimpleStringProperty(dataZatrudnienia);
        this.email = new SimpleStringProperty(email);
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

    public String getStanowisko() {
        return stanowisko.get();
    }

    public SimpleStringProperty stanowiskoProperty() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko.set(stanowisko);
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

    public String getKoniecUmowy() {
        return koniecUmowy.get();
    }

    public SimpleStringProperty koniecUmowyProperty() {
        return koniecUmowy;
    }

    public void setKoniecUmowy(String koniecUmowy) {
        this.koniecUmowy.set(koniecUmowy);
    }

    public String getDataZatrudnienia() {
        return dataZatrudnienia.get();
    }

    public SimpleStringProperty dataZatrudnieniaProperty() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(String dataZatrudnienia) {
        this.dataZatrudnienia.set(dataZatrudnienia);
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
