package br.com.ufrn.bti.desktop.doinhome.main;

import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dao.PessoaDAO;
import br.com.ufrn.bti.desktop.doinhome.dao.UsuarioDAO;
import br.com.ufrn.bti.desktop.doinhome.dominio.Pessoa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;

public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		Usuario u = new Usuario();
		Tarefa t = new Tarefa();
		
		p.setNome("Ramon");
		p.setSexo('M');
		p.setCpf("10904368408");
		p.setDataNascimento(new Date());
		
		u.setLogin("ramon");
		u.setPessoa(p);
		
		t.setDescricao("Tarefa Teste");
		
		PessoaDAO pDao = new PessoaDAO();
		UsuarioDAO uDao = new UsuarioDAO();
		
		pDao.salvarOuAtualizar(p);
		
		uDao.salvarOuAtualizar(u);
	}

}
