package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS_DROGUERIA")
public class Usuarios_drogueria {
	@Id
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String user_password;
	private boolean administrador;
	private boolean cta_bloqueada;

	public Usuarios_drogueria() {
		// TODO Auto-generated constructor stub
	}

	public Usuarios_drogueria(int id, String nombre, String apellido, String email, String user_password,
			boolean administrador, boolean cta_bloqueada) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.user_password = user_password;
		this.administrador = administrador;
		this.cta_bloqueada = cta_bloqueada;
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

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public boolean isCta_bloqueada() {
		return cta_bloqueada;
	}

	public void setCta_bloqueada(boolean cta_bloqueada) {
		this.cta_bloqueada = cta_bloqueada;
	}

	@Override
	public String toString() {
		return "Usuarios_drogueria [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", user_password=" + user_password + ", administrador=" + administrador + ", cta_bloqueada="
				+ cta_bloqueada + "]";
	}
}
