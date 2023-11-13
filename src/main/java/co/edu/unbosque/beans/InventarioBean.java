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
    private Forma_pagoDTO forma_pagos;
    private int formapagos;
    private AdminProveedor pr;
    private AdminProducto pro;
    private AdminFormaPago fp;
    private AdminInventario in;
    private CompraInventarioDTO dto;

    @PostConstruct
    public void init() {
        pr = new AdminProveedor();
        pro = new AdminProducto();
        fp = new AdminFormaPago();
        in = new AdminInventario();
        dto = new CompraInventarioDTO();
    }

    public void insertar() {
        System.out.println("Insertando...");
        System.out.println("productos: " + productos);
        System.out.println("proveedores: " + proveedores);
        System.out.println("forma_pagos: " + forma_pagos);
formapagos= forma_pagos.getId();
proveedores=1;
productos=3;
        fecha = LocalDate.now();
        dto = new CompraInventarioDTO(productos, cantidad_adquirida, fecha,proveedores , formapagos);
        in.ingresarinv(dto);
        System.out.println(dto.toString());
        System.out.println(forma_pagos.toString());
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



	public Forma_pagoDTO getForma_pagos() {
		return forma_pagos;
	}

	public void setForma_pagos(Forma_pagoDTO forma_pagos) {
		this.forma_pagos = forma_pagos;
	}

	public int getFormapagos() {
		return formapagos;
	}

	public void setFormapagos(int formapagos) {
		this.formapagos = formapagos;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
		
	}
	
	
	
	
	 

