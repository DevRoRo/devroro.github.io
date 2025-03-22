DROP DATABASE IF EXISTS novembro;

CREATE DATABASE novembro;

\c novembro;

DROP ROLE superoro;
CREATE ROLE superoro WITH PASSWORD 'superoro' LOGIN SUPERUSER;

CREATE ROLE selectroro WITH PASSWORD 'selectroro' LOGIN;
GRANT CONNECT on DATABASE novembro TO selectroro;
/* GRANT USAGE ON SCHEMA public TO selectroro; */
GRANT SELECT ON ALL TABLES IN SCHEMA public TO selectroro;

DROP ROLE deleteroro
CREATE ROLE deleteroro WITH PASSWORD 'deleteroro' LOGIN;
GRANT SELECT, UPDATE ON ALL TABLES IN SCHEMA public TO deleteroro;
REVOKE DELETE ON ALL TABLES IN SCHEMA public TO deleteroro;


CREATE TABLE veiculo (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(10),
    ano INT
);

CREATE TABLE carro (
    numero_portas INT
) INHERITS (veiculo);

CREATE TABLE moto (
    cilindradas INT
) INHERITS (veiculo);

CREATE TABLE foto_veiculo (
    id          SERIAL      PRIMARY KEY,
    foto        BYTEA,
    veiculo_id  INTEGER     REFERENCES veiculo(id)  
);

-- Inserir dados na superclasse
INSERT INTO veiculo (placa, ano) VALUES ('ABC1234', 2020);

-- Inserir dados nas subclasses
INSERT INTO carro (placa, ano, numero_portas) VALUES ('DEF5678', 2021, 4);

INSERT INTO moto (placa, ano, cilindradas) VALUES ('GHI9012', 2022, 150);

-- Consultar dados da superclasse (inclui dados das subclasses)
SELECT * FROM veiculo;

-- Consultar dados apenas da superclasse
SELECT * FROM ONLY veiculo;
