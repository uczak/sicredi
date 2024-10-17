
----------------------------------------------LISTA DE PRODUTOS---------------------------------------------------------

INSERT INTO produto (nome, valor) VALUES ('Sabao em po', 10.9);
INSERT INTO produto (nome, valor) VALUES ('Agua 2L', 5.7); --16.9
INSERT INTO produto (nome, valor) VALUES ('Pao frances', 12.1); --26,7
INSERT INTO produto (nome, valor) VALUES ('Coca-cola 2L', 11); --37,7
INSERT INTO produto (nome, valor) VALUES ('Cereal', 7);--44,7
INSERT INTO produto (nome, valor) VALUES ('Detergente', 1.89);--46,59


----------------------------------------------LISTA DE PESSOAS----------------------------------------------------------
INSERT INTO pessoa (cpf, nome) VALUES ('037.000.300-91', 'João Pedro');
INSERT INTO pessoa (cpf, nome) VALUES ('037.000.300-92', 'Maria Augusta');
INSERT INTO pessoa (cpf, nome) VALUES ('037.000.300-93', 'Felipe Da Luz');


----------------------------------------------LISTA DE COMPRA-----------------------------------------------------------
/*compra 1 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (10.9, '037.000.300-91', '2024-10-16 10:30:00.000'); -- Sabão em pó

/*compra 2 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (16.9, '037.000.300-92', '2024-10-16 11:30:00.000'); -- Sabão em pó + Agua 2L

/*compra 3 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (26.7, '037.000.300-93', '2024-10-16 12:30:00.000'); -- Sabão em pó + Agua 2L + Pão frances

/*compra 4 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (37.7, '037.000.300-91', '2024-10-16 13:30:00.000'); -- Sabão em pó + Agua 2L + Pão frances + Coca-cola 2L

/*compra 5 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (44.7, '037.000.300-92', '2024-10-16 14:30:00.000'); -- Sabão em pó + Agua 2L + Pão frances + Coca-cola 2L + Cereal

/*compra 6 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (46.59, '037.000.300-93', '2024-10-16 15:30:00.000');-- Sabão em pó + Agua 2L + Pão frances + Coca-cola 2L + Cereal + Detergente


/*compra 7 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (26.7, '037.000.300-91', '2024-10-17 10:30:00.000'); -- Sabão em pó + Agua 2L + Pão frances

/*compra 8 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (16.9, '037.000.300-92', '2024-10-17 11:30:00.000'); -- Sabão em pó + Agua 2L

/*compra 9 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (23.6, '037.000.300-93', '2024-10-17 12:30:00.000'); -- Sabão em pó + Agua 2L + Cereal

/*compra 10 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (37.7, '037.000.300-91', '2024-10-17 13:30:00.000'); -- Sabão em pó + Agua 2L + Pão frances + Coca-cola 2L

/*compra 11 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (44.7, '037.000.300-92', '2024-10-17 14:30:00.000'); -- Sabão em pó + Agua 2L + Pão frances + Coca-cola 2L + Cereal

/*compra 12 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (10.9, '037.000.300-93', '2024-10-17 15:30:00.000');-- Sabão em pó

/*compra 13 */ INSERT INTO compra (valor_total, pessoa_cpf, data) VALUES (7, '037.000.300-91', '2024-10-17 15:30:00.000');-- Cereal


----------------------------------------------LISTA DE COMPRA_PRODUTO---------------------------------------------------
/*compra 1 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 1);

/*compra 2 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 2);
/*compra 2 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 2);

/*compra 3 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 3);
/*compra 3 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 3);
/*compra 3 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 3);

/*compra 4 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 4);
/*compra 4 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 4);
/*compra 4 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 4);
/*compra 4 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (4, 4);

/*compra 5 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 5);
/*compra 5 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 5);
/*compra 5 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 5);
/*compra 5 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (4, 5);
/*compra 5 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (5, 5);

/*compra 6 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 6);
/*compra 6 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 6);
/*compra 6 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 6);
/*compra 6 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (4, 6);
/*compra 6 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (5, 6);
/*compra 6 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (6, 6);

/*compra 7 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 7);
/*compra 7 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 7);
/*compra 7 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 7);

/*compra 8 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 8);
/*compra 8 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 8);

/*compra 9 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 9);
/*compra 9 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 9);
/*compra 9 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (5, 9);

/*compra 10 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 10);
/*compra 10 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 10);
/*compra 10 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 10);
/*compra 10 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (4, 10);

/*compra 11 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 11);
/*compra 11 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (2, 11);
/*compra 11 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (3, 11);
/*compra 11 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (4, 11);
/*compra 11 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (5, 11);

/*compra 12 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (1, 12);

/*compra 13 */ INSERT INTO compra_produto (produto_id, compra_id) VALUES (5, 13);