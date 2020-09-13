CREATE TABLE IF NOT EXISTS restaurante (
    id INT NOT NULL AUTO_INCREMENT,

    nome VARCHAR(255) NOT NULL,
    data_cadastro DATE,
    email VARCHAR(255) NOT NULL,
    hora_abertura VARCHAR(255) NOT NULL,
    hora_fechamento VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);