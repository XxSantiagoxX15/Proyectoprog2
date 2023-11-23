package co.edu.unbosque.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import co.edu.unbosque.model.persistence.UsersDao;

public class AdminUser {
	private UsersDao dao;

	 private static final Logger logger = LogManager.getLogger(AdminUser.class);
	public AdminUser() {
		dao = new UsersDao();
	}

	public String encryptPassword(String password) {
		
		if (isValidPassword(password)) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");

				byte[] passwordBytes = password.getBytes();

				byte[] passwordHash = md.digest(passwordBytes);

				String hashedPassword = Base64.getEncoder().encodeToString(passwordHash);

				return hashedPassword;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			System.out.println("La contraseña no cumple con los requisitos mínimos.");
			return null;
		}
	}

	public boolean isValidPassword(String password) {
		
		if (password.length() < 8) {
			return false;
		}

		boolean hasUppercase = false;
		boolean hasSpecialCharacter = false;

		String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				hasUppercase = true;
			} else if (specialCharacters.indexOf(c) != -1) {
				hasSpecialCharacter = true;
			}
		}

		return hasUppercase && hasSpecialCharacter;
	}

	

	public void Correo(String correo, String accion, String nombre,String subject) {
		String host = "smtp.gmail.com";
		final String user = "sophidrogueria@gmail.com";// change accordingly
		final String password = "smyg onjr muay uwfa";// change accordingly

		String to = correo;

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(accion +nombre);
			

			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	public boolean insertar(UserDTO dto) {
		String accion = "Se acaba de crear un nuevo usuario con correo  ";
        String subject="Creacion de nuevo usuario en Shopy administrativo";
		if (dao.create(DataMapper.fromDTO2Entity(dto)) != false) {

		}
		 Correo(dto.getEmail(), accion, dto.getEmail(),subject);
		return false;
	}

	public void listar() {
		System.out.println(dao.findAll().toString());

	}
	
	
	public boolean login(String correo, String clave) {
	    UserDTO dto = DataMapper.fromEntity2DTO(dao.findbyemail(correo));

	    // Obtener el contador de intentos fallidos de la sesión
	    Integer intentosFallidos = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("intentosFallidos");

	    // Si no existe, inicializarlo
	    if (intentosFallidos == null) {
	        intentosFallidos = 0;
	    }

	    System.out.println("Intentos fallidos antes: " + intentosFallidos);

	    if (dto != null && correo.equals(dto.getEmail()) && encryptPassword(clave).equals(dto.getUser_password())) {
	        if (!dto.isAdministrador()) {
	            if (dto.isCta_bloqueada()) {
	                System.out.println("La cuenta está bloqueada.");
	                return false;
	            }

	            // Restablecer el contador de intentos fallidos
	            intentosFallidos = 0;
	        }

	        // Almacenar el correo en la sesión
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioCorreo", correo);

	        // Limpiar el contador de intentos fallidos al iniciar sesión exitosamente
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("intentosFallidos", 0);

	        System.out.println("Intentos fallidos después: " + intentosFallidos);

	        return true;
	    } else {
	        // Verificar si el usuario es administrador antes de bloquear la cuenta
	        if (!dto.isAdministrador()) {
	            // Bloquear la cuenta solo si no es un administrador
	            dto.setCta_bloqueada(true);
	            System.out.println("La cuenta ha sido bloqueada.");

	            // Actualizar la cuenta bloqueada en la base de datos
	            dao.updateCuentaBloqueadaByEmail(correo, true);
	        }

	        // Actualizar el contador de intentos fallidos en la sesión
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("intentosFallidos", intentosFallidos);

	        return false;
	    }
	}
	
	public UserDTO buscar(String email) {
	UserDTO DTO=	DataMapper.fromEntity2DTO(dao.findbyemail(email));
	return DTO;
	}
}