package br.com.ufrn.bti.desktop.doinhome.thread;

import java.util.Date;

import br.com.ufrn.bti.desktop.doinhome.util.EnviaEmail;

public class ThreadEmail extends Thread {
	
	private String emailDestinatario;
	private String nomeDestinatario;
	private String descricaoTarefa;
	private int valorTarefa;
	private Date dataLimite;
	
	public ThreadEmail(String emailDestinatario, String nomeDestinatario, String descricaoTarefa, int valorTarefa,
			Date dataLimite) {
		super();
		this.emailDestinatario = emailDestinatario;
		this.nomeDestinatario = nomeDestinatario;
		this.descricaoTarefa = descricaoTarefa;
		this.valorTarefa = valorTarefa;
		this.dataLimite = dataLimite;
	}
	
	public void enviaEmailNovaTarefa(){
		EnviaEmail.enviarEmailNotificacaoNovaTarefa("DoInHome", emailDestinatario, nomeDestinatario, descricaoTarefa, valorTarefa, dataLimite);
	}
	
	@Override
	public void run() {
		try {
			enviaEmailNovaTarefa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
