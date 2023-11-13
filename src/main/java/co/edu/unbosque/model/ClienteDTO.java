package co.edu.unbosque.model;

import java.util.Date;

public class ClienteDTO {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String direccion;
	private String user_password;
	private boolean frecuente;
	private Date fecha_registro;
	private boolean cta_bloqueada;
	public ClienteDTO(int id,String nombre,String apellido, String email,String telefono,String direccion,String user_password,boolean frecuente,Date fecha_registro,boolean cta_bloqueada) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.telefono=telefono;
		this.direccion=direccion;
		this.user_password=user_password;
		this.frecuente=frecuente;
		this.fecha_registro=fecha_registro;
		this.cta_bloqueada=cta_bloqueada;
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

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getUser_password() {
			return user_password;
		}

		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}

		public boolean isFrecuente() {
			return frecuente;
		}

		public void setFrecuente(boolean frecuente) {
			this.frecuente = frecuente;
		}

		public Date getFecha_registro() {
			return fecha_registro;
		}

		public void setFecha_registro(Date fecha_registro) {
			this.fecha_registro = fecha_registro;
		}

		public boolean isCta_bloqueada() {
			return cta_bloqueada;
		}

		public void setCta_bloqueada(boolean cta_bloqueada) {
			this.cta_bloqueada = cta_bloqueada;
		}
}
