package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.beans.Livro;
import br.com.fiap.conexoes.ConexaoFactory;

public class LivroDAO {

	public Connection minhaConexao;
	
	public LivroDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	//insert
	public String inserir (Livro livro) throws SQLException {
		
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into T_FIAP_LIVRO values(?, ?, ?, ?, ?) ");
		
		stmt.setInt(1, livro.getCodigo());
		stmt.setString(2, livro.getTitulo());
		stmt.setString(3, livro.getEditora());
		stmt.setString(4, livro.getAutor());
		stmt.setDouble(5, livro.getValor());
		stmt.execute();		
		stmt.close();
		
		return "Livro cadastrado com sucesso!";
		
	}
	
	//delete
	public String deletar(Livro livro) throws SQLException {
		
		PreparedStatement stmt = minhaConexao.prepareStatement
				("delete from T_FIAP_LIVRO where CODIGO_LIVRO = ? ");
		
		stmt.setInt(1, livro.getCodigo());
		stmt.executeUpdate();
		stmt.close();
		
		return "Livro deletado com sucesso!";
	}
		
}
