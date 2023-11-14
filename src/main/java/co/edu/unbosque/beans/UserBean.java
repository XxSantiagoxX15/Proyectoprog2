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
	   
	  if(adminUser.login(id, user_password)==true) {
		  try {
	            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	            
	            ec.redirect("home.xhtml"); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        	
	        
		  
	  }else {
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales incorrectas"));
	  }
	   
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
}
