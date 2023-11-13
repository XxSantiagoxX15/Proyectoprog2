package co.edu.unbosque.beans;

import java.time.LocalDate;
import java.util.Date;

import co.edu.unbosque.model.AdminFormaPago;
import co.edu.unbosque.model.AdminInventario;
import co.edu.unbosque.model.AdminProducto;
import co.edu.unbosque.model.AdminProveedor;
import co.edu.unbosque.model.AdminUser;
import co.edu.unbosque.model.CompraInventarioDTO;
import co.edu.unbosque.model.DataMapper;
import co.edu.unbosque.model.UserDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
@Named
@RequestScoped
public class InventarioBean {
	private String productos;
	private int producto;
	private int  cantidad_adquirida;
	private LocalDate fecha;
	private String proveedor;
	private int proveedores;
	private String forma_pago;
	private int forma_pagos;
	private AdminProveedor pr;
	private AdminProducto pro;
	private AdminFormaPago fp;
    private AdminInventario in;
	private CompraInventarioDTO dto;
	
	public InventarioBean() {
	pr=new AdminProveedor();
	pro= new AdminProducto();
	fp= new AdminFormaPago();
	in=new AdminInventario();
	dto= new CompraInventarioDTO();
	}
	public void insertar() {
		  fecha = LocalDate.now();
		in=new AdminInventario();
		producto= pro.buscar(getProductos()).getId();
		 proveedores=pr.buscar(getProveedor()).getId();
		 forma_pagos=fp.buscar(getForma_pago()).getId();
		dto=new CompraInventarioDTO(producto,cantidad_adquirida,fecha,proveedores,forma_pagos);
		in.ingresarinv(dto);
		System.out.println(dto.toString());
	}
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
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
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public int getProveedores() {
		return proveedores;
	}
	public void setProveedores(int proveedores) {
		this.proveedores = proveedores;
	}
	public String getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	public int getForma_pagos() {
		return forma_pagos;
	}
	public void setForma_pagos(int forma_pagos) {
		this.forma_pagos = forma_pagos;
	}
	public AdminProveedor getPr() {
		return pr;
	}
	public void setPr(AdminProveedor pr) {
		this.pr = pr;
	}
	public AdminProducto getPro() {
		return pro;
	}
	public void setPro(AdminProducto pro) {
		this.pro = pro;
	}
	public AdminFormaPago getFp() {
		return fp;
	}
	public void setFp(AdminFormaPago fp) {
		this.fp = fp;
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
	
		
	}
	
	
	
	
	 

