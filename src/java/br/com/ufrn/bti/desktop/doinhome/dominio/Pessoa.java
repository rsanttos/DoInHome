package br.com.ufrn.bti.desktop.doinhome.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
@Entity
@Table(name="pessoa", schema="public")
public class Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PESSOA")
	@SequenceGenerator(name="SEQ_PESSOA", schema = "public", sequenceName="id_pessoa", allocationSize=1)
	private int id;
	public String cpf;
	public String nome;
	public String email;
	public Date dataNascimento;
	public char sexo;
	
	public Pessoa(){
		
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
	
	public String getCpf() {
		return cpf;
	}
	
	public StringProperty getCpfProperty() {
		return new SimpleStringProperty(this.cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public StringProperty getNomeProperty() {
		return new SimpleStringProperty(this.nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public ObjectProperty<Date> getDataNascimentoProperty() {
		return new SimpleObjectProperty<Date>(this.dataNascimento);
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}
	
	public StringProperty getSexoProperty() {
		return new SimpleStringProperty(Character.toString(this.sexo));
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}
	
	public StringProperty getEmailProperty() {
		return new SimpleStringProperty(this.email);
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
}