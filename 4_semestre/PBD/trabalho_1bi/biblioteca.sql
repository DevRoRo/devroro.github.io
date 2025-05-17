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

CREATE OR REPLACE FUNCTION calcular_multa(
    p_data_emprestimo DATE,
    p_data_devolucao DATE,
    p_taxa_diaria DECIMAL(10,2)
) RETURNS DECIMAL(10,2) AS $$
DECLARE
    v_data_prevista DATE := p_data_emprestimo + INTERVAL '7 days';
BEGIN
    RETURN CASE 
        WHEN p_data_devolucao > v_data_prevista 
        THEN (p_data_devolucao - v_data_prevista) * p_taxa_diaria
        ELSE 0
    END;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE registrar_emprestimo(
    p_id_membro INT,
    p_id_exemplar INT,
    p_data_emprestimo DATE DEFAULT CURRENT_DATE)
AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM membro WHERE id = p_id_membro) THEN
        RAISE EXCEPTION 'Membro não encontrado';
    END IF;
    
    IF NOT EXISTS (SELECT 1 FROM exemplar WHERE id = p_id_exemplar) THEN
        RAISE EXCEPTION 'Exemplar não encontrado';
    END IF;
    
    IF EXISTS (SELECT 1 FROM emprestimo WHERE exemplar_id = p_id_exemplar AND data_devolucao IS NULL) THEN
        RAISE EXCEPTION 'Exemplar já emprestado';
    END IF;

    INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo) 
    VALUES (p_id_exemplar, p_id_membro, p_data_emprestimo);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE registrar_devolucao(
    p_id_livro INT,
    p_id_membro INT,
    p_data_devolucao DATE,
    INOUT p_mensagem VARCHAR DEFAULT NULL)
AS $$
DECLARE
    v_emprestimo RECORD;
BEGIN
    SELECT e.id, e.data_emprestimo, e.exemplar_id INTO v_emprestimo
    FROM Emprestimo e
    JOIN Exemplar ex ON e.exemplar_id = ex.id
    WHERE ex.livro_id = p_id_livro
    AND e.membro_id = p_id_membro
    AND e.data_devolucao IS NULL
    LIMIT 1;
    
    IF v_emprestimo.id IS NULL THEN
        p_mensagem := 'Erro: Empréstimo ativo não encontrado';
        RETURN;
    END IF;
    
    UPDATE Emprestimo
    SET data_devolucao = p_data_devolucao,
        multa = calcular_multa(v_emprestimo.data_emprestimo, p_data_devolucao, 2.00)
    WHERE id = v_emprestimo.id;
    
    p_mensagem := 'Devolução registrada' || CASE 
        WHEN (SELECT multa FROM Emprestimo WHERE id = v_emprestimo.id) > 0 
        THEN ' com multa' 
        ELSE '' 
    END;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE renovar_emprestimo(
    p_id_livro INT,
    p_id_membro INT,
    p_data_renovacao DATE,
    INOUT p_mensagem VARCHAR DEFAULT NULL)
AS $$
DECLARE
    v_emprestimo RECORD;
BEGIN
    SELECT e.id, e.multa INTO v_emprestimo
    FROM Emprestimo e
    JOIN Exemplar ex ON e.exemplar_id = ex.id
    WHERE ex.livro_id = p_id_livro
    AND e.membro_id = p_id_membro
    AND e.data_devolucao IS NULL
    LIMIT 1;
    
    IF v_emprestimo.id IS NULL THEN
        p_mensagem := 'Erro: Empréstimo ativo não encontrado';
        RETURN;
    END IF;
    
    IF v_emprestimo.multa > 0 THEN
        p_mensagem := 'Erro: Multa pendente de R$' || v_emprestimo.multa;
        RETURN;
    END IF;
    
    UPDATE Emprestimo
    SET data_emprestimo = p_data_renovacao
    WHERE id = v_emprestimo.id;
    
    p_mensagem := 'Empréstimo renovado até ' || (p_data_renovacao + INTERVAL '7 days');
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calcular_disponibilidade(p_id_livro INT) 
RETURNS INT AS $$
BEGIN
    RETURN (
        SELECT COUNT(*) FROM Exemplar WHERE livro_id = p_id_livro
    ) - (
        SELECT COUNT(*) 
        FROM Emprestimo e 
        JOIN Exemplar ex ON e.exemplar_id = ex.id 
        WHERE ex.livro_id = p_id_livro AND e.data_devolucao IS NULL
    );
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION estatisticas_membro(p_id_membro INT)
RETURNS TABLE (total_emp BIGINT, total_dev BIGINT, taxa_dev NUMERIC(5,2)) AS $$
BEGIN
    RETURN QUERY
    WITH emp AS (SELECT COUNT(*) AS total FROM Emprestimo WHERE membro_id = p_id_membro),
    dev AS (SELECT COUNT(*) AS total FROM Emprestimo WHERE membro_id = p_id_membro AND data_devolucao IS NOT NULL)
    SELECT 
        emp.total,
        dev.total,
        CASE WHEN emp.total = 0 THEN 0 ELSE ROUND(dev.total::NUMERIC * 100 / emp.total, 2) END
    FROM emp, dev;
END;
$$ LANGUAGE plpgsql;

INSERT INTO autor (nome) VALUES ('J.K. Rowling'), ('George Orwell');
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
(1),(1),(1),(1),(1),(1),(1),(1),(1),(1),
(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),
(3),(3),(3),(3),(3),(3),(3),(3),(3),(3),
(4),(4),(4),(4),(4),(4),(4),(4),(4),(4),
(5),(5),(5),(5),(5),(5),(5),(5),(5),(5);
INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo) VALUES
(1, 1, '2023-11-01'),
(23, 2, '2023-11-05'),
(45, 3, '2023-11-10');
INSERT INTO emprestimo (exemplar_id, membro_id, data_emprestimo, data_devolucao, multa) VALUES
(11, 1, '2023-10-15', '2023-11-05', 15.50);