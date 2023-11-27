package co.edu.unbosque.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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

import co.edu.unbosque.model.persistence.ProductoDao;
import jakarta.faces.context.FacesContext;

public class AdminProducto {
	private ProductoDao dao;

	private static final Logger logger = LogManager.getLogger(AdminProducto.class);
	public AdminProducto() {
		dao = new ProductoDao();
		
	}

	public void correo(String correo, String accion, String nombre,String subject) {
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
	public ArrayList<ProductoDTO> listar(ProductoDTO productoDTO) {
	    ArrayList<Producto> productos = dao.findAll();
	    ArrayList<ProductoDTO> productosDTO = new ArrayList<>();
	    
	    for (Producto producto : productos) {

	        ProductoDTO dto= DataMapper.fromEntity2DTOp(producto);
	        productosDTO.add(dto);
	    }
	    
	    return productosDTO;
	}
	
	public ArrayList<ProductoDTO> listarxinventario(ProductoDTO productoDTO) {
	    ArrayList<Producto> productos = dao.findByInventory();
	    ArrayList<ProductoDTO> productosDTO = new ArrayList<>();
	    
	    for (Producto producto : productos) {

	        ProductoDTO dto= DataMapper.fromEntity2DTOp(producto);
	        productosDTO.add(dto);
	    }
	    
	    return productosDTO;
	}
	


	public List<ProductoDTO> listarxMasvendidos(ProductoDTO productoDTO) {
	    List<Object[]> productos = dao.findBybestseller();
	    List<ProductoDTO> productosDTO = new ArrayList<>();
	    
	    for (Object[] productoArray : productos) {
	       
	    	
	        String nombre = (String) productoArray[0];
	 
	       

	        BigInteger cantidad = (BigInteger) productoArray[2];

	        ProductoDTO dto = new ProductoDTO( nombre,cantidad);
	        productosDTO.add(dto);
	    }
	    
	    return productosDTO;
	}
	public boolean insertar(ProductoDTO dto) {
		String accion="Se acaba de insertar un nuevo producto por el usuario :";
		String subject="Se acaba de insertar un nuevo producto a la drogueria";
		String usuarioCorreo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioCorreo");
	
		
		dao.create(DataMapper.fromDTO2Entityp(dto));
		correo(usuarioCorreo,accion,usuarioCorreo,subject);
		return true;
	}
	
	public ProductoDTO buscar(int id) {
	    ProductoDTO producto =DataMapper.fromEntity2DTOp(dao.findOne(id));

	    if (producto != null) {
	       System.out.println("si pasa aca");
	        return producto;
	    } else {
	      System.out.println("Es nullo");
	        return null;
	    }
	}
	
	public boolean editar(int id,ProductoDTO dto) {
		
		if(dao.update(id, DataMapper.fromDTO2Entityp(dto))) {
			String accion="Se acaba de editar un nuevo producto por el usuario :";
			String subject="Se acaba de editar un producto a la drogueria";
			String usuarioCorreo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioCorreo");
			correo(usuarioCorreo,accion,usuarioCorreo,subject);
			return true;
		}else {
			System.out.println("no edita");
			return false;
		}
		
		
	}	public boolean editarInventario(int id,ProductoDTO dto) {
		
		if(dao.update(id, DataMapper.fromDTO2Entityp(dto))) {
			
			return true;
		}else {
			System.out.println("no edita");
			return false;
		}
		
		
	}
	public void eliminar(int id ) {
		if(dao.delete(id)) {
			String accion="Se acaba de eliminar un  producto por el usuario :";
			String subject="Se acaba de eliminar un producto a la drogueria";
			String usuarioCorreo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioCorreo");
			correo(usuarioCorreo,accion,usuarioCorreo,subject);
			System.out.println("Se elimino mi perro");
		}else {
			System.out.println("no se elimino");
		}
	}
}