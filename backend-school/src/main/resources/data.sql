INSERT INTO tb_state (name, acronym) VALUES ('São Paulo', 'SP');
INSERT INTO tb_state (name, acronym) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO tb_state (name, acronym) VALUES ('Minas Gerais', 'MG');

INSERT INTO tb_city (name, state_id) VALUES ('Tremembé', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Ubatuba', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Saquarema', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Rio das Ostras', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Contagem', 3);
INSERT INTO tb_city (name, state_id) VALUES ('Ourinhos', 3);

INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. Tamboré', 27, 'Apto 5A - Edifício Solar das Perdizes', 'Parque das Fontes', 1, '12120-000', -22.967773178297808, -45.54345712439077);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. Antônio Maria', 455, null, 'Solar da Mantiqueira', 1, '12120-000', -22.960207953457854, -45.54780329866982);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('Av. Vitória Régia, S/N', null, null, 'Flor do Vale', 1, '12120-000', -22.993049323948554, -45.541284701169275);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. José Higino de Siqueira', 460, null, 'Jardim Santana', 1, '12120-000', -22.973059966800275, -45.54425624157824);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. Galeão Coutinho', 275, 'Apto 31 - Edifício Laura', 'Itaguá', 2, '11680-000', -23.456245716948693, -45.06379298318256);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. Barra Seca', 170, 'Apto 15A - Edifício Recanto das Palmeiras', 'Perequê-Açu', 2, '11680-000', -23.415676541408185, -45.063803119477356);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. Paul Harris', 40, null, 'Praia Grande' , 2, '11680-000', -23.469873699240452, -45.06625559228154);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('R. Conceição', 844, null, 'Centro', 2, '11680-000', -23.43400515062424, -45.07809450301578);
INSERT INTO tb_address (street, number, complement, neighbourhood, city_id, zip_code, latitude, longitude) VALUES ('Av. Rio Grande do Sul', 600, null, 'Centro', 2, '11680-000', -23.439944563983158, -45.08062257324033);

INSERT INTO tb_school (name, category, total_students_needing_help, address_id) VALUES ('EE Capitão Deolindo de Oliveira Santos', 0, 1, 8);
INSERT INTO tb_school (name, category, total_students_needing_help, address_id) VALUES ('EM Presidente Tancredo de Almeida Neves', 0, 1, 9);
INSERT INTO tb_school (name, category, total_students_needing_help, address_id) VALUES ('EE Teixeira Pombo Comendador', 1, 1, 3);

INSERT INTO tb_user (email, password, address_id) VALUES ('donor1@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 1);
INSERT INTO tb_user (email, password, address_id) VALUES ('donor2@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 4);
INSERT INTO tb_user (email, password, address_id) VALUES ('donor3@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 6);
INSERT INTO tb_user (email, password, address_id) VALUES ('responsible1@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 2);
INSERT INTO tb_user (email, password, address_id) VALUES ('responsible2@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 5);
INSERT INTO tb_user (email, password, address_id) VALUES ('responsible3@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 7);

INSERT INTO tb_role (authority) VALUES ('DONOR');
INSERT INTO tb_role (authority) VALUES ('RESPONSIBLE');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Apontador com depósito', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Apontador sem depósito', 1.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caderno universitário 96 folhas', 5.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caderno universitário 140 folhas', 7.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caderno universitário 200 folhas', 10.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caderno de desenho 100 folhas', 5.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caixa de lápis de cor 12 cores', 4.00, 'cx');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caixa de lápis de cor 24 cores', 7.00, 'cx');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caneta esferográfica preta', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caneta esferográfica azul', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caneta esferográfica vermelha', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Compasso', 3.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Corretivo escolar', 2.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Estojo pequeno', 3.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Estojo médio', 4.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Estojo grande', 5.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caneta marca texto amarela', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caneta marca texto rosa', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Caneta marca texto verde', 1.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Pasta Catálogo com 50 folhas', 9.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Régua 30cm acrílico', 2.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Tesoura sem ponta', 4.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Borracha branca', 0.50, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Cola bastão', 2.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Cola líquida', 2.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Lápis preto n2', 1.00, 'un');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Resma papel A4 200 folhas', 10.00, 'pct');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Giz de cera grande 12 cores', 2.50, 'cx');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Giz de cera grande 24 cores', 4.00, 'cx');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Guache 12 cores', 3.00, 'cx');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Guache 24 cores', 5.00, 'cx');
INSERT INTO tb_supply (name, avg_price, unity) VALUES ('Pasta catálogo com elástico', 5.00, 'un');

INSERT INTO tb_student (name, age, school_id, responsible_id, donor_id) VALUES ('Joaozinho da Silva', 13, 1, 5, 6);
INSERT INTO tb_student (name, age, school_id, responsible_id, donor_id) VALUES ('Mariazinha Albuquerque', 10, 2, 5, 1);
INSERT INTO tb_student (name, age, school_id, responsible_id, donor_id) VALUES ('Tiaguinho Malta', 9, 3, 2, 4);

INSERT INTO tb_supply_list (student_id, list_total_value) VALUES (1, 82.50);
INSERT INTO tb_supply_list (student_id, list_total_value) VALUES (2, 30.00);
INSERT INTO tb_supply_list (student_id, list_total_value) VALUES (3, 66.50);

INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 1, 1, 1.50);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 2, 2, 1.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 5, 1, 10.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 6, 3, 5.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 8, 5, 7.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 11, 2, 1.50);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (1, 15, 4, 4.00);

INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 1, 1, 1.50);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 2, 1, 1.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 5, 1, 10.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 6, 1, 5.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 8, 1, 7.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 11, 1, 1.50);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (2, 15, 1, 4.00);

INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 1, 2, 1.50);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 2, 1, 1.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 5, 3, 10.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 6, 1, 5.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 8, 2, 7.00);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 11, 1, 1.50);
INSERT INTO tb_supply_list_item (supply_list_id, supply_id, quantity, price) VALUES (3, 15, 3, 4.00);





