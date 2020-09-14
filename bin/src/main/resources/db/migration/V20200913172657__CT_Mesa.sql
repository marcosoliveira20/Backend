CREATE TABLE IF NOT EXISTS mesa (
    id INT NOT NULL AUTO_INCREMENT,

    data_cadastro DATE,
    fk_restaurante INT NOT NULL,
    numero_mesa VARCHAR(255) NOT NULL,

    FOREIGN KEY (fk_restaurante) REFERENCES restaurante(id),

    PRIMARY KEY (id)
);