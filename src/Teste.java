import java.util.ArrayList;
import java.util.List;

import lp2.dao.UsuarioDao;
import lp2.model.Usuario;

public class Teste {
	public static void main(String[] args) {
		Usuario usuario = new Usuario("Bruce Wayne", "bruce@wayne.com", "iambatman");
		UsuarioDao dao = new UsuarioDao();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		dao.adiciona(usuario);
		
		usuarios = dao.getLista();
		
		System.out.println("Depois de adicionar Bruce: " + usuarios);
		
		usuario = dao.getUsuario(1);
		
		System.out.println("Usuario com id 1: " + usuario);
		
		usuario.setSenha("minhanovasenha");
		dao.alteraUsuario(usuario);
		usuarios = dao.getLista();
		
		System.out.println("Após alteração da senha do usuario 1: " + usuarios);
		
		dao.removeUsuario(usuario);
		usuarios = dao.getLista();
		
		System.out.println("Após a remoção dod usuário 1: " + usuarios);
	}
}
