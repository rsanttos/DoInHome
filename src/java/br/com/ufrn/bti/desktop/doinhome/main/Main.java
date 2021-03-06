package br.com.ufrn.bti.desktop.doinhome.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.dao.PessoaDAO;
import br.com.ufrn.bti.desktop.doinhome.dao.TarefaDAO;
import br.com.ufrn.bti.desktop.doinhome.dao.UsuarioDAO;
import br.com.ufrn.bti.desktop.doinhome.dominio.Pessoa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;

public class Main {

	public static void main(String[] args) throws ParseException {
		Pessoa p = new Pessoa();
		Usuario u = new Usuario();
		Tarefa t = new Tarefa();
		
		p.setNome("Ramon");
		p.setSexo('M');
		p.setCpf("10904368408");
		p.setDataNascimento(new Date());
		
		u.setLogin("ramon");
		u.setPessoa(p);
		
		String dataLimite = "2016-12-15";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date d = sdf.parse(dataLimite);
		
		t.setDescricao("Tarefa Legal");
		t.setAtiva(true);
		t.setDataCriacao(new Date());
		t.setDataLimite(d);
		t.setUsuario(u);
		t.setValor(50);
		
		PessoaDAO pDao = new PessoaDAO();
		UsuarioDAO uDao = new UsuarioDAO();
		TarefaDAO tDao = new TarefaDAO();
		
//		pDao.salvarOuAtualizar(p);
		
//		uDao.salvarOuAtualizar(u);
		
		tDao.salvarOuAtualizar(t);		
	}

}
