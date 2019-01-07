
INSERT INTO "Adresy" VALUES (1, 'Nowowiejska', 12, 3, '00-342', 'Warszawa', 'Polska');
INSERT INTO "Adresy" VALUES (2, 'Jerozolimska', 1, 2, '00-352', 'Warszawa', 'Polska');
INSERT INTO "Adresy" VALUES (3, 'Hetmañska', 2, 4, '15-422', 'Bialystok', 'Polska');
INSERT INTO "Adresy" VALUES (4, 'Warszawska', 13, NULL, '18-222', 'Wroclaw', 'Polska');

INSERT INTO "Salony_Samochodowe" VALUES(1,'KozlowskiMobile', TO_DATE('1984-12-12'), 150, 8, '111222333', 'salon@gmail.com', 1);

INSERT INTO "Fabryki" VALUES (1, 'Fabryka BMW', '+48123654837', 'fabrykabmw@gmail.com');
INSERT INTO "Fabryki" VALUES (2, 'Fabryka AUDI', '+48123999837', 'fabrykaaudi@gmail.com');

INSERT INTO "Salony_Samochodowe_Fabryki" VALUES (1, 1);
INSERT INTO "Salony_Samochodowe_Fabryki" VALUES (2, 1);

INSERT INTO "Marki_modeli" VALUES (1, 'X6', 'BMW');
INSERT INTO "Marki_modeli" VALUES (2, 'A6', 'Audi');

INSERT INTO "Modele" VALUES (1, 'Diesel', 1.6, 'A', 2011, 1, 1);
INSERT INTO "Modele" VALUES (2, 'Benzyna', 4.2, 'B', 2015, 2, 2);

INSERT INTO "Samochody" VALUES (1, 'Nowy', 'T', 'T', 1000, 120000.00, 130000.00, 2);
INSERT INTO "Samochody" VALUES (2, 'Nowy', 'T', 'T', 1000, 170000.00, 180000.00, 2);
INSERT INTO "Samochody" VALUES (3, 'Uzywany', 'N', 'T', 20000, 40000.00, 50000.00, 1);

INSERT INTO "Salony_Samochodowe_Samochody" VALUES (1, 1);
INSERT INTO "Salony_Samochodowe_Samochody" VALUES (2, 1);
INSERT INTO "Salony_Samochodowe_Samochody" VALUES (3, 1);

