/*
Created: 2018-12-12
Modified: 2018-12-15
Model: Logical model
Database: Oracle 11g Release 2
*/


-- Create tables section -------------------------------------------------

-- Table Salony_Samochodowe

CREATE TABLE "Salony_Samochodowe"(
  "ID_Salonu" Integer NOT NULL,
  "Data_zalozenia" Date NOT NULL,
  "Powierzchnia" Integer NOT NULL
        CONSTRAINT "ValidValuesPowierzchnia" CHECK (("Powierzchnia" >= 0)),
  "Zaloga" Integer NOT NULL
        CONSTRAINT "ValidValuesZaloga" CHECK (("Zaloga" >= 0)),
  "Numer_telefonu" Varchar2(12 ) NOT NULL,
  "email" Varchar2(30 ) NOT NULL,
  "ID_adresu" Integer NOT NULL
)
/

-- Add keys for table Salony_Samochodowe

ALTER TABLE "Salony_Samochodowe" ADD CONSTRAINT "Unique_Identifier1" PRIMARY KEY ("ID_Salonu")
/

-- Table Pracownicy

CREATE TABLE "Pracownicy"(
  "ID_Pracownika" Integer NOT NULL,
  "Imie" Varchar2(30 ) NOT NULL,
  "Nazwisko" Varchar2(30 ) NOT NULL,
  "Stanowisko" Varchar2(30 ) NOT NULL,
  "Numer_telefonu" Varchar2(12 ) NOT NULL,
  "Koniec_umowy" Date NOT NULL,
  "Data_zatrudnienia" Date NOT NULL,
  "email" Varchar2(30 ) NOT NULL,
  "ID_Salonu" Integer NOT NULL,
  "ID_adresu" Integer NOT NULL
)
/

-- Add keys for table Pracownicy

ALTER TABLE "Pracownicy" ADD CONSTRAINT "Unique_Identifier3" PRIMARY KEY ("ID_Pracownika")
/

-- Table Wynagrodzenia

CREATE TABLE "Wynagrodzenia"(
  "ID_Wynagrodzenia" Integer NOT NULL,
  "Wysokosc_wynagrodzenia" Float(126) NOT NULL,
  "Premia" Float(126) NOT NULL,
  "Dodatki" Float(126) NOT NULL,
  "ID_Pracownika" Integer NOT NULL
)
/

-- Add keys for table Wynagrodzenia

ALTER TABLE "Wynagrodzenia" ADD CONSTRAINT "Unique_Identifier7" PRIMARY KEY ("ID_Wynagrodzenia")
/

-- Table Klienci

CREATE TABLE "Klienci"(
  "ID_Klienta" Integer NOT NULL,
  "Imie" Varchar2(20 ) NOT NULL,
  "Nazwisko" Varchar2(30 ) NOT NULL,
  "Rabat" Integer,
  "Numer_telefonu" Varchar2(12 ) NOT NULL,
  "email" Varchar2(45 ) NOT NULL,
  "Pesel" Varchar2(11 ),
  "ID_adresu" Integer NOT NULL
)
/

-- Add keys for table Klienci

ALTER TABLE "Klienci" ADD CONSTRAINT "Unique_Identifier8" PRIMARY KEY ("ID_Klienta")
/

-- Table Samochody

CREATE TABLE "Samochody"(
  "ID_Samochodu" Integer NOT NULL,
  "Status" Varchar2(30 ) NOT NULL,
  "Czy_na_sprzedaz" Char(1 ) NOT NULL,
  "Czy_do_jazdy_probnej" Char(1 ) NOT NULL,
  "Przebieg" Integer NOT NULL,
  "Cena_Netto" Number(10,2) NOT NULL,
  "Cena_Brutto" Number(10,2) NOT NULL,
  "ID_modelu" Integer NOT NULL
)
/

-- Add keys for table Samochody

ALTER TABLE "Samochody" ADD CONSTRAINT "Unique_Identifier10" PRIMARY KEY ("ID_Samochodu")
/

-- Table Uslugi

CREATE TABLE "Uslugi"(
  "ID_Uslugi" Integer NOT NULL,
  "Rodzaj_uslugi" Varchar2(40 ) DEFAULT CREATE RULE wybor_uslugi
AS
@list IN ('Sprzedaze samochodow', 'Jazdy probne', 'Ubezpieczenia', 'Leasingi'); NOT NULL,
  "ID_Klienta" Integer NOT NULL
)
/

-- Add keys for table Uslugi

ALTER TABLE "Uslugi" ADD CONSTRAINT "Unique_Identifier11" PRIMARY KEY ("ID_Uslugi")
/

-- Table Jazdy_probne

CREATE TABLE "Jazdy_probne"(
  "ID_Uslugi" Integer NOT NULL,
  "Data" Date NOT NULL,
  "Czas_trwania" Date NOT NULL,
  "Przejechane_km" Integer NOT NULL
)
/

-- Table Ubezpieczenia

CREATE TABLE "Ubezpieczenia"(
  "ID_Uslugi" Integer NOT NULL,
  "Typ" Varchar2(20 ) NOT NULL,
  "Data_wykupienia" Date NOT NULL,
  "Data_wygasniecia" Date NOT NULL
)
/

-- Table Leasingi

CREATE TABLE "Leasingi"(
  "ID_leasingodawcy" Integer NOT NULL,
  "ID_Uslugi" Integer NOT NULL,
  "Data_podpisania_umowy" Date NOT NULL,
  "Data_wygasniecia" Date NOT NULL,
  "Wartosc" Number(10,2) NOT NULL,
  "Rata" Number(10,2) NOT NULL
)
/

-- Add keys for table Leasingi

ALTER TABLE "Leasingi" ADD CONSTRAINT "Unique_Identifier18" PRIMARY KEY ("ID_Uslugi")
/

-- Table Sprzedaze_samochodow

CREATE TABLE "Sprzedaze_samochodow"(
  "ID_Uslugi" Integer NOT NULL,
  "Data" Date NOT NULL,
  "Cena" Float(126) NOT NULL
)
/

-- Table Modele

CREATE TABLE "Modele"(
  "ID_modelu" Integer NOT NULL,
  "Rodzaj_napedu" Varchar2(20 ) NOT NULL,
  "Pojemnosc_silnika" Float(126) NOT NULL,
  "Wersja_wyposazenia" Varchar2(20 ) NOT NULL,
  "Rok_produkcji" Integer NOT NULL,
  "ID_marki_modelu" Integer NOT NULL
)
/

-- Add keys for table Modele

ALTER TABLE "Modele" ADD CONSTRAINT "Unique_Identifier21" PRIMARY KEY ("ID_modelu")
/

-- Table Fabryki

CREATE TABLE "Fabryki"(
  "ID fabryki" Integer NOT NULL,
  "Nazwa" Varchar2(30 ) NOT NULL,
  "Numer_telefonu" Varchar2(12 ) NOT NULL,
  "email" Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Fabryki

ALTER TABLE "Fabryki" ADD CONSTRAINT "Unique_Identifier22" PRIMARY KEY ("ID fabryki")
/

-- Table Leasingodawcy

CREATE TABLE "Leasingodawcy"(
  "ID_leasingodawcy" Integer NOT NULL,
  "Nazwa" Varchar2(30 ) NOT NULL,
  "Numer_telefonu" Varchar2(12 ) NOT NULL,
  "email" Varchar2(12 ) NOT NULL,
  "ID_Salonu" Integer NOT NULL
)
/

-- Add keys for table Leasingodawcy

ALTER TABLE "Leasingodawcy" ADD CONSTRAINT "Unique_Identifier23" PRIMARY KEY ("ID_leasingodawcy")
/

-- Table Adresy

CREATE TABLE "Adresy"(
  "ID_adresu" Integer NOT NULL,
  "Ulica" Varchar2(30 ) NOT NULL,
  "Numer_budynku" Varchar2(30 ) NOT NULL,
  "Numer_lokalu" Integer,
  "Kod_pocztowy" Varchar2(10 ) NOT NULL,
  "Miejscowosc" Varchar2(30 ) NOT NULL,
  "Kraj" Varchar2(30 ) NOT NULL,
  "ID Wlasciel" Integer NOT NULL
)
/

-- Add keys for table Adresy

ALTER TABLE "Adresy" ADD CONSTRAINT "Unique_Identifier24" PRIMARY KEY ("ID_adresu")
/

-- Table Marki modeli

CREATE TABLE "Marki modeli"(
  "ID_marki_modelu" Integer NOT NULL,
  "Model" Varchar2(30 ) NOT NULL,
  "Marka" Varchar2(20 ) NOT NULL
)
/

-- Add keys for table Marki modeli

ALTER TABLE "Marki modeli" ADD CONSTRAINT "Unique_Identifier25" PRIMARY KEY ("ID_marki_modelu")
/

-- Table Salony_Samochodowe_Klienci

CREATE TABLE "Salony_Samochodowe_Klienci"(
  "ID_Salonu" Integer NOT NULL,
  "ID_Klienta" Integer NOT NULL
)
/

-- Table Transakcje

CREATE TABLE "Transakcje"(
  "ID_Samochodu" Integer NOT NULL,
  "ID_Klienta" Integer NOT NULL
)
/

-- Table Salony_Samochodowe_Uslugi

CREATE TABLE "Salony_Samochodowe_Uslugi"(
  "ID_Salonu" Integer NOT NULL,
  "ID_Uslugi" Integer NOT NULL
)
/

-- Table Salony_Samochodowe_Samochody

CREATE TABLE "Salony_Samochodowe_Samochody"(
  "ID_Salonu" Integer NOT NULL,
  "ID_Samochodu" Integer NOT NULL
)
/

-- Table Salony_Samochodowe_Fabryki

CREATE TABLE "Salony_Samochodowe_Fabryki"(
  "ID_Salonu" Integer NOT NULL,
  "ID fabryki" Integer NOT NULL
)
/

-- Table Samochody_Uslugi

CREATE TABLE "Samochody_Uslugi"(
  "ID_Samochodu" Integer NOT NULL,
  "ID_Uslugi" Integer NOT NULL
)
/

-- Table Wlasciciele

CREATE TABLE "Wlasciciele"(
  "ID Wlasciel" Integer NOT NULL,
  "ID_Salonu" Integer NOT NULL,
  "Imie" Varchar2(15 ) NOT NULL,
  "Nazwisko" Varchar2(30 ) NOT NULL,
  "Pesel" Varchar2(11 ),
  "Ilosc salonow" Integer NOT NULL
)
/

-- Add keys for table Wlasciciele

ALTER TABLE "Wlasciciele" ADD CONSTRAINT "PK_Wlasciciele" PRIMARY KEY ("ID Wlasciel")
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE "Pracownicy" ADD CONSTRAINT "Zatrudnia" FOREIGN KEY ("ID_Salonu") REFERENCES "Salony_Samochodowe" ("ID_Salonu")
/


ALTER TABLE "Wynagrodzenia" ADD CONSTRAINT "Otrzymuje" FOREIGN KEY ("ID_Pracownika") REFERENCES "Pracownicy" ("ID_Pracownika")
/


ALTER TABLE "Uslugi" ADD CONSTRAINT "Kupuje Usluge" FOREIGN KEY ("ID_Klienta") REFERENCES "Klienci" ("ID_Klienta")
/


ALTER TABLE "Samochody" ADD CONSTRAINT "Model samochodu" FOREIGN KEY ("ID_modelu") REFERENCES "Modele" ("ID_modelu")
/


ALTER TABLE "Leasingodawcy" ADD CONSTRAINT "Wspopracuja" FOREIGN KEY ("ID_Salonu") REFERENCES "Salony_Samochodowe" ("ID_Salonu")
/


ALTER TABLE "Leasingi" ADD CONSTRAINT "Udziela" FOREIGN KEY ("ID_leasingodawcy") REFERENCES "Leasingodawcy" ("ID_leasingodawcy")
/


ALTER TABLE "Modele" ADD CONSTRAINT "Należa Do" FOREIGN KEY ("ID_marki_modelu") REFERENCES "Marki modeli" ("ID_marki_modelu")
/


ALTER TABLE "Klienci" ADD CONSTRAINT "Klient mieszka pod adresem" FOREIGN KEY ("ID_adresu") REFERENCES "Adresy" ("ID_adresu")
/


ALTER TABLE "Pracownicy" ADD CONSTRAINT "Pracownik mieszka pod adresem" FOREIGN KEY ("ID_adresu") REFERENCES "Adresy" ("ID_adresu")
/


ALTER TABLE "Salony_Samochodowe" ADD CONSTRAINT "Salon zlokalizowany pod adresem" FOREIGN KEY ("ID_adresu") REFERENCES "Adresy" ("ID_adresu")
/


ALTER TABLE "Salony_Samochodowe_Samochody" ADD CONSTRAINT "Posiada_samochod_Samochody" FOREIGN KEY ("ID_Samochodu") REFERENCES "Samochody" ("ID_Samochodu")
/


ALTER TABLE "Sprzedaze_samochodow" ADD CONSTRAINT "Uslugi Sprzedaze samochodow" FOREIGN KEY ("ID_Uslugi") REFERENCES "Uslugi" ("ID_Uslugi")
/


ALTER TABLE "Jazdy_probne" ADD CONSTRAINT "Uslugi Jazdy probne" FOREIGN KEY ("ID_Uslugi") REFERENCES "Uslugi" ("ID_Uslugi")
/


ALTER TABLE "Ubezpieczenia" ADD CONSTRAINT "Uslugi ubezpieczenia" FOREIGN KEY ("ID_Uslugi") REFERENCES "Uslugi" ("ID_Uslugi")
/


ALTER TABLE "Leasingi" ADD CONSTRAINT "Relationship7" FOREIGN KEY ("ID_Uslugi") REFERENCES "Uslugi" ("ID_Uslugi")
/


ALTER TABLE "Wlasciciele" ADD CONSTRAINT "Posiada Salon Samochodowy" FOREIGN KEY ("ID_Salonu") REFERENCES "Salony_Samochodowe" ("ID_Salonu")
/


ALTER TABLE "Adresy" ADD CONSTRAINT "Mieszka" FOREIGN KEY ("ID Wlasciel") REFERENCES "Wlasciciele" ("ID Wlasciel")
/





