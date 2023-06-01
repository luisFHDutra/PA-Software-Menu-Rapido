CREATE DATABASE menuRapido;

CREATE TABLE usuario (
  id_usuario integer PRIMARY KEY,
  nome varchar,
  "user" varchar,
  hash_code varchar,
  id_permissao integer
);

INSERT INTO usuario VALUES (1, 'Administrador', 'admin', '92668751', 1);

CREATE TABLE status_atendimento (
  id_status integer PRIMARY KEY,
  nome varchar
);

CREATE TABLE tipo_pagamento (
  id_tipo integer PRIMARY KEY,
  nome varchar
);

CREATE TABLE mesa (
  nro_mesa integer PRIMARY KEY,
  quant_lugares integer
);

CREATE TABLE categoria_produto (
  id_categoria integer PRIMARY KEY,
  nome varchar
);

CREATE TABLE produto (
  id_produto integer PRIMARY KEY,
  id_categoria integer,
  nome varchar,
  descricao varchar,
  pro_valor real
);

CREATE TABLE pedido (
  id_pedido integer PRIMARY KEY,
  nro_mesa integer,
  id_status integer,
  id_tipo integer
);

CREATE TABLE item_pedido (
  id_produto integer,
  id_pedido integer,
  quantidade integer,
  pro_valor real,
  PRIMARY KEY (id_produto, id_pedido)
);

CREATE TABLE user_permissao (
  id_permissao integer PRIMARY KEY,
  nome varchar
);

INSERT INTO user_permissao VALUES (1, 'Administrador');
INSERT INTO user_permissao VALUES (2, 'Usuário');
INSERT INTO user_permissao VALUES (3, 'Intermediário');

ALTER TABLE usuario ADD FOREIGN KEY (id_permissao) REFERENCES user_permissao (id_permissao);

ALTER TABLE produto ADD FOREIGN KEY (id_categoria) REFERENCES categoria_produto (id_categoria);

ALTER TABLE pedido ADD FOREIGN KEY (id_status) REFERENCES status_atendimento (id_status);

ALTER TABLE pedido ADD FOREIGN KEY (nro_mesa) REFERENCES mesa (nro_mesa);

ALTER TABLE pedido ADD FOREIGN KEY (id_tipo) REFERENCES tipo_pagamento (id_tipo);

ALTER TABLE item_pedido ADD FOREIGN KEY (id_produto) REFERENCES produto (id_produto);

ALTER TABLE item_pedido ADD FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido);

-- SELECT * FROM usuario;
-- SELECT * FROM status_atendimento;
-- SELECT * FROM tipo_pagamento;
-- SELECT * FROM mesa;
-- SELECT * FROM categoria_produto;
-- SELECT * FROM produto;
-- SELECT * FROM pedido;
-- SELECT * FROM item_pedido;
-- SELECT * FROM user_permissao;