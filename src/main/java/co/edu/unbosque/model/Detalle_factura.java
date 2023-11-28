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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int factura;

	private int producto;
	private int cantidad;
	private double subtotal_producto;

	public Detalle_factura(int factura, int producto, int cantidad, double subtotal_producto) {
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal_producto = subtotal_producto;
	}

	public Detalle_factura() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFactura() {
		return factura;
	}

	public void setFactura(int factura) {
		this.factura = factura;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal_producto() {
		return subtotal_producto;
	}

	public void setSubtotal_producto(double subtotal_producto) {
		this.subtotal_producto = subtotal_producto;
	}
}
