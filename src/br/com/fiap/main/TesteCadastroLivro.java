package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Livro;
import br.com.fiap.dao.LivroDAO;

public class TesteCadastroLivro {

	//texto
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	//inteiro
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	//real
	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//instanciar objetos
		LivroDAO dao = new LivroDAO();
		
		Livro objLivro = new Livro();
		
		//entradas
		objLivro.setCodigo(inteiro("Digite o codigo: "));
		objLivro.setTitulo(texto("Digite o titulo do livro: "));
		objLivro.setEditora(texto("Digite a editora: "));
		objLivro.setAutor(texto("Digite o autor do livro: "));
		objLivro.setValor(real("Digite o valor do livro: "));
		
		System.out.println(dao.inserir(objLivro));
	}

}
