package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * This class represents a data transfer object for a purchase in the inventory.
 * It contains information about the product, quantity acquired, date, supplier,
 * and payment method.
 */
public class CompraInventarioDTO {
	private int id;
	private int producto;
	private int cantidad_adquirida;
	private LocalDate fecha;
	private int proveedor;
	private int forma_pago;

	public CompraInventarioDTO(int producto, int cantidad_adquirida, LocalDate fecha, int proveedor, int forma_pago) {
		this.producto = producto;
		this.cantidad_adquirida = cantidad_adquirida;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.forma_pago = forma_pago;
	}

	public CompraInventarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getCantidad_adquirida() {
		return cantidad_adquirida;
	}

	public void setCantidad_adquirida(int cantidad_adquirida) {
		this.cantidad_adquirida = cantidad_adquirida;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}

	public int getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(int forma_pago) {
		this.forma_pago = forma_pago;
	}

	@Override
	public String toString() {
		return "El  producto es : " + producto + "con una cantidad de : " + cantidad_adquirida + "el dia : " + fecha
				+ "al proveedor : " + proveedor + " y por medio de la siguiente forma de pago : " + forma_pago;
	}
}
