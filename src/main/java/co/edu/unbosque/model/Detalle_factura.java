package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLE_FACTURA")
public class Detalle_factura {
	/**
	 * Represents the unique identifier of the detalle factura.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Represents the factura associated with the detalle factura.
	 */
	private int factura;

	/**
	 * Represents the producto associated with the detalle factura.
	 */
	private int producto;

	/**
	 * Represents the quantity of the producto in the detalle factura.
	 */
	private int cantidad;

	/**
	 * Represents the subtotal of the producto in the detalle factura.
	 */
	private double subtotal_producto;

	/**
	 * Constructs a Detalle_factura object with the specified factura, producto,
	 * cantidad, and subtotal_producto.
	 * 
	 * @param factura           the factura associated with the detalle factura
	 * @param producto          the producto associated with the detalle factura
	 * @param cantidad          the quantity of the producto in the detalle factura
	 * @param subtotal_producto the subtotal of the producto in the detalle factura
	 */
	public Detalle_factura(int factura, int producto, int cantidad, double subtotal_producto) {
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal_producto = subtotal_producto;
	}

	/**
	 * Constructs a Detalle_factura object with default values.
	 */
	public Detalle_factura() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the unique identifier of the detalle factura.
	 * 
	 * @return the id of the detalle factura
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the detalle factura.
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the factura associated with the detalle factura.
	 * 
	 * @return the factura of the detalle factura
	 */
	public int getFactura() {
		return factura;
	}

	/**
	 * Sets the factura associated with the detalle factura.
	 * 
	 * @param factura the factura to set
	 */
	public void setFactura(int factura) {
		this.factura = factura;
	}

	/**
	 * Returns the producto associated with the detalle factura.
	 * 
	 * @return the producto of the detalle factura
	 */
	public int getProducto() {
		return producto;
	}

	/**
	 * Sets the producto associated with the detalle factura.
	 * 
	 * @param producto the producto to set
	 */
	public void setProducto(int producto) {
		this.producto = producto;
	}

	/**
	 * Returns the quantity of the producto in the detalle factura.
	 * 
	 * @return the cantidad of the producto in the detalle factura
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Sets the quantity of the producto in the detalle factura.
	 * 
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Returns the subtotal of the producto in the detalle factura.
	 * 
	 * @return the subtotal_producto of the producto in the detalle factura
	 */
	public double getSubtotal_producto() {
		return subtotal_producto;
	}

	/**
	 * Sets the subtotal of the producto in the detalle factura.
	 * 
	 * @param subtotal_producto the subtotal_producto to set
	 */
	public void setSubtotal_producto(double subtotal_producto) {
		this.subtotal_producto = subtotal_producto;
	}
}
