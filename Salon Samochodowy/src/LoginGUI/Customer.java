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
    private SimpleStringProperty ulica;
    private SimpleIntegerProperty numerBudynku;
    private SimpleIntegerProperty numerLokalu;
    private SimpleStringProperty kodPocztowy;
    private SimpleStringProperty miejscowosc;
    private SimpleStringProperty kraj;
    private SimpleStringProperty adres;

    public Customer(Integer id, String imie, String nazwisko, Integer rabat, String numerTel, String email, String pesel, String ulica, Integer numerBudynku, Integer numerLokalu, String kodPocztowy, String miejscowosc, String kraj, String adres) {
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.rabat = new SimpleIntegerProperty(rabat);
        this.numerTel = new SimpleStringProperty(numerTel);
        this.email = new SimpleStringProperty(email);
        this.pesel = new SimpleStringProperty(pesel);
        this.ulica = new SimpleStringProperty(ulica);
        this.numerBudynku = new SimpleIntegerProperty(numerBudynku);
        this.numerLokalu = new SimpleIntegerProperty(numerLokalu);
        this.kodPocztowy = new SimpleStringProperty(kodPocztowy);
        this.miejscowosc = new SimpleStringProperty(miejscowosc);
        this.kraj = new SimpleStringProperty(kraj);
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

    public String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public Integer getNumerBudynku() {
        return numerBudynku.get();
    }

    public SimpleIntegerProperty numerBudynkuProperty() {
        return numerBudynku;
    }

    public void setNumerBudynku(Integer numerBudynku) {
        this.numerBudynku.set(numerBudynku);
    }

    public int getNumerLokalu() {
        return numerLokalu.get();
    }

    public SimpleIntegerProperty numerLokaluProperty() {
        return numerLokalu;
    }

    public void setNumerLokalu(Integer numerLokalu) {
        this.numerLokalu.set(numerLokalu);
    }

    public String getKodPocztowy() {
        return kodPocztowy.get();
    }

    public SimpleStringProperty kodPocztowyProperty() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy.set(kodPocztowy);
    }

    public String getMiejscowosc() {
        return miejscowosc.get();
    }

    public SimpleStringProperty miejscowoscProperty() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc.set(miejscowosc);
    }

    public String getKraj() {
        return kraj.get();
    }

    public SimpleStringProperty krajProperty() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj.set(kraj);
    }
}
