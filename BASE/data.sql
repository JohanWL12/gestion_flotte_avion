
--
-- DATA
--
/*data marques*/
INSERT INTO Marques(NomMarque)
VALUES ('Boeing'),
       ('Airbus'),
       ('Antonov');

/*data modeles*/
INSERT INTO Modeles(NomModele, IdMarque)
VALUES ('737', 1),
       ('747', 1),
       ('757', 1),
       ('A220', 2),
       ('A319', 2),
       ('A320', 2),
       ('An-24', 3),
       ('An-26', 3),
       ('An-30', 3);

/*data avoins*/
insert into Avions (Matricule, IdModele)
values ('N-6XO7', 1),
       ('N-LKFC', 1);

/*data kilometrages*/
insert into Kilometrages (IdAvion, Date, DebutKm, FinKm)
values (1, '2022-09-19', 4080, 6925),
       (1, '2022-11-09', 6925, 8166),
       (1, '2022-11-03', 8166, 9036),
       (1, '2022-11-23', 9036, 10098),
       (1, '2022-11-27', 10098, 11586),
       (1, '2022-11-26', 11586, 12954),
       (1, '2022-12-06', 12954, 13896),
       (2, '2022-08-20', 1360, 1933),
       (2, '2022-08-21', 1933, 3312),
       (2, '2022-09-16', 3312, 4007),
       (2, '2022-09-19', 4007, 5326),
       (2, '2022-10-07', 5326, 6959),
       (2, '2022-10-12', 6959, 8530),
       (2, '2022-10-20', 8530, 9173),
       (2, '2022-12-18', 9142, 13312);



INSERT INTO Users(UserName, email, password)
values ('Rakoto', 'rakoto@gmail.com', md5('root'));

INSERT INTO ValiditeToken(DureeValidite)
VALUES (3600);

INSERT INTO Tokens(IdUser, Token)
VALUES (1, 'OUB8bgtfr45cyuikb9');

INSERT INTO Assurances(IdAvion, DatePayement, DateExpiration)
VALUES (1, '2022-4-6 00:00:00', '2023-5-5 00:00:00'),
       (2, '2022-5-6 00:00:00', '2023-2-28 00:00:00');
--        (3, '2022-6-6 00:00:00', '2023-1-1 00:00:00');

INSERT INTO Images(idavion, base) VALUES