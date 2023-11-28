package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORMA_PAGO")
public class Forma_pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private boolean disponible;

	public Forma_pago(String nombre, boolean disponible) {
		this.nombre = nombre;
		this.disponible = disponible;

	}

	public Forma_pago(int id, String nombre, boolean disponible) {
		this.nombre = nombre;
		this.disponible = disponible;
		this.id = id;

	}

	public Forma_pago() {
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
}
