package co.edu.unbosque.model;

/**
 * This class represents a ProveedorDTO (Supplier Data Transfer Object) which
 * contains information about a supplier.
 */
public class ProveedorDTO {
	private int id;
	private String nombre;
	private String email;
	private String telefono;

	/**
	 * Constructs a ProveedorDTO object with the specified id, nombre, email, and
	 * telefono.
	 * 
	 * @param id       the id of the supplier
	 * @param nombre   the name of the supplier
	 * @param email    the email of the supplier
	 * @param telefono the phone number of the supplier
	 */
	public ProveedorDTO(int id, String nombre, String email, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.id = id;
	}

	/**
	 * Constructs a ProveedorDTO object with the specified nombre, email, and
	 * telefono.
	 * 
	 * @param nombre   the name of the supplier
	 * @param email    the email of the supplier
	 * @param telefono the phone number of the supplier
	 */
	public ProveedorDTO(String nombre, String email, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * Returns the id of the supplier.
	 * 
	 * @return the id of the supplier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the supplier.
	 * 
	 * @param id the id of the supplier
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of the supplier.
	 * 
	 * @return the name of the supplier
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the name of the supplier.
	 * 
	 * @param nombre the name of the supplier
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Returns the email of the supplier.
	 * 
	 * @return the email of the supplier
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the supplier.
	 * 
	 * @param email the email of the supplier
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the phone number of the supplier.
	 * 
	 * @return the phone number of the supplier
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets the phone number of the supplier.
	 * 
	 * @param telefono the phone number of the supplier
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
