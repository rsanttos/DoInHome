package br.com.ufrn.bti.desktop.doinhome.servico;

import br.com.ufrn.bti.desktop.doinhome.dao.PessoaDAO;
import br.com.ufrn.bti.desktop.doinhome.dominio.Pessoa;

public class PessoaService {
	private PessoaDAO pessoaDao;
	
	public PessoaService(){
		pessoaDao = new PessoaDAO();
	}
	
	public void salvarOuAtualizar(Pessoa p){
		if(p != null){
			pessoaDao.salvarOuAtualizar(p);
		}
	}
}
