DROP DATABASE IF EXISTS sistema_academico;

CREATE DATABASE sistema_academico;

\c sistema_academico;

CREATE TABLE alunos(
    id      SERIAL          PRIMARY KEY,
    nome    VARCHAR(100)    NOT NULL,
    email   VARCHAR(100)    UNIQUE
);

CREATE TABLE disciplinas(
    id              SERIAL          PRIMARY KEY,
    nome            VARCHAR(100),
    carga_horaria   INTEGER
);

CREATE TABLE matriculas(
    id              SERIAL      PRIMARY KEY,
    aluno_id        INTEGER     REFERENCES alunos(id),
    disciplina_id   INTEGER     REFERENCES disciplinas(id),
    data_matricula  TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE historico(
    id              SERIAL      PRIMARY KEY,
    aluno_id        INTEGER     REFERENCES alunos(id),
    disciplina_id   INTEGER     REFERENCES disciplinas(id),
    nota            INTEGER,
    aprovado        BOOLEAN
);

CREATE TABLE log_matriculas(
    id              SERIAL          PRIMARY KEY,
    aluno_id        INTEGER         REFERENCES alunos(id),
    disciplina_id   INTEGER         REFERENCES disciplinas(id),
    data_log        TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
    acao            VARCHAR(200)
);

CREATE OR REPLACE FUNCTION validar_nota()
RETURNS TRIGGER AS $$
DECLARE
    nota_aux INTEGER = NEW.nota;
    aprovado_aux BOOLEAN;
BEGIN
    IF nota_aux <= 6 THEN
        RAISE EXCEPTION 'Nota abaixo da média, aluno não pode ter histórico com disciplinas reprovadas';
    ELSE IF nota_aux > 6 THEN
        aprovado_aux = TRUE;
        RETURN aprovado_aux;
    END IF;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER verificar_media 
BEFORE INSERT OR UPDATE ON historico
FOR EACH ROW
EXECUTE FUNCTION validar_nota();

CREATE OR REPLACE FUNCTION auditar_matricula()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_matriculas (aluno_id, disciplina_id, data_log, acao) VALUES(NEW.aluno_id, NEW.disciplina_id, CURRENT_TIMESTAMP, 'Matrícula realizada');
    RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER inserir_log_matriculas
AFTER INSERT ON matriculas
FOR EACH ROW
EXECUTE FUNCTION auditar_matricula();

CREATE OR REPLACE FUNCTION impedir_matricula_duplicada()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (
        SELECT 1 FROM matriculas WHERE aluno_id = NEW.aluno_id AND disciplina_id = NEW.disciplina_id
    ) THEN
        RAISE EXCEPTION 'Esse aluno já possui matricula nessa disciplina';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER verifica_matricula_duplicada
BEFORE INSERT ON matriculas
FOR EACH ROW
EXECUTE FUNCTION impedir_matricula_duplicada();

CREATE OR REPLACE FUNCTION inserir_historico()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO historico(aluno_id, disciplina_id, nota, aprovado) VALUES (NEW.aluno_id, NEW.disciplina_id, NULL, NULL);
    RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER trigger_inserir_historico
AFTER INSERT ON matriculas
FOR EACH ROW
EXECUTE FUNCTION inserir_historico();

INSERT INTO alunos(nome, email) VALUES
('Ronaldo', 'ronaldoroig@outlook.com');

INSERT INTO disciplinas(nome, carga_horaria) VALUES ('PBD', 100);

INSERT INTO historico (aluno_id, disciplina_id, nota) VALUES (1, 1, 6);

INSERT INTO matriculas (aluno_id, disciplina_id, data_matricula) VALUES (1, 1, CURRENT_TIMESTAMP);