package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.factory.ConectionFactoryPool;
import br.com.fiap.model.Categoria;

public class CategoriaController {
	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConectionFactoryPool().getConnection();
		this.categoriaDAO = new CategoriaDAO(connection);
	}
	public List<Categoria> listarTodas() throws SQLException{
		return this.categoriaDAO.listarTodas();
		
	}
	public List<Categoria> listarComProduto() throws SQLException{
		return this.categoriaDAO.listarComProduto();
		
	}
}
