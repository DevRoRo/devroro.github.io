INSERT INTO Dados.Usuario (Email, Nome, Senha, Data_cadastro, Data_nascimento)
VALUES
('joao@example.com', 'João', 'senha123', '2024-01-01', '1990-05-20'),
('maria@example.com', 'Maria', 'senha456', '2024-01-02', '1985-07-15'),
('pedro@example.com', 'Pedro', 'senha789', '2024-01-03', '1992-11-30'),
('ana@example.com', 'Ana', 'senha012', '2024-01-04', '1995-09-25'),
('lucas@example.com', 'Lucas', 'senha345', '2024-01-05', '1998-03-10'),
('clara@example.com', 'Clara', 'senha678', '2024-01-06', '1993-12-12');

INSERT INTO Dados.Endereco (Usuario_id, Bairro, Complemento, Numero, CEP, Rua)
VALUES
(1, 'Centro', 'Apto 101', '50', '12345-678', 'Rua 1'),
(2, 'Bela Vista', 'Casa', '100', '23456-789', 'Rua 2'),
(3, 'Jardim', 'Apto 202', '70', '34567-890', 'Rua 3'),
(4, 'Centro', 'Casa', '120', '45678-901', 'Rua 4'),
(5, 'São José', 'Apto 303', '90', '56789-012', 'Rua 5');

-- Insert Data into Dados.Telefones
INSERT INTO Dados.Telefones (Usuario_id, Numero)
VALUES
(1, '9876543210'),
(2, '9876543211'),
(3, '9876543212'),
(4, '9876543213'),
(5, '9876543214');

-- Insert Data into Dados.Categoria
INSERT INTO Dados.Categoria (Nome)
VALUES
('Tecnologia'),
('Saúde'),
('Educação'),
('Entretenimento'),
('Esporte');

-- Insert Data into Dados.Artigo
INSERT INTO Dados.Artigo (Titulo, Categoria_id)
VALUES
('O Futuro da Tecnologia', 'Tecnologia'),
('Dicas de Saúde', 'Saúde'),
('Novas Metodologias de Ensino', 'Educação'),
('Filmes Mais Aguardados', 'Entretenimento'),
('Preparação para a Maratona', 'Esporte');

-- Insert Data into Sistema.Usuario_artigo
INSERT INTO Sistema.Usuario_artigo (Usuario_id, Artigo_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insert Data into Sistema.Usuario_artigo simulating pair writing of articles
INSERT INTO Sistema.Usuario_artigo (Usuario_id, Artigo_id)
VALUES
(2, 1),
(3, 2),
(4, 3),
(5, 3),
(2, 4),
(3, 4),
(1, 5);

-- Insert Data into Sistema.Curtida
INSERT INTO Sistema.Curtida (Usuario_id, Artigo_id, Data_hora)
VALUES
(1, 2, CURRENT_TIMESTAMP),
(2, 3, CURRENT_TIMESTAMP),
(3, 4, CURRENT_TIMESTAMP),
(4, 5, CURRENT_TIMESTAMP),
(5, 1, CURRENT_TIMESTAMP);

-- Insert Data into Sistema.Comentario
INSERT INTO Sistema.Comentario (Conteudo, Usuario_id, Artigo_id, Data_hora)
VALUES
('Ótimo artigo!', 1, 1, CURRENT_TIMESTAMP),
('Muito informativo!', 2, 2, CURRENT_TIMESTAMP),
('Adorei as dicas.', 3, 3, CURRENT_TIMESTAMP),
('Excelente conteúdo.', 4, 4, CURRENT_TIMESTAMP),
('Muito bom!', 5, 5, CURRENT_TIMESTAMP);