package com.hackaton.backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hackaton.backend.model.entity.Restaurante;

public class InnerJoin {

	public static void listarRestaurante(int fk_restaurante) throws Exception {
		ArrayList<Restaurante> colecaoRestaurante = new ArrayList<>();
		String select = "select * from restaurante inner join endereco on restaurante.id =" + fk_restaurante;

		Connection conectar = ConnectionFactory.obtemConexao();
		PreparedStatement pst = conectar.prepareStatement(select);
		ResultSet resultado = pst.executeQuery();

		while (resultado.next()) {
			Restaurante restaurante = new Restaurante();
			System.out.println(resultado.toString());
			colecaoRestaurante.add(restaurante);
		}
		
	}

}
