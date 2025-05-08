DROP DATABASE IF EXISTS ronaldo;

CREATE DATABASE ronaldo;

\c ronaldo;

CREATE TABLE medicos(
    id              SERIAL              PRIMARY KEY,
    nome            VARCHAR(100)        NOT NULL,
    especialidade   VARCHAR(50)         NOT NULL,
    crm             VARCHAR(5)          UNIQUE      NOT NULL
);

CREATE TABLE pacientes(
    id                  SERIAL             PRIMARY KEY,
    nome                VARCHAR(100)       NOT NULL,
    data_nascimento     DATE               NOT NULL,
    cpf                 VARCHAR(11)        UNIQUE       NOT NULL,
    telefone            VARCHAR(20)
);

CREATE TABLE consultas (
    id                  SERIAL                          PRIMARY KEY,
    status_consulta     VARCHAR(20)                     NOT NULL CHECK (status_consulta IN ('Agendada', 'Realizada', 'Cancelada')),
    data_hora           TIMESTAMP WITHOUT TIME ZONE     NOT NULL,
    diagnostico         TEXT,
    medico_id           INTEGER                         REFERENCES medicos(id),
    paciente_id         INTEGER                         REFERENCES pacientes(id)
);

CREATE TABLE exames(
    id                      SERIAL              PRIMARY KEY,
    descricao               VARCHAR(100)        NOT NULL,
    data_hora_realizacao    TIMESTAMP           NOT NULL,
    resultado               TEXT,
    consulta_id             INTEGER             REFERENCES consultas(id)
);

CREATE OR REPLACE PROCEDURE registrar_consulta(paciente_nome_aux VARCHAR(100), medico_nome_aux VARCHAR(100), data_hora_aux TIMESTAMP WITHOUT TIME ZONE) AS
$$
DECLARE
    medico_id_aux INTEGER;
    paciente_id_aux INTEGER;
BEGIN
    SELECT id FROM medicos WHERE nome = medico_nome_aux INTO medico_id_aux;
    SELECT id FROM pacientes WHERE nome = paciente_nome_aux INTO paciente_id_aux;

    INSERT INTO consultas (status_consulta, data_hora, medico_id, paciente_id) VALUES('Agendada', CURRENT_TIMESTAMP, medico_id_aux, paciente_id_aux);
END;
$$ LANGUAGE 'plpgsql';
