package co.edu.unbosque.model;

public class Forma_pagoDTO {
	private int id;
	private String nombre;
	private boolean disponible;

	public Forma_pagoDTO(int id,String nombre,boolean disponible) {
this.nombre=nombre;
this.disponible=disponible;
this.id=id;

	}
	public Forma_pagoDTO() {
		// TODO Auto-generated constructor stub
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
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	@Override
	public String toString() {
		return "Forma_pagoDTO [id=" + id + ", nombre=" + nombre + ", disponible=" + disponible + "]";
	}
}
