package co.edu.unbosque.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;

import jakarta.faces.context.FacesContext;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import co.edu.unbosque.model.persistence.UsersDao;

public class AdminUser {
	private UsersDao dao;


	public AdminUser() {
		dao = new UsersDao();
	}

	public String encryptPassword(String password) {
		// Verificar si la contraseña cumple con los criterios
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

	

	public void Correo(String correo, String accion, String nombre) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true"); // Habilita la autenticación

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sophidrogueria@gmail.com", "smyg onjr muay uwfa");
			}
		});

		try {
			// Crea un mensaje de correo
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sophidrogueria@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("santiagomelo15@hotmail.com"));
			message.setSubject("Confirmacion de accion");
			message.setText("Se realizo prueba 1" + "por la persona  sapo");

			// Envía el correo
			Transport.send(message);

			System.out.println("El correo ha sido enviado con éxito.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public boolean insertar(UserDTO dto) {
		String accion = "Agregar nuevo usuario";

		if (dao.create(DataMapper.fromDTO2Entity(dto)) != false) {

		}
		// Correo(dto.email(), accion, dto.nombre());
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

	        // Limpiar el contador de intentos fallidos al iniciar sesión exitosamente
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("intentosFallidos", 0);

	        System.out.println("Intentos fallidos después: " + intentosFallidos);

	        return true;
	    } else {
	        // Bloquear la cuenta
	        dto.setCta_bloqueada(true);
	        System.out.println("La cuenta ha sido bloqueada.");

	        // Actualizar la cuenta bloqueada en la base de datos
	        dao.updateCuentaBloqueadaByEmail(correo, true);

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
