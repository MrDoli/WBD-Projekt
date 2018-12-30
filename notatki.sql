CREATE TABLE "Uslugi"(
  "ID_Uslugi" Integer NOT NULL,
  "Rodzaj_uslugi" Varchar2(40 ) NOT NULL,
  "ID_Klienta" Integer NOT NULL
)
/

-- Add keys for table Uslugi

ALTER TABLE "Uslugi" ADD CONSTRAINT "Unique_Identifier11" PRIMARY KEY ("ID_Uslugi");
/

ALTER TABLE "Uslugi" ADD CONSTRAINT "Dziedzina" CHECK("Rodzaj_uslugi" in ('Leasingi', 'Sprzedaze_samochodow', 'Jazdy_probne', 'Ubezpieczenia'));


INSERT INTO "Uslugi" ("ID_Klienta", "Rodzaj_uslugi", "ID_Uslugi") VALUES('5', 'Leasingiiii', '4');
/


%%%% Z TYM MA JESZCZE PROBLEM %%%%

ALTER TABLE "Uslugi" ADD CONSTRAINT "Kupuje Usluge" FOREIGN KEY ("ID_Klienta") REFERENCES "Klienci" ("ID_Klienta")
/

ALTER TABLE "Salony_Samochodowe" ADD CONSTRAINT "Salon zlokalizowany pod adresem" FOREIGN KEY ("ID_adresu") REFERENCES "Adresy" ("ID_adresu")
/

ALTER TABLE "Adresy" ADD CONSTRAINT "Mieszka" FOREIGN KEY ("ID Wlasciel") REFERENCES "Wlasciciele" ("ID Wlasciel")
/

