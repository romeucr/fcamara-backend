INSERT INTO tb_user (id, is_active, email, senha) VALUES (1, true, 'romeu@email.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('DONOR');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);