package br.com.ufrn.bti.desktop.doinhome.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.doinhome.dominio.Usuario;
import br.com.ufrn.bti.desktop.doinhome.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO {
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaUsuarios = session.createQuery("SELECT f FROM Usuario f").getResultList();
		session.close();
		return listaUsuarios;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Usuario buscarPeloId(int id) {
		Usuario usuario = new Usuario();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Usuario f WHERE f.id = :id");
        q.setInteger("id", id);
        try {			
        	usuario = (Usuario) q.getSingleResult(); 
		} catch (NoResultException e) {
			System.out.println("Nenhum usuário encontrado com esse id...");
			usuario = null;
		}
		session.close(); 
		return usuario;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Usuario buscarPeloLogin(String login) {
		Usuario usuario = new Usuario();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Usuario f WHERE f.login = :login");
        q.setString("login", login);
        try {
        	usuario = (Usuario) q.getSingleResult(); 
        } catch (NoResultException e) {
        	System.out.println("Nenhum usuário encontrado com esse login...");
        	usuario = null;
		}
		session.close();
		return usuario;
	}
}
