INSERT INTO venditore (id, nome, cognome, username, password, saldo, feedback)
    VALUES (default, 'Simone', 'Picciau', 'Spicc', '123456', 15.30, 10);

INSERT INTO venditore (id, nome, cognome, username, password, saldo, feedback)
    VALUES (default, 'Antonello', 'Lai', 'Tcs', '123456', 19.30, 1);

INSERT INTO cliente (id, nome, cognome, username, password, saldo)
    VALUES (default, 'Laura', 'Puddu', 'Laupud', '123456', 15.30);

INSERT INTO cliente (id, nome, cognome, username, password, saldo)
    VALUES (default, 'Claudia', 'Puddu', 'cla', '123456', 19.30);

INSERT INTO disco (id, titolo, descrizione, copertina, disponibilità, prezzo,
                     id_venditore)
    VALUES (default, 'Queen - Gratest Hits II', 'Compact Disc - Ottimo stato',
             'img/copertina001.jpg', 4, 10, 1);

INSERT INTO disco (id, titolo, descrizione, copertina, disponibilità, prezzo,
                     id_venditore)
    VALUES (default, 'Rolling Stones - Grrr', 'Compact Disc - Ottimo stato',
             'img/copertina002.jpg', 2, 5, 1);

INSERT INTO disco (id, titolo, descrizione, copertina, disponibilità, prezzo,
                     id_venditore)
    VALUES (default, 'Vasco Rossi - Sono Innocente', 'Compact Disc - Ottimo stato',
             'img/copertina003.jpg', 5, 10, 1);

INSERT INTO disco (id, titolo, descrizione, copertina, disponibilità, prezzo,
                     id_venditore)
    VALUES (default, 'Daft Punk - Discovery', 'Compact Disc - Ottimo stato',
             'img/copertina004.jpg', 1, 8, 2);

INSERT INTO disco (id, titolo, descrizione, copertina, disponibilità, prezzo,
                     id_venditore)
    VALUES (default, 'Depeche Mode - Delta Machine', 'Compact Disc - Ottimo stato',
             'img/copertina005.jpg', 3, 8, 1);