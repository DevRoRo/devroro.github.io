-- Quais usuários escreveram mais artigos? Em caso de empate mostrar todos
SELECT 
    Usuario.nome, count(*) 
FROM
    Usuario 
INNER JOIN 
    Usuario_Artigo 
ON 
    (Usuario_Artigo.Usuario_id = Usuario.id) 
INNER JOIN 
    Artigo 
ON 
    (Artigo.id = Usuario_Artigo.Artigo_id) 
GROUP BY 
    Usuario.nome 
HAVING 
    count(*) = (
        SELECT 
            count(*) 
        from 
            Usuario 
        INNER JOIN 
            Usuario_Artigo 
        ON 
            (Usuario_Artigo.Usuario_id = Usuario.id) 
        INNER JOIN 
            Artigo 
        ON 
            (Artigo.id = Usuario_Artigo.Artigo_id) 
        GROUP BY 
            Usuario.nome 
        ORDER BY 
            Usuario.nome 
        DESC LIMIT 1) 
ORDER BY 
    Usuario.nome;

-- O título de cada Artigo e o nome de cada usuário envolvido na escrita de cada Artigo / Crie uma view
DROP VIEW IF EXISTS autores_dos_artigos_publicados;

CREATE VIEW autores_dos_artigos_publicados AS
    SELECT
        Artigo.titulo,
        STRING_AGG(Usuario.nome, ', ') AS autores
    FROM
        Artigo
    INNER JOIN
        Usuario_Artigo
    ON
        (Usuario_Artigo.Artigo_id = Artigo.id)
    INNER JOIN
        Usuario
    ON
        (Usuario_Artigo.Usuario_id = Usuario.id)
    GROUP BY
        Artigo.Titulo;

SELECT * FROM autores_dos_artigos_publicados;

--Listar os Usuários com e sem endereços. Caso tenha endereço, coloque o endereço. Se não tiver, coloque "Sem endereço cadastrado"
SELECT
    Usuario.nome,
    COALESCE(endereco.rua || ', ' || endereco.bairro || ', ' || endereco.complemento || ', Número: ' || endereco.numero || '. CEP:' || endereco.cep, 'endereco nao cadastrado')
    AS 
        endereco
FROM
    Usuario
LEFT JOIN    
    endereco
ON
    (endereco.Usuario_id = Usuario.id)
GROUP BY
    Usuario.nome, endereco
ORDER BY
    endereco DESC;