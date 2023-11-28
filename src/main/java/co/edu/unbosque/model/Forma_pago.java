package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORMA_PAGO")
public class Forma_pago {
	/**
	 * Represents a payment method.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private boolean disponible;

	/**
	 * Constructs a new Forma_pago object with the given nombre and disponible.
	 * 
	 * @param nombre     the name of the payment method
	 * @param disponible the availability of the payment method
	 */
	public Forma_pago(String nombre, boolean disponible) {
		this.nombre = nombre;
		this.disponible = disponible;
	}

	/**
	 * Constructs a new Forma_pago object with the given id, nombre, and disponible.
	 * 
	 * @param id         the id of the payment method
	 * @param nombre     the name of the payment method
	 * @param disponible the availability of the payment method
	 */
	public Forma_pago(int id, String nombre, boolean disponible) {
		this.nombre = nombre;
		this.disponible = disponible;
		this.id = id;
	}

	/**
	 * Constructs a new Forma_pago object.
	 */
	public Forma_pago() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the id of the payment method.
	 * 
	 * @return the id of the payment method
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the payment method.
	 * 
	 * @param id the id of the payment method
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of the payment method.
	 * 
	 * @return the name of the payment method
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the name of the payment method.
	 * 
	 * @param nombre the name of the payment method
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Returns the availability of the payment method.
	 * 
	 * @return the availability of the payment method
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * Sets the availability of the payment method.
	 * 
	 * @param disponible the availability of the payment method
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
