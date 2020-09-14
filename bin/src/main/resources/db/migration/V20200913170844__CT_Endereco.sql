CREATE TABLE IF NOT EXISTS endereco (
    id INT NOT NULL AUTO_INCREMENT ,

    bairro VARCHAR(255) NOT NULL,
    data_cadastro DATE,
    fk_restaurante INT NOT NULL,
    numero INT NOT NULL,
    rua VARCHAR(255) NOT NULL,

	 FOREIGN KEY (fk_restaurante) REFERENCES restaurante(id),

	 PRIMARY KEY (id)
);