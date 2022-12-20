DROP DATABASE IF EXISTS gestion_avion;
CREATE DATABASE gestion_avion;

CREATE ROLE pilote WITH LOGIN PASSWORD 'root';
ALTER DATABASE gestion_avion OWNER TO pilote;

\c gestion_avion pilote;


--
-- TABLE
--

/* table modele */
CREATE TABLE Modeles
(
    IdModele  SERIAL,
    NomModele VARCHAR(75) NOT NULL,
    IdMarque  INTEGER     NOT NULL,
    PRIMARY KEY (IdModele)
);

/* table marque */
CREATE TABLE Marques
(
    IdMarque  SERIAL      NOT NULL,
    NomMarque VARCHAR(75) NOT NULL,
    PRIMARY KEY (IdMarque)
);

/* table avion */
CREATE TABLE Avions
(
    IdAvion   SERIAL,
    Matricule VARCHAR(8) UNIQUE NOT NULL,
    IdModele  INTEGER           NOT NULL,
    PRIMARY KEY (IdAvion)
);

/*table pdp*/
CREATE TABLE Images
(
    IdImage        SERIAL  NOT NULL PRIMARY KEY,
    IdAvion        INTEGER NOT NULL ,
    Base           BYTEA    NOT NUll,
    DateChangement TIMESTAMP DEFAULT NOW()
);

/* table kilometrage */
CREATE TABLE Kilometrages
(
    IdKilometrage SERIAL         NOT NULL,
    IdAvion       INTEGER        NOT NULL,
    Date          DATE           NOT NULL,
    DebutKm       DECIMAL(10, 2) NOT NUll,
    FinKm         DECIMAL(10, 2) NOT NUll,
    PRIMARY KEY (IdKilometrage)
);

/*table token*/
CREATE TABLE Tokens
(
    IdToken         SERIAL       NOT NULL,
    IdUser          INTEGER      NOT NULL,
    Token           VARCHAR(255) NOT NULL,
    Date_generation TIMESTAMP DEFAULT now(),
    Date_expiration TIMESTAMP,
    PRIMARY KEY (IdToken)
);

/*table validite*/
CREATE TABLE ValiditeToken
(
    IdValidite     SERIAL  NOT NULL,
    DureeValidite  INTEGER NOT NULL,
    DateChangement timestamp DEFAULT now(),
    PRIMARY KEY (IdValidite)
);

/*table user*/
CREATE TABLE Users
(
    IdUser   SERIAL,
    UserName VARCHAR(100) NOT NULL,
    email    VARCHAR(70)  NOT NULL,
    password varchar(34)  NOT NULL,
    PRIMARY KEY (IdUser)
);

/*table assurance*/
CREATE TABLE Assurances
(
    IdAssurance    SERIAL    NOT NULL,
    IdAvion        INTEGER   NOT NULL REFERENCES Avions (IdAvion),
    DatePayement   TIMESTAMP NOT NULL,
    DateExpiration TIMESTAMP NOT NULL
);

ALTER TABLE Modeles
    ADD FOREIGN KEY (IdMarque) REFERENCES Marques (IdMarque);
ALTER TABLE Avions
    ADD FOREIGN KEY (IdModele) REFERENCES Modeles (IdModele);
ALTER TABLE Kilometrages
    ADD FOREIGN KEY (IdAvion) REFERENCES Avions (IdAvion);
ALTER TABLE Modeles
    ADD FOREIGN KEY (IdMarque) REFERENCES Marques (IdMarque);
ALTER TABLE Avions
    ADD FOREIGN KEY (IdModele) REFERENCES Modeles (IdModele);
ALTER TABLE Kilometrages
    ADD FOREIGN KEY (IdAvion) REFERENCES Avions (IdAvion);
ALTER TABLE Tokens
    ADD FOREIGN KEY (IdUser) REFERENCES Users (IdUser);
ALTER TABLE Images
    ADD FOREIGN KEY (IdAvion) REFERENCES Avions (IdAvion);

CREATE OR REPLACE FUNCTION md5(bytea in VARCHAR)
    RETURNS VARCHAR(34) AS
$$
begin
    return crypt(bytea, gen_salt('md5'))::varchar;
end;
$$
    LANGUAGE plpgsql;
