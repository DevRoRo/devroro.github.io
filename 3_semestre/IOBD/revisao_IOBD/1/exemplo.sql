DROP DATABASE IF EXISTS exemplo;

CREATE DATABASE exemplo;

\c exemplo;

CREATE TABLE Usuario (
    id      SERIAL          PRIMARY KEY,      
    nome    VARCHAR(100)    NOT  NULL,
    dados   JSON
);

INSERT INTO Usuario (dados) VALUES ('{"nome": "Igor", "email": "emaildoigor@igor.com.br"}');

