INSERT INTO BT_TELEFONE (ID_TELEFONE, DDI_TELEFONE, DDD_TELEFONE, NR_TELEFONE) 
VALUES (101, '+55', 11, '945623687');

INSERT INTO BT_TELEFONE (ID_TELEFONE, DDI_TELEFONE, DDD_TELEFONE, NR_TELEFONE) 
VALUES (102, '+55', 32, '993673774');

INSERT INTO BT_TELEFONE (ID_TELEFONE, DDI_TELEFONE, DDD_TELEFONE, NR_TELEFONE) 
VALUES (103, '+55', 62, '994562233');



--



INSERT INTO BT_GENERO (ID_GENERO, DESC_GENERO, NM_GENERO) 
VALUES (1, 'Descrição do gênero Masculino.', 'Masculino');

INSERT INTO BT_GENERO (ID_GENERO, DESC_GENERO, NM_GENERO) 
VALUES (2, 'Descrição do gênero Feminino.', 'Feminino');

INSERT INTO BT_GENERO (ID_GENERO, DESC_GENERO, NM_GENERO) 
VALUES (3, 'Descrição do gênero Outro.', 'Outro');



--



INSERT INTO BT_CLIENTE (ID_CLIENTE, CPF_CLIENTE, NM_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE, DT_NASCIMENTO_CLIENTE, ESTADO_CIVIL_CLIENTE, DT_CADASTRO, DT_EXCLUSAO, ID_GENERO, ID_TELEFONE) 
VALUES (101, '76883476409', 'João Silva', 'joao.silva@email.com', 'silva@3457', to_date('2004-04-11', 'YYYY-MM-DD'), 'CASADO', SYSDATE, null, 1, 101);

INSERT INTO BT_CLIENTE (ID_CLIENTE, CPF_CLIENTE, NM_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE, DT_NASCIMENTO_CLIENTE, ESTADO_CIVIL_CLIENTE, DT_CADASTRO, DT_EXCLUSAO, ID_GENERO, ID_TELEFONE) 
VALUES (102, '87697234407', 'Maria Santos', 'maria.santos@email.com', 'santos@9346', to_date('1992-03-22', 'YYYY-MM-DD'), 'CASADO', SYSDATE, null, 2, 102);

INSERT INTO BT_CLIENTE (ID_CLIENTE, CPF_CLIENTE, NM_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE, DT_NASCIMENTO_CLIENTE, ESTADO_CIVIL_CLIENTE, DT_CADASTRO, DT_EXCLUSAO, ID_GENERO, ID_TELEFONE) 
VALUES (103, '45927780306', 'Fernando Dias', 'fernando.dias@email.com', 'dias@7334', to_date('2002-11-03', 'YYYY-MM-DD'), 'SOLTEIRO', SYSDATE, null, 3, 103);



--



INSERT INTO BT_PRODUTO (ID_PRODUTO, IMG_PRODUTO, NM_PRODUTO, DESC_PRODUTO, VL_PRODUTO, DT_FAB_PRODUTO, DT_VALIDADE, DT_CADASTRO) 
VALUES (101, '/caminho/para/a/imagem/do/shampoo.png', 'Shampoo', 'Descrição para o shampoo...', 40.50, to_date('2024-01-22', 'YYYY-MM-DD'), to_date('2024-07-22', 'YYYY-MM-DD'), SYSDATE);

INSERT INTO BT_PRODUTO (ID_PRODUTO, IMG_PRODUTO, NM_PRODUTO, DESC_PRODUTO, VL_PRODUTO, DT_FAB_PRODUTO, DT_VALIDADE, DT_CADASTRO) 
VALUES (102, '/caminho/para/a/imagem/do/protetor.png', 'Protetor Solar', 'Descrição para o protetor solar...', 30.50, to_date('2024-03-02', 'YYYY-MM-DD'), to_date('2024-09-02', 'YYYY-MM-DD'), SYSDATE);

INSERT INTO BT_PRODUTO (ID_PRODUTO, IMG_PRODUTO, NM_PRODUTO, DESC_PRODUTO, VL_PRODUTO, DT_FAB_PRODUTO, DT_VALIDADE, DT_CADASTRO) 
VALUES (103, '/caminho/para/a/imagem/do/perfume.png', 'Perfume', 'Descrição para o perfume...', 80.50, to_date('2024-06-13', 'YYYY-MM-DD'), to_date('2025-06-13', 'YYYY-MM-DD'), SYSDATE);



