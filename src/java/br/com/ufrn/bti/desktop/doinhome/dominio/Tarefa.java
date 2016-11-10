package br.com.ufrn.bti.desktop.doinhome.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tarefa", schema="public")
public class Tarefa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TAREFA")
	@SequenceGenerator(name="SEQ_TAREFA", schema = "public", sequenceName="id_tarefa", allocationSize=1)
	private int id;
	
	private String descricao;
	
	private Date dataCriacao;
	private Date dataLimite;
	private Date dataFinalizacao;
	
	private int valor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Tarefa (){
		
	}
	
	public Tarefa(String descricao, Date dataCriacao, Date dataLimite, int valor, Usuario usuario) {
		super();
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataLimite = dataLimite;
		this.valor = valor;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
