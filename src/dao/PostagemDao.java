package dao;

import java.util.List;

import modelo.Postagem;
import modelo.Usuario;

public class PostagemDao {
	
	
	public Postagem getPostagem(Long id) {
		String sql = "SELECT * FROM postagens WHERE id = ?";
		
		return null;
	}
	
	public List<Postagem> getListaPostagens() {
		String sql = "SELECT * FROM postagens";
		
		return null;
	}
	
	public List<Postagem> getListaPostagensPorAutor(Usuario autor) {
		String sql = "SELECT * FROM postagens WHERE id_autor = ?";
		
		return null;
	}
	
	public boolean adicionaPostagem(Postagem postagem) {
		String sql = "INSERT INTO "
				   + "postagens (titulo, conteudo, id_autor, data_postagem, data_edicao) "
				   + "VALUES (?, ?, ?, ?, ?)";
		
		return false;
	}
	
	public boolean editaPostagem(Postagem postagem) {
		String sql = "UPDATE postagens "
				   + "SET titulo = ?, conteudo = ?, id_autor = ?, data_edicao = ? "
				   + "WHERE id = ?";
		
		return false;
	}
	
	public boolean removePostagem(Postagem postagem) {
		String sql = "DELETE FROM postagens WHERE id = ?";
		
		return false;
	}
}
