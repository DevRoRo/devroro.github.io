DROP DATABASE IF EXISTS trabalho_facade;

CREATE DATABASE trabalho_facade;

\c trabalho_facade;

CREATE TABLE clientes (
    cpf     VARCHAR(11)     PRIMARY KEY,
    nome    VARCHAR(100)    NOT NULL
);