package br.com.ufrn.bti.desktop.doinhome.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.doinhome.dominio.Tarefa;
import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.util.HibernateUtil;

public class TarefaDAO extends GenericDAO {
	
	public TarefaDAO(){
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> listar(){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        listaTarefas = session.createQuery("SELECT f FROM Tarefa f").getResultList();
		session.close();
		return listaTarefas;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Tarefa buscarPeloId(int id) {
		Tarefa tarefa = new Tarefa();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Tarefa f WHERE f.id = :id");
        q.setInteger("id", id);
		tarefa = (Tarefa) q.getSingleResult(); 
		session.close(); 
		return tarefa;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasDeUmUsuario(Usuario usuario){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.usuario.id = :id_usuario");
        q.setInteger("id_usuario", usuario.getId());
        listaTarefas = q.getResultList();
		session.close();
		
		return listaTarefas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasConcluidas(){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.ativa = false");
        listaTarefas = q.getResultList();
		session.close();
		return listaTarefas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasConcluidasPorUsuario(Usuario usuario){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = false");
        q.setInteger("id_usuario", usuario.getId());
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasPorConcluir(){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.ativa = true AND t.dataLimite >= :dataHoje");
        q.setDate("dataHoje", new Date());
        listaTarefas = q.getResultList();
		session.close();
		return listaTarefas;
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasPorConcluirPorUsuario(Usuario usuario){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = true AND t.dataLimite >= "
        		+ ":dataHoje");
        q.setInteger("id_usuario", usuario.getId());
        q.setDate("dataHoje", new Date());
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasAtrasadas(){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.ativa = true AND t.dataLimite < :dataHoje");
        q.setDate("dataHoje", new Date());
        listaTarefas = q.getResultList();
		session.close();
		return listaTarefas;
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasAtrasadasPorUsuario(Usuario usuario){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = true AND t.dataLimite < "
        		+ ":dataHoje");
        q.setInteger("id_usuario", usuario.getId());
        q.setDate("dataHoje", new Date());
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}
	

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasAtivasIntervaloTempo(Date dataMin, Date dataMax){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.ativa = true AND t.dataLimite >= :dataMin AND t.dataLimite <= :dataMax");
        q.setDate("dataMin", dataMin);
        q.setDate("dataMax", dataMax);
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasInativasIntervaloTempo(Date dataMin, Date dataMax){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.ativa = false AND t.dataLimite >= :dataMin AND t.dataLimite <= :dataMax");
        q.setDate("dataMin", dataMin);
        q.setDate("dataMax", dataMax);
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}
	

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasAtivasUsuarioIntervaloTempo(Usuario usuario, Date dataMin, Date dataMax){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = true AND t.dataLimite >= :dataMin AND t.dataLimite <= :dataMax");
        q.setInteger("id_usuario", usuario.getId());
        q.setDate("dataMin", dataMin);
        q.setDate("dataMax", dataMax);       
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefasInativasUsuarioIntervaloTempo(Usuario usuario, Date dataMin, Date dataMax){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT t FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = false AND t.dataLimite >= :dataMin AND t.dataLimite <= :dataMax");
        q.setInteger("id_usuario", usuario.getId());
        q.setDate("dataMin", dataMin);
        q.setDate("dataMax", dataMax);
        listaTarefas = q.getResultList();
        session.close();
		return listaTarefas;
	}
	

	@SuppressWarnings("unchecked")
	public int somaPontuacaoTotalUsuario(Usuario usuario){
		int soma;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT SUM(t.valor) FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = false");
        q.setInteger("id_usuario", usuario.getId());
        soma = q.getFirstResult();
        session.close();
        return soma;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> somaPontuacaoTotal(){
		List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT u.login, SUM(t.valor) FROM Tarefa t JOIN t.id_usuario as usuario WHERE t.ativa = false GROUP BY u.login");
        listaTarefas = q.getResultList();
        session.close();
        return listaTarefas;
	}

	@SuppressWarnings("unchecked")
	public int somaPontuacaoUsuarioIntervaloTempo(Usuario usuario, Date dataMin, Date dataMax){
		int soma;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("SELECT SUM(t.valor) FROM Tarefa t WHERE t.usuario.id = :id_usuario AND t.ativa = false AND t.dataLimite >= :dataMin AND t.dataLimite <= :dataMax");
        q.setInteger("id_usuario", usuario.getId());
        q.setDate("dataMin", dataMin);
        q.setDate("dataMax", dataMax);
        soma = q.getFirstResult();
        session.close();
		return soma;
	}
}
