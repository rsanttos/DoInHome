package br.com.ufrn.bti.desktop.doinhome.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmail {
	public static void enviarEmailNotificacaoNovaTarefa(String nomeSistema, String to, String nomeUsuario,
			String descricaoTarefa, int valorTarefa, Date dataLimite) {
		String from = "no-reply@doinhome.com.br";
		String data = new String();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		data = dateFormat.format(dataLimite);

		String assunto = "[" + nomeSistema + "] Nova tarefa cadastrada para você!";
		String texto = "Prezado(a) " + nomeUsuario + ",\n" + "Você tem uma nova tarefa a ser feita em casa: \n\n"
				+ "O quê? " + descricaoTarefa + "\n" 
				+ "Até quando? " + data + "\n"
				+ "Quanto vale? " + valorTarefa + " pontos.\n"
				+ "\nCorra para fazer logo e ganhar todos os pontos!\n"
				+ "\nEste e-mail foi gerado automaticamente, por favor não responder. \n\nAtenciosamente, \nEquipe DoInHome.\n";
		enviaEmail(from, to, assunto, texto);
	}

	public static synchronized Session getSessionEmail() {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("doinhomeapp@gmail.com", "programacaodesktop");
			}
		});
		/** Ativa Debug para sessão */
		session.setDebug(true);
		return session;
	}

	public static void enviaEmail(String remetente, String destinatario, String assunto, String texto) {
		Session session = getSessionEmail();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remetente)); // Remetente
			Address[] toUser = InternetAddress // Destinatário(s)
					.parse(destinatario);
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);// Assunto
			message.setText(texto);
			/** Método para enviar a mensagem criada */
			Transport.send(message);
			System.out.println("E-mail enviado.");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
