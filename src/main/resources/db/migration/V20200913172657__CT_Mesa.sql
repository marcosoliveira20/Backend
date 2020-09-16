CREATE TABLE IF NOT EXISTS mesa (
    id INT AUTO_INCREMENT,

    data_cadastro DATE,
    fk_restaurante INT NOT NULL,
    fechada varchar(255) ,
    numero_mesa INT NOT NULL,

    FOREIGN KEY (fk_restaurante) REFERENCES restaurante(id),

    PRIMARY KEY (id)
);