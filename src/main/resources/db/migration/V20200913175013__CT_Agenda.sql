CREATE TABLE IF NOT EXISTS agenda (
    id INT AUTO_INCREMENT,

    data_cadastro DATE,
    fk_cliente INT NOT NULL,
    fk_restaurante INT NOT NULL,
    hora_comeco INT NOT NULL,
    hora_saida INT NOT NULL,
    quantidade_pessoas INT NOT NULL,

	 FOREIGN KEY (fk_cliente) REFERENCES cliente(id),
    FOREIGN KEY (fk_restaurante) REFERENCES restaurante(id),

    PRIMARY KEY (id)
);