DROP DATABASE IF EXISTS biblioteca;

CREATE DATABASE biblioteca;

\c biblioteca;

CREATE TABLE Autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Livro(
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor_id INT REFERENCES Autor(id)
);

CREATE TABLE Exemplar (
    id SERIAL PRIMARY KEY,
    livro_id INT REFERENCES Livro(id)
);

CREATE TABLE Membro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE Emprestimo (
    id SERIAL PRIMARY KEY,
    exemplar_id INT REFERENCES Exemplar(id),
    membro_id INT REFERENCES Membro(id),
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    multa DECIMAL(10,2)
);

CREATE OR REPLACE PROCEDURE registrar_emprestimo(
    p_id_membro INT,
    p_id_exemplar INT,
    p_data_emprestimo DATE DEFAULT CURRENT_DATE
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_emprestimo_ativo INT;
    v_exemplar_disponivel BOOLEAN;

BEGIN
    IF NOT EXISTS (SELECT 1 FROM membro WHERE id = p_id_membro) THEN
        RAISE EXCEPTION 'Membro com código % não encontrado', p_id_membro;
    END IF;
    
    IF NOT EXISTS (SELECT 1 FROM exemplar WHERE id = p_id_exemplar) THEN
        RAISE EXCEPTION 'Exemplar com código % não encontrado', p_id_exemplar;
    END IF;
    
    SELECT NOT EXISTS (
        SELECT 1 FROM emprestimo 
        WHERE exemplar_id = p_id_exemplar 
        AND data_devolucao IS NULL
    ) INTO v_exemplar_disponivel;
    
    IF NOT v_exemplar_disponivel THEN
        RAISE EXCEPTION 'Exemplar % já está emprestado', p_id_exemplar;
    END IF;

    INSERT INTO emprestimo (
        exemplar_id, 
        membro_id, 
        data_emprestimo, 
        data_devolucao, 
        multa
    ) VALUES (
        p_id_exemplar,
        p_id_membro,
        p_data_emprestimo,
        NULL,
        NULL
    );
    
    RAISE NOTICE 'Empréstimo registrado com sucesso: Membro %, Exemplar %, Data %', 
        p_id_membro, p_id_exemplar, p_data_emprestimo;
END;
$$;

INSERT INTO autor (nome) VALUES
('J.K. Rowling'),
('George Orwell');

INSERT INTO livro (titulo, autor_id) VALUES
('Harry Potter e a Pedra Filosofal', 1),
('Harry Potter e a Câmara Secreta', 1),
('1984', 2),
('A Revolução dos Bichos', 2),
('Harry Potter e o Prisioneiro de Azkaban', 1);

INSERT INTO membro (nome, data_nascimento) VALUES
('João Silva', '1990-05-15'),
('Maria Oliveira', '1985-08-22'),
('Carlos Souza', '1995-03-10');

INSERT INTO exemplar (livro_id) VALUES 
(1), (1), (1), (1), (1), (1), (1), (1), (1), (1);

INSERT INTO exemplar (livro_id) VALUES 
(2), (2), (2), (2), (2), (2), (2), (2), (2), (2);

INSERT INTO exemplar (livro_id) VALUES 
(3), (3), (3), (3), (3), (3), (3), (3), (3), (3);

INSERT INTO exemplar (livro_id) VALUES 
(4), (4), (4), (4), (4), (4), (4), (4), (4), (4);

INSERT INTO exemplar (livro_id) VALUES 
(5), (5), (5), (5), (5), (5), (5), (5), (5), (5);

INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo) VALUES
(1, 1, '2023-11-01');

INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo) VALUES
(23, 2, '2023-11-05');

INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo) VALUES
(45, 3, '2023-11-10');

INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo, data_devolucao, multa) VALUES
(11, 1, '2023-10-15', '2023-11-05', 15.50);

CALL registrar_emprestimo(1, 1);
