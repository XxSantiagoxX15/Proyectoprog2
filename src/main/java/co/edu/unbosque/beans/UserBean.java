package co.edu.unbosque.beans;

import java.io.IOException;

import co.edu.unbosque.model.AdminUser;

import co.edu.unbosque.model.UserDTO;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;



@Named
@RequestScoped
public class UserBean {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String user_password;
	private String admin;
	private boolean administrador;
	private boolean cta_bloqueada;
    private String mensaje;
    private boolean mostrarDialogo = false;
    private boolean credencialesIncorrectas = false;
	private AdminUser adminUser;
   private UserDTO userDto;
   
   public UserBean() {
	   adminUser = new AdminUser();
	
}
  
  
   
   public void crear() {
	
       adminUser = new AdminUser();

       if ("Si".equalsIgnoreCase(admin)) {
           administrador = true;
       } else {
           administrador = false;
       }
       if(adminUser. isValidPassword(user_password)== true) {
    	   userDto = new UserDTO(id, nombre, apellido, email, adminUser.encryptPassword(user_password), administrador, false);
           adminUser.insertar(userDto);
           System.out.println("se insertó bien");
       }else {
    	   System.out.println("la contraseña no cumple con los requisitos");
       }

     
   }
   

   public void login() {
	    String mensajeLogin = adminUser.login(email, user_password);


	    if (mensajeLogin.equals("Inicio de sesión exitoso")) {
	        try {
	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            ec.redirect("home.xhtml");
	            return;  // Importante: salir del método después de la redirección exitosa
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // En este punto, el inicio de sesión no fue exitoso, así que se establecerá el mensaje de acuerdo a la lógica
	    if (mensajeLogin.equals("La cuenta está bloqueada.") || mensajeLogin.equals("Se ha excedido el límite de intentos fallidos. La cuenta ha sido bloqueada.")) {
	        mensaje = "La cuenta se encuentra bloqueada";
	    } else if (mensajeLogin.equals("Credenciales incorrectas.") || mensajeLogin.startsWith("Inicio de sesión fallido.")) {
	        mensaje = "Se equivocó con sus credenciales, algo está mal";
	    } else {
	        // Otros posibles mensajes de error
	        mensaje = "Tuvo un error al iniciar sesión";
	    }

	  
	    System.out.println("Estado de mensaje: " + mensaje);

	   
	}
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public boolean isCta_bloqueada() {
	return cta_bloqueada;
}
public void setCta_bloqueada(boolean cta_bloqueada) {
	this.cta_bloqueada = cta_bloqueada;
}
public UserDTO getUserDto() {
	return userDto;
}
public void setUserDto(UserDTO userDto) {
	this.userDto = userDto;
}
public String getAdmin() {
	return admin;
}
public void setAdmin(String admin) {
	this.admin = admin;
}



public boolean isAdministrador() {
	return administrador;
}



public void setAdministrador(boolean administrador) {
	this.administrador = administrador;
}







public AdminUser getAdminUser() {
	return adminUser;
}



public void setAdminUser(AdminUser adminUser) {
	this.adminUser = adminUser;
}



public boolean isMostrarDialogo() {
	return mostrarDialogo;
}



public void setMostrarDialogo(boolean mostrarDialogo) {
	this.mostrarDialogo = mostrarDialogo;
}



public boolean isCredencialesIncorrectas() {
	return credencialesIncorrectas;
}



public void setCredencialesIncorrectas(boolean credencialesIncorrectas) {
	this.credencialesIncorrectas = credencialesIncorrectas;
}



public String getMensaje() {
	return mensaje;
}



public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
} 
}
