package br.com.ufrn.bti.desktop.doinhome.views;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.servico.UsuarioService;

public class GenericController {
	private Usuario usuarioLogado;
	private UsuarioService usuarioService;
	
	
	public Usuario buscarUsuarioLogado(String login) {
		Usuario usuarioAux = new Usuario();
		usuarioAux = usuarioService.buscarPeloLogin(login) ;
		if(usuarioAux != null){
			usuarioLogado = usuarioAux;
		}
		return usuarioLogado;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
