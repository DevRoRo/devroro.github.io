-- Test registrar_emprestimo procedure
CALL registrar_emprestimo(1, 2);
CALL registrar_emprestimo(2, 12);
CALL registrar_emprestimo(3, 22);

-- Test calcular_multa function
SELECT calcular_multa('2023-01-01', '2023-01-10', 2.00) AS multa_calculada;

-- Test registrar_devolucao procedure
CALL registrar_devolucao(1, 1, '2023-11-08', NULL);
CALL registrar_devolucao(2, 2, '2023-11-12', NULL);
CALL registrar_devolucao(3, 3, '2023-11-15', NULL);

-- Test renovar_emprestimo procedure
CALL renovar_emprestimo(1, 1, '2023-11-20', NULL);
CALL renovar_emprestimo(2, 2, '2023-11-21', NULL);
CALL renovar_emprestimo(3, 3, '2023-11-22', NULL);

-- Test calcular_disponibilidade function
SELECT 
    calcular_disponibilidade(1) AS disp_livro1,
    calcular_disponibilidade(2) AS disp_livro2,
    calcular_disponibilidade(3) AS disp_livro3;

-- Test estatisticas_membro function
SELECT * FROM estatisticas_membro(1);
SELECT * FROM estatisticas_membro(2);
SELECT * FROM estatisticas_membro(3);

-- Verify data changes
SELECT * FROM emprestimo ORDER BY id;
SELECT * FROM exemplar WHERE id IN (1, 2, 3, 11, 12, 22, 23, 45);
SELECT * FROM livro;
SELECT * FROM membro;

-- Test error cases
-- Invalid member
CALL registrar_emprestimo(99, 1);

-- Invalid exemplar
CALL registrar_emprestimo(1, 99);

-- Already borrowed exemplar
CALL registrar_emprestimo(1, 1);

-- Try to return non-existent loan
CALL registrar_devolucao(99, 99, CURRENT_DATE, NULL);

-- Try to renew with pending fine
CALL registrar_emprestimo(1, 3);
CALL registrar_devolucao(1, 1, CURRENT_DATE + INTERVAL '10 days', NULL);
CALL renovar_emprestimo(1, 1, CURRENT_DATE, NULL);