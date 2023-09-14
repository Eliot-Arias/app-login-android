-- Active: 1694283437549@@127.0.0.1@3306@android_login
CREATE TABLE usuarios(
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(12) NOT NULL,
    nombres VARCHAR(80) NOT NULL,
    apellidos VARCHAR(80) NOT NULL,
    nom_user VARCHAR(40) NOT NULL UNIQUE,
    contrasenia VARCHAR(40) NOT NULL,
    edad INT NOT NULL,
    correo VARCHAR(80) NOT NULL,
    celular VARCHAR(80) NOT NULL
)

SELECT * FROM usuarios;

