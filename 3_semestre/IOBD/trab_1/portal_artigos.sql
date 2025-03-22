DROP DATABASE IF EXISTS portal_artigos;

CREATE DATABASE portal_artigos;

\c portal_artigos;

CREATE SCHEMA Dados;

CREATE SCHEMA Sistema;

SET search_path TO public, Dados, Sistema;

CREATE TABLE Dados.Usuario (
    id                  SERIAL                      PRIMARY KEY,
    Email               CHARACTER VARYING (200),
    Nome                CHARACTER VARYING (100)     NOT NULL,
    Senha               CHARACTER VARYING (12)      NOT NULL,
    Data_cadastro       DATE,
    Data_nascimento     DATE
);

CREATE TABLE Dados.endereco (
    Usuario_id          INTEGER                     REFERENCES Usuario(id),
    Bairro              CHARACTER VARYING (100),
    Complemento         CHARACTER VARYING (100),
    Numero              CHARACTER VARYING (15),
    CEP                 CHARACTER VARYING (9),
    Rua                 CHARACTER VARYING (100),
    PRIMARY KEY         (Usuario_id)
);

CREATE TABLE Dados.Telefones (
    Usuario_id      INTEGER                 REFERENCES Usuario(id),
    Numero          CHARACTER VARYING (11),
    PRIMARY KEY (Usuario_id)
);

CREATE TABLE Dados.Categoria (
    Nome    CHARACTER VARYING (30)  PRIMARY KEY
);

CREATE TABLE Dados.Artigo (
    id                      SERIAL                      PRIMARY KEY,
    Titulo                  CHARACTER VARYING (100)     NOT NULL,
    Data_hora_publicacao    TIMESTAMP                   DEFAULT CURRENT_TIMESTAMP,
    Categoria_id            CHARACTER VARYING (30)      REFERENCES Categoria(nome)
);

CREATE TABLE Sistema.Usuario_artigo (
    Usuario_id      INTEGER     REFERENCES Usuario(id),
    Artigo_id       INTEGER     REFERENCES Artigo(id),
    PRIMARY KEY     (Usuario_id, Artigo_id)
);

CREATE TABLE Sistema.Curtida (
    Usuario_id      INTEGER         REFERENCES Usuario(id),
    Artigo_id       INTEGER         REFERENCES Artigo(id),
    Data_hora       TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY     (Usuario_id, Artigo_id)
);

CREATE TABLE Sistema.Comentario (
    id              SERIAL                      PRIMARY KEY,
    Conteudo        CHARACTER VARYING (1000)    NOT NULL,
    Usuario_id      INTEGER                     REFERENCES Usuario(id),
    Artigo_id       INTEGER                     REFERENCES Artigo(id),
    Data_hora       TIMESTAMP                   DEFAULT CURRENT_TIMESTAMP
);