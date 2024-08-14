package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Produto;

public class CategoriaDAO {
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listarTodas() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();
			String sql = "select * from categoria";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt(1));
				categoria.setNome(rs.getString(2));
				categorias.add(categoria);
			}
			rs.close();
			stmt.close();
			return categorias;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	public List<Categoria> listarComProduto() {
			Categoria categoriaAtual = null;
			List<Categoria> categorias = new ArrayList<Categoria>();
			String sql = "select c.idCategoria, c.nome, p.idProduto, p.nome, p.preco,p.descricao, p.idCategoria from categoria c inner join produto p on c.idCategoria  order by c.idCategoria";
			PreparedStatement stmt;
			try {
			stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				if (categoriaAtual == null || !categoriaAtual.getNome().equals(rs.getString(2))) {
					Categoria categoria = new Categoria();
					categoria.setIdCategoria(rs.getInt(1));
					categoria.setNome(rs.getString(2));
					categorias.add(categoria);
					categoriaAtual = categoria;
				}
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt(3));
				produto.setNome(rs.getString(4));
				produto.setDescricao(rs.getString(5));
				produto.setPreco(rs.getDouble(6));
				produto.setIdCategoria(rs.getInt(7));
				categoriaAtual.adicionarProduto(produto);
			}
			rs.close();
			stmt.close();
			return categorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
