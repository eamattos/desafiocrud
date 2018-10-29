CREATE TABLE aluno (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(128) NOT NULL,
  endereco VARCHAR(256) NOT NULL,
 
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO aluno (id, nome, endereco) VALUES (1, 'Alberto Santos', 'R. Dois, 2860 casa 1 - Palmira - MG');
INSERT INTO aluno (id, nome, endereco) VALUES (2, 'Bernardo Silva', 'R. Carlos Imbassahy, 123/Apto 101 - Niteroi - RJ');
INSERT INTO aluno (id, nome, endereco) VALUES (3, 'Kayke Nascimento', 'R. Johnatan Botelho, BL A - Cubango - Niteroi - RJ');

CREATE TABLE escola (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(128) NOT NULL,
  endereco VARCHAR(256) NOT NULL,
 
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO escola (id, nome, endereco) VALUES (1, 'Colégio Adventista', 'R. Dois, 2860 casa 1 - Rocha Miranda - RJ');
INSERT INTO escola (id, nome, endereco) VALUES (2, 'EE Hilario Ribeiro', 'R. Carlos Imbassahy, S/N - Sepetiba - RJ');

CREATE TABLE transporte_escolar (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(128) NOT NULL,
  cnpj VARCHAR(32),
 
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO transporte_escolar (id, nome, cnpj) VALUES (1, 'Van Tia Cotinha', '04.120.1010/0001-19811');
INSERT INTO transporte_escolar (id, nome, cnpj) VALUES (2, 'Van Tio Fabio', '01.321.9876/0001-4321');
