CREATE TABLE IF NOT EXISTS item (
    id INT AUTO_INCREMENT,

    data_cadastro DATE,
    fk_mesa INT NOT NULL,
    preco DOUBLE NOT NULL,
    nome VARCHAR(255) NOT NULL,

    FOREIGN KEY (fk_mesa) REFERENCES mesa(id),

    PRIMARY KEY (id)
);