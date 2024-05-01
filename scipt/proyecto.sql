PRAGMA foreign_keys = ON;
DROP TABLE IF EXISTS USUARIOS;
CREATE TABLE USUARIOS(
    EMAIL VARCHAR2(40) UNIQUE NOT NULL,
    TELEFONO NUMBER(9) UNIQUE NOT NULL,
    NOMAPELL VARCHAR2(60) NOT NULL,
    DIRECCION VARCHAR2(60) NOT NULL,
    CONTRASENNA VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_USUARIOS PRIMARY KEY (TELEFONO)
);
DROP TABLE IF EXISTS ALOJAMIENTOS;
CREATE TABLE ALOJAMIENTOS(
    ID_ALOJAMIENTO NUMBER(10) PRIMARY KEY UNIQUE,
    NOMBRE VARCHAR2(20) NOT NULL,
    DIRECCION VARCHAR2(60) NOT NULL,
    TIPO_ALOJAMIENTO VARCHAR2(20) CHECK (TIPO_ALOJAMIENTO IN ('hoteles','apartamentos')) NOT NULL
);
DROP TABLE IF EXISTS HOTELES;
CREATE TABLE HOTELES(
    NUM_ESTRELLAS NUMBER(5) CHECK(NUM_ESTRELLAS IN (1,2,3,4,5)) NOT NULL,
    TIPO_HABITACION VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_HOTELES FOREIGN KEY (ID_ALOJAMIENTO) REFERENCES ALOJAMIENTOS(ID_ALOJAMIENTO) ON DELETE CASCADE ON UPDATE CASCADE
);
DROP TABLE IF EXISTS APARTAMENTOS;
CREATE TABLE APARTAMENTOS(
    ID_ALOJAMIENTO NUMBER(10) NOT NULL,
    DISTANCIA NUMBER(5) NOT NULL,
    CONSTRAINT FK_APARTAMENTOS FOREIGN KEY (ID_ALOJAMIENTO) REFERENCES ALOJAMIENTOS(ID_ALOJAMIENTO) ON DELETE CASCADE ON UPDATE CASCADE
);
DROP TABLE IF EXISTS RESERVA;
CREATE TABLE RESERVA(
    FECHA_ENTRADA DATETIME NOT NULL,
    FECHA_SALIDA DATETIME NOT NULL,
    EMAIL VARCHAR2(40) NOT NULL,
    TELEFONO NUMBER(9) NOT NULL,
    ID_ALOJAMIENTO NUMBER(10) NOT NULL,
    CONSTRAINT PK_RESERVA PRIMARY KEY (FECHA_ENTRADA),
    CONSTRAINT FK_RESERVA FOREIGN KEY (TELEFONO) REFERENCES USUARIOS(TELEFONO) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_RESERVA FOREIGN KEY (ID_ALOJAMIENTO) REFERENCES ALOJAMIENTOS(ID_ALOJAMIENTO) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS ALOJAMIENTOTRIGGER;

CREATE TABLE ALOJAMIENTOTRIGGER(
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    NOMBRE_ALOJAMIENTOS VARCHAR2(40),
    TIPO VARCHAR2(20),
    DIRECCION VARCHAR2(60),
    FECHA_BAJA DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS ACTUALIZAREMAIL;

CREATE TABLE ACTUALIZAREMAIL(
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    NUEVO_EMAIL VARCHAR2(20) NOT NULL,
    VIEJO_EMAIL VARCHAR2(20) NOT NULL,
    TELEFONO VARCHAR2(20) NOT NULL
);

DROP INDEX IF EXISTS nomb;

CREATE INDEX nomb ON ALOJAMIENTOS(NOMBRE);

DROP TRIGGER IF EXISTS BAJAS;

CREATE TRIGGER BAJAS BEFORE DELETE ON ALOJAMIENTOS 
BEGIN
    INSERT INTO ALOJAMIENTOTRIGGER(ID, NOMBRE_ALOJAMIENTOS, TIPO, DIRECCION, FECHA_BAJA) VALUES
    (OLD.ID_ALOJAMIENTO, OLD.NOMBRE, OLD.DIRECCION, CURRENT_TIMESTAMP);
END;

INSERT INTO USUARIOS (EMAIL, TELEFONO, NOMAPELL, DIRECCION, CONTRASENNA) VALUES
('usuario1@example.com', 123456789, 'Juan Pérez', 'Calle Principal 123', 'contraseña1'),
('usuario2@example.com', 987654321, 'María González', 'Avenida Central 456', 'contraseña2'),
('usuario3@example.com', 555555555, 'Luis Rodríguez', 'Paseo del Parque 789', 'contraseña3');

INSERT INTO ALOJAMIENTOS (ID_ALOJAMIENTO, NOMBRE, DIRECCION, TIPO_ALOJAMIENTO) VALUES
(1, 'Hotel Miramar', 'Calle Marítima 100', 'hoteles'),
(2, 'Apartamentos Sol', 'Avenida del Sol 200', 'apartamentos'),
(3, 'Hotel Montaña', 'Camino a las Cumbres 300', 'hoteles');

INSERT INTO HOTELES (ID_ALOJAMIENTO, NUM_ESTRELLAS, TIPO_HABITACION) VALUES
(1, 4, 'Doble'),
(3, 3, 'Suite'),
(1, 5, 'Individual');

INSERT INTO APARTAMENTOS (ID_ALOJAMIENTO, DISTANCIA) VALUES
(2, 500),
(2, 700),
(3, 1000);


