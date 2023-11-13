package co.edu.unbosque.model;


import java.util.Properties;

import co.edu.unbosque.model.persistence.ClienteDao;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class AdminCliente {
	
	private ClienteDao dao;
	
	
	public AdminCliente() {
		dao = new ClienteDao();
	}





	public void Correo(String correo, String accion, String nombre) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true"); 

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sophidrogueria@gmail.com", "Sophi123*");
			}
		});

		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sophidrogueria@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
			message.setSubject("Confirmacion de accion");
			message.setText("Se realizo" + accion + "por la persona " + nombre);

		
			Transport.send(message);

			System.out.println("El correo ha sido enviado con éxito.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public boolean insertar(ClienteDTO dto) {
		String accion = "Agregar nuevo usuario";

		if (dao.create(DataMapper.fromDTO2Entityc(dto)) != false) {

		}
	
		return false;
	}

	public void listar() {
		System.out.println(dao.findAll().toString());

	}


	}

