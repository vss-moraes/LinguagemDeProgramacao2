package gerenciador;

import java.util.List;
import java.util.Scanner;

import dao.UsuarioDao;
import modelo.Usuario;

public class GerenciadorUsuarios {
	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDao();
		Scanner leitor = new Scanner(System.in);
		int selecao = 0;
		
		do {
			System.out.print("--------------------"
					         + "\nSelecione uma opção:\n"
					         + "\n1 - Adicionar Usuario"
					         + "\n2 - Listar Usuarios"
					         + "\n3 - Editar Usuario"
					         + "\n4 - Remover Usuario"
					         + "\n5 - Sair"
					         + "\nOpção: ");
			selecao = Integer.parseInt(leitor.nextLine());
			
			switch (selecao) {
			case 1:
				Usuario usuario = new Usuario();
				System.out.print("Nome: ");
				usuario.setNome(leitor.nextLine());
				System.out.print("Email: ");
				usuario.setEmail(leitor.nextLine());
				System.out.print("Senha: ");
				usuario.setSenha(leitor.nextLine());
				
				if (usuarioDao.adicionaUsuario(usuario))
					System.out.println("Usuario adicionado com sucesso");
				else
					System.out.println("Não foi possível adicionar o usuario");
				break;
			
			case 2:
				List<Usuario> usuarios = usuarioDao.getListaUsuarios();
				
				
				System.out.println("--------------------------------------------------------------------------------------------------");
			    System.out.printf("%5s %30s %40s %20s", "ID", "NOME", "EMAIL", "SENHA");
			    System.out.println();
			    System.out.println("--------------------------------------------------------------------------------------------------");
			    for(Usuario u: usuarios){
			        System.out.format("%5s %30s %40s %20s",
			                u.getId(), u.getNome(), u.getEmail(), u.getSenha());
			        System.out.println();
			    }
			    System.out.println("--------------------------------------------------------------------------------------------------");
			    break;
			
			case 3:
				System.out.print("Qual usuario deseja editar? ");
				Long editarId = Long.parseLong(leitor.nextLine());
				Usuario editar = usuarioDao.getUsuario(editarId);
				
				if (editar.getId() != null) {
					System.out.println("--------------------------------");
					System.out.print("Nome: ");
					editar.setNome(leitor.nextLine());
					System.out.print("Email: ");
					editar.setEmail(leitor.nextLine());
					System.out.print("Senha: ");
					editar.setSenha(leitor.nextLine());
					
					if (usuarioDao.editaUsuario(editar))
						System.out.println("Usuario alterado com sucesso");
					else
						System.out.println("Não foi possível editar o usuario");
				}
			    break;
			
			case 4:
				System.out.print("Qual usuario deseja remover? ");
				Long removerId = Long.parseLong(leitor.nextLine());
				Usuario remover = usuarioDao.getUsuario(removerId);
				
				if (remover.getId() != null) {
					if (usuarioDao.removeUsuario(remover))
						System.out.println("Usuario removido");
					else
						System.out.println("Não foi possivel remover o usuario");
				} else {
					System.out.println("Usuario não encontrado");
				}
				break;
			case 5:
				leitor.close();
				break;
			default:
				System.out.println("Opção Inválida");
			}
		} while (selecao != 5);
	}

}
