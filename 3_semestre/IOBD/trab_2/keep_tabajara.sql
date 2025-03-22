DROP DATABASE IF EXISTS keep_tabajara;

CREATE DATABASE keep_tabajara;

\c keep_tabajara;

CREATE TABLE anotacao (
    id          SERIAL          PRIMARY KEY,
    titulo      VARCHAR(50)     NOT NULL UNIQUE, /* why unique is not working? */
    descricao   VARCHAR(1000)   NOT NULL,
    cor         VARCHAR(15),
    data_hora   TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
    foto        BYTEA
);

