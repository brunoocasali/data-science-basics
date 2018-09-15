CREATE KEYSPACE "usuarios" WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 } ;

CREATE TABLE usuarios_by_email(id uuid, nome text, email text, PRIMARY KEY((email), id));
CREATE TABLE usuarios_by_ano(id uuid, ano int, nome text, email text, PRIMARY KEY((ano), id);

INSERT INTO usuarios_by_email(id, nome, email) VALUES (uuid(), 'Bruno', 'brunoocasali@gmail.com');
INSERT INTO usuarios_by_email(id, nome, email) VALUES (uuid(), 'Luiza', 'luiza@gmail.com');
INSERT INTO usuarios_by_email(id, nome, email) VALUES (uuid(), 'Marcel', 'marcel@gmail.com');
INSERT INTO usuarios_by_email(id, nome, email) VALUES (uuid(), 'Talita', 'talita@gmail.com');
INSERT INTO usuarios_by_email(id, nome, email) VALUES (uuid(), 'Tuanny', 'tuanny@gmail.com');


INSERT INTO usuarios_by_ano(id, ano, nome, email) VALUES (uuid(), 2012, 'Bruno', 'brunoocasali@gmail.com');
INSERT INTO usuarios_by_ano(id, ano, nome, email) VALUES (uuid(), 2013, 'Luiza', 'luiza@gmail.com');
INSERT INTO usuarios_by_ano(id, ano, nome, email) VALUES (uuid(), 2012, 'Marcela', 'marcela@gmail.com');
INSERT INTO usuarios_by_ano(id, ano, nome, email) VALUES (uuid(), 2014, 'Talita', 'talita@gmail.com');
INSERT INTO usuarios_by_ano(id, ano, nome, email) VALUES (uuid(), 2011, 'Tuanny', 'tuanny@gmail.com');


# PRIMARY KEY ((ano, mes), id) - clusterizacao
# O ano e o mes formam uma clusterizacao de dados (eh basicamente um agrupamento) nesse caso os grupos serao separados
# por nos diferentes

# PRIMARY KEY (ano, id) - chave composta
# nao tem agrupamento pois o ano se repete mas o id nao, entao nao havera agrupamento
