package co.edu.unbosque.model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.edu.unbosque.model.persistence.CompraInventarioDao;
import co.edu.unbosque.model.persistence.ProductoDao;
import jakarta.faces.context.FacesContext;

/**
 * The AdminInventario class represents an administrator of the inventory
 * system.
 * It provides methods for managing the inventory, such as adding inventory and
 * sending email notifications.
 */
public class AdminInventario {
	private CompraInventarioDao dao;
	private ProductoDao daoproducto;
	private static final Logger logger = LogManager.getLogger(AdminInventario.class);

	public AdminInventario() {
		dao = new CompraInventarioDao();
		daoproducto = new ProductoDao();
	}

	public void correo(String correo, String accion, String nombre, String subject) {
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
			message.setText(accion + nombre);

			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public boolean ingresarinv(CompraInventarioDTO dto) {
		String accion = "Se acaba de agregar inventario de un producto por el usuario :";
		String subject = "Se acaba de agregar inventario ";
		String usuarioCorreo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioCorreo");
		correo(usuarioCorreo, accion, usuarioCorreo + " Y se ingreso el producto"
				+ daoproducto.findOne(dto.getProducto()).getNombre() + "con cantidad de " + dto.getCantidad_adquirida(),
				subject);
		return dao.create(DataMapper.fromDTO2Entityco(dto));

	}

}