package LoginGUI;


import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Car {
    private SimpleIntegerProperty id;
    private SimpleStringProperty model;
    private SimpleStringProperty marka;
    private SimpleStringProperty rodzajNapedu;
    private SimpleFloatProperty pojemnosc;
    private SimpleStringProperty wersjaWyposazenia;
    private SimpleIntegerProperty rok;
    private SimpleStringProperty status;
    private SimpleStringProperty naSprzedaz;
    private SimpleStringProperty doJazdyProbnej;
    private SimpleIntegerProperty przebieg;
    private SimpleIntegerProperty netto;
    private SimpleIntegerProperty brutto;

    public Car(){

    }

    public Car(Integer id, String status, String naSprzedaz, String doJazdyProbnej, Integer przebieg, Integer netto, Integer brutto, String marka, String model, String rodzajNapedu, Float pojemnosc, String wersjaWyposazenia, Integer rok) {
        this.id = new SimpleIntegerProperty(id);
        this.status = new SimpleStringProperty(status);
        this.naSprzedaz = new SimpleStringProperty(naSprzedaz);
        this.doJazdyProbnej = new SimpleStringProperty(doJazdyProbnej);
        this.przebieg = new SimpleIntegerProperty(przebieg);
        this.netto = new SimpleIntegerProperty(netto);
        this.brutto = new SimpleIntegerProperty(brutto);
        this.model = new SimpleStringProperty(model);
        this.marka = new SimpleStringProperty(marka);
        this.rodzajNapedu = new SimpleStringProperty(rodzajNapedu);
        this.pojemnosc = new SimpleFloatProperty(pojemnosc);
        this.wersjaWyposazenia = new SimpleStringProperty(wersjaWyposazenia);
        this.rok = new SimpleIntegerProperty(rok);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }


    public int getPrzebieg() {
        return przebieg.get();
    }

    public SimpleIntegerProperty przebiegProperty() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg.set(przebieg);
    }

    public int getNetto() {
        return netto.get();
    }

    public SimpleIntegerProperty nettoProperty() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto.set(netto);
    }

    public int getBrutto() {
        return brutto.get();
    }

    public SimpleIntegerProperty bruttoProperty() {
        return brutto;
    }

    public void setBrutto(int brutto) {
        this.brutto.set(brutto);
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

    public String getNaSprzedaz() {
        return naSprzedaz.get();
    }

    public SimpleStringProperty naSprzedazProperty() {
        return naSprzedaz;
    }

    public void setNaSprzedaz(String naSprzedaz) {
        this.naSprzedaz.set(naSprzedaz);
    }

    public String getDoJazdyProbnej() {
        return doJazdyProbnej.get();
    }

    public SimpleStringProperty doJazdyProbnejProperty() {
        return doJazdyProbnej;
    }

    public void setDoJazdyProbnej(String doJazdyProbnej) {
        this.doJazdyProbnej.set(doJazdyProbnej);
    }

    public String getMarka() {
        return marka.get();
    }

    public SimpleStringProperty markaProperty() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka.set(marka);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getRodzajNapedu() {
        return rodzajNapedu.get();
    }

    public SimpleStringProperty rodzajNapeduProperty() {
        return rodzajNapedu;
    }

    public void setRodzajNapedu(String rodzajNapedu) {
        this.rodzajNapedu.set(rodzajNapedu);
    }

    public float getPojemnosc() {
        return pojemnosc.get();
    }

    public SimpleFloatProperty pojemnoscProperty() {
        return pojemnosc;
    }

    public void setPojemnosc(float pojemnosc) {
        this.pojemnosc.set(pojemnosc);
    }

    public String getWersjaWyposazenia() {
        return wersjaWyposazenia.get();
    }

    public SimpleStringProperty wersjaWyposazeniaProperty() {
        return wersjaWyposazenia;
    }

    public void setWersjaWyposazenia(String wersjaWyposazenia) {
        this.wersjaWyposazenia.set(wersjaWyposazenia);
    }

    public int getRok() {
        return rok.get();
    }

    public SimpleIntegerProperty rokProperty() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok.set(rok);
    }
}
