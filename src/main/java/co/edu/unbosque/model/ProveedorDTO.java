package co.edu.unbosque.model;

public class ProveedorDTO {
	private int id;
	private String nombre;
	private String email;
	private String telefono;
	public ProveedorDTO(int id,String nombre,String email,String telefono) {
		this.nombre= nombre;
		this.email=email;
		this.telefono=telefono;
		this.id=id;
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
}
