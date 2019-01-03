SELECT * FROM "Adresy";

--Wyszukowanie samochod�w okre�lonej marki
SELECT * FROM "Samochody" WHERE "Samochody"."ID_modelu" IN (SELECT "ID_modelu" FROM "Modele" WHERE "Modele"."ID_marki_modelu" IN (SELECT "ID_marki_modelu" FROM "Marki_modeli" WHERE "Marka" = 'BMW'));

--Wyszukanie nazw modeli samochod�w do jazdy pr�bnej
SELECT "Model" FROM "Marki_modeli" WHERE "Marki_modeli"."ID_marki_modelu" IN (SELECT "ID_marki_modelu" FROM "Modele" WHERE "Modele"."ID_modelu" IN (SELECT "ID_modelu" FROM "Samochody" WHERE "Samochody"."Czy_do_jazdy_probnej" = 'T'));

--Wyszukiwanie Marek samochod�w dost�pnych w konkretnym salonie
SELECT "Marka" FROM "Marki_modeli" WHERE "Marki_modeli"."ID_marki_modelu" IN (SELECT "ID_marki_modelu" FROM "Modele" WHERE "Modele"."ID_modelu" IN (SELECT "ID_modelu" FROM "Samochody" WHERE "Samochody"."ID_Samochodu" IN (SELECT "ID_Samochodu" FROM "Salony_Samochodowe_Samochody" WHERE "Salony_Samochodowe_Samochody"."ID_Salonu" IN (SELECT "ID_Salonu" FROM "Salony_Samochodowe" WHERE "Salony_Samochodowe"."Nazwa" = 'KozlowskiMobile'))));