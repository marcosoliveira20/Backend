CREATE TABLE  IF NOT EXISTS cliente (
    id INT NOT NULL AUTO_INCREMENT,

    data_cadastro DATE,
    email VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);