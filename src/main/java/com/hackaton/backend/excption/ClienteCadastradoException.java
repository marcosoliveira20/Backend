package com.hackaton.backend.excption;

public class ClienteCadastradoException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteCadastradoException( String login ){
        super("Usuário já cadastrado para o login " + login);
    }
}