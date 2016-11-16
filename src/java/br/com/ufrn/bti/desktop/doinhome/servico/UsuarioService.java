package br.com.ufrn.bti.desktop.doinhome.servico;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.doinhome.dao.UsuarioDAO;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDao;
	
	public UsuarioService(){
		usuarioDao = new UsuarioDAO();
	}
	
	public void salvarOuAtualizar(Usuario usuario){
		usuarioDao.salvarOuAtualizar(usuario);
	}
	
	public void deletar(Usuario usuario){
		usuarioDao.deletar(usuario);
	}
	
	public List<Usuario> listar(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		return usuarios;
	}
	
	public Usuario buscarPeloId(Usuario u){
		Usuario usuario = new Usuario();
		usuario = usuarioDao.buscarPeloId(u.getId());
		return usuario;
	}

	public Usuario buscarPeloLogin(Usuario u){
		Usuario usuario = new Usuario();
		usuario = usuarioDao.buscarPeloLogin(u.getLogin());
		return usuario;
	}
}
