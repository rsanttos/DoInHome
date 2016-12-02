package br.com.ufrn.bti.desktop.doinhome.servico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ufrn.bti.desktop.doinhome.dao.TarefaDAO;
import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;

public class TarefaService {
	
	private TarefaDAO tarefaDao;
	
	public TarefaService(){
		tarefaDao = new TarefaDAO();
	}
	
	public void salvarOuAtualizar(Tarefa tarefa){
		if(tarefa != null){
			tarefaDao.salvarOuAtualizar(tarefa);
		}
	}
	
	public List<Tarefa> listar(){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.listar();
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasUsuario(Usuario usuario){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasDeUmUsuario(usuario);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public Tarefa buscarPeloId(Tarefa t){
		Tarefa tarefa = new Tarefa();
		tarefa = tarefaDao.buscarPeloId(t.getId());
		
		if(tarefa != null){
			return tarefa;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasConcluidas(){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasConcluidas();
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasPorConcluir(){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasPorConcluir();
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasAtrasadas(){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasAtrasadas();
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasConcluidasPorUsuario(Usuario usuario){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasConcluidasPorUsuario(usuario);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasPendentesUsuario(Usuario usuario){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasPorConcluirPorUsuario(usuario);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasAtrasadasUsuario(Usuario usuario){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasAtrasadasPorUsuario(usuario);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasPendentesIntervaloTempo(Date dataMin, Date dataMax){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasAtivasIntervaloTempo(dataMin, dataMax);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasConcluidasIntervaloTempo(Date dataMin, Date dataMax){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasInativasIntervaloTempo(dataMin, dataMax);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasPendentesUsuarioIntervaloTempo(Usuario usuario, Date dataMin, Date dataMax){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasAtivasUsuarioIntervaloTempo(usuario, dataMin, dataMax);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public List<Tarefa> listarTarefasConcluidasUsuarioIntervaloTempo(Usuario usuario, Date dataMin, Date dataMax){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscarTarefasInativasUsuarioIntervaloTempo(usuario, dataMin, dataMax);
		
		if(tarefas != null){
			return tarefas;
		} else {
			return null;
		}
	}
	
	public int somaPontuacaoTotalUsuario(Usuario usuario){
		int soma = tarefaDao.somaPontuacaoTotalUsuario(usuario);
		
		if(soma >= 0){
			return soma;
		} else {
			return -1;
		}
	}
	
	public int somaPontuacaoTotalUsuarioIntervaloTempo(Usuario usuario, Date dataMin, Date dataMax){
		int soma = tarefaDao.somaPontuacaoUsuarioIntervaloTempo(usuario, dataMin, dataMax);
		
		if(soma >= 0){
			return soma;
		} else {
			return -1;
		}
	}
}
