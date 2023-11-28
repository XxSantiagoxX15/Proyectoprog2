package co.edu.unbosque.model;

/**
 * Esta clase representa un objeto Detalle_facturaDTO que contiene información
 * sobre un detalle de una factura.
 */
public class Detalle_facturaDTO {
	private int id;
	private int factura;
	private int producto;
	private int cantidad;
	private double subtotal_producto;

	/**
	 * Constructor de la clase Detalle_facturaDTO.
	 * 
	 * @param factura           el número de la factura.
	 * @param producto          el identificador del producto.
	 * @param cantidad          la cantidad de productos.
	 * @param subtotal_producto el subtotal del producto.
	 */
	public Detalle_facturaDTO(int factura, int producto, int cantidad, double subtotal_producto) {
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal_producto = subtotal_producto;
	}

	/**
	 * Obtiene el identificador del detalle de la factura.
	 * 
	 * @return el identificador del detalle de la factura.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del detalle de la factura.
	 * 
	 * @param id el identificador del detalle de la factura.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el número de la factura.
	 * 
	 * @return el número de la factura.
	 */
	public int getFactura() {
		return factura;
	}

	/**
	 * Establece el número de la factura.
	 * 
	 * @param factura el número de la factura.
	 */
	public void setFactura(int factura) {
		this.factura = factura;
	}

	/**
	 * Obtiene el identificador del producto.
	 * 
	 * @return el identificador del producto.
	 */
	public int getProducto() {
		return producto;
	}

	/**
	 * Establece el identificador del producto.
	 * 
	 * @param producto el identificador del producto.
	 */
	public void setProducto(int producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene la cantidad de productos.
	 * 
	 * @return la cantidad de productos.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad de productos.
	 * 
	 * @param cantidad la cantidad de productos.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el subtotal del producto.
	 * 
	 * @return el subtotal del producto.
	 */
	public double getSubtotal_producto() {
		return subtotal_producto;
	}

	/**
	 * Establece el subtotal del producto.
	 * 
	 * @param subtotal_producto el subtotal del producto.
	 */
	public void setSubtotal_producto(double subtotal_producto) {
		this.subtotal_producto = subtotal_producto;
	}
}
