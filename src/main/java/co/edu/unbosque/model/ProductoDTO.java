package co.edu.unbosque.model;

import java.math.BigInteger;

public class ProductoDTO {
	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int cantidad_inventario;
	private BigInteger cantidadinv;
	private String categoria;

	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductoDTO(int id, String nombre, String descripcion, double precio, int cantidad_inventario,
			String categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad_inventario = cantidad_inventario;
		this.categoria = categoria;
		this.id = id;
	}

	public ProductoDTO(String nombre, String descripcion, double precio, int cantidad_inventario, String categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad_inventario = cantidad_inventario;
		this.categoria = categoria;
	}

	public ProductoDTO(String nombre, BigInteger cantidad_inventario) {

		this.nombre = nombre;

		this.cantidadinv = cantidad_inventario;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad_inventario() {
		return cantidad_inventario;
	}

	public void setCantidad_inventario(int cantidad_inventario) {
		this.cantidad_inventario = cantidad_inventario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductoDTO [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", cantidad_inventario=" + cantidad_inventario + ", categoria=" + categoria + "]";
	}

	public BigInteger getCantidadinv() {
		return cantidadinv;
	}

	public void setCantidadinv(BigInteger cantidadinv) {
		this.cantidadinv = cantidadinv;
	}
}
