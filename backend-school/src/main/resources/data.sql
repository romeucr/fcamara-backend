INSERT INTO tb_user (id, is_active, email, senha) VALUES (1, true, 'romeu@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('RECEPTOR');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);

INSERT INTO tb_state (name, acronym) VALUES ('São Paulo', 'SP');
INSERT INTO tb_state (name, acronym) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO tb_state (name, acronym) VALUES ('Minas Gerais', 'MG');

INSERT INTO tb_city (name, state_id) VALUES ('Taubaté', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Ubatuba', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Saquarema', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Rio das Ostras', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Contagem', 3);
INSERT INTO tb_city (name, state_id) VALUES ('Ourinhos', 3);

INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code) VALUES ('R. Conceição', 844, null, 'Centro', 2, '11680-000');

INSERT INTO tb_school (name, category, total_students_needing_help, address_id) VALUES ('EE Capitão Deolindo de Oliveira Santos', 0, 15, 1);