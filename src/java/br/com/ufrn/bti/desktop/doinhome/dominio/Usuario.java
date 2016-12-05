package br.com.ufrn.bti.desktop.doinhome.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
@Entity
@Table(name="usuario", schema="public")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO")
	@SequenceGenerator(name="SEQ_USUARIO", schema = "public", sequenceName="id_usuario", allocationSize=1)
	private int id;
	private String login;
	private String senha;
	private String permissao;
	private boolean ativo;	
	private boolean logado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public ObjectProperty<Integer> getIdProperty() {
		return new SimpleIntegerProperty(this.id).asObject();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public StringProperty getLoginProperty() {
		return new SimpleStringProperty(this.login);
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public StringProperty getSenhaProperty() {
		return new SimpleStringProperty(this.senha);
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPermissao() {
		return permissao;
	}
	
	public StringProperty getPermissaoProperty() {
		return new SimpleStringProperty(this.permissao);
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isLogado() {
		return logado;
	}
	
	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
	@Override
    public String toString() {
        return this.getPessoa().getNome();
    }
}

