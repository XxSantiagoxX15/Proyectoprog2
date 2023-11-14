package co.edu.unbosque.beans;

import java.io.Serializable;
import java.time.LocalDate;

import co.edu.unbosque.model.AdminFormaPago;
import co.edu.unbosque.model.AdminInventario;
import co.edu.unbosque.model.AdminProducto;
import co.edu.unbosque.model.AdminProveedor;

import co.edu.unbosque.model.CompraInventarioDTO;
import co.edu.unbosque.model.Forma_pagoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

@Named
@RequestScoped
public class InventarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productos;
	private int cantidad_adquirida;
	private LocalDate fecha;
	private int proveedores; // Debe coincidir con el tipo de dato utilizado en el formulario

	private int forma_pagos;

	private AdminInventario in;
	private CompraInventarioDTO dto;

	@PostConstruct
	public void init() {

		in = new AdminInventario();
		dto = new CompraInventarioDTO();
	}

	public void insertar() {

		fecha = LocalDate.now();
		dto = new CompraInventarioDTO(productos, cantidad_adquirida, fecha, proveedores, forma_pagos);
		in.ingresarinv(dto);
		System.out.println(dto.toString());

	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
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

	public int getProveedores() {
		return proveedores;
	}

	public void setProveedores(int proveedores) {
		this.proveedores = proveedores;
	}

	public int getForma_pagos() {
		return forma_pagos;
	}

	public void setForma_pagos(int forma_pagos) {
		this.forma_pagos = forma_pagos;
	}

	public AdminInventario getIn() {
		return in;
	}

	public void setIn(AdminInventario in) {
		this.in = in;
	}

	public CompraInventarioDTO getDto() {
		return dto;
	}

	public void setDto(CompraInventarioDTO dto) {
		this.dto = dto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
