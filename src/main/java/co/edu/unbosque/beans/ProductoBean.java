package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.AdminProducto;

import co.edu.unbosque.model.ProductoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductoBean implements Serializable {
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadinv;
    private String categoria;
    private AdminProducto adminProducto;
    private ProductoDTO dto;
    private ArrayList<ProductoDTO> productos;

    public ProductoBean() {
    
        adminProducto = new AdminProducto();
   
    }

    @PostConstruct
    public void init() {
        listar();
        adminProducto = new AdminProducto();
        productos = adminProducto.listar(dto);
    }

    public void agregar() {
        dto = new ProductoDTO(nombre, descripcion, precio, cantidadinv, categoria);
        adminProducto.insertar(dto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto insertado"));
    }

    public boolean listar() {
   productos = adminProducto.listar(dto);
   System.out.println(productos.toString());
        return this.dto != null && !this.productos.isEmpty();
    }

    public void eliminarseleccionados() {
        adminProducto.eliminar(dto);
        this.dto = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Productos eliminados"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtProducts");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
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

	public int getCantidadinv() {
		return cantidadinv;
	}

	public void setCantidadinv(int cantidadinv) {
		this.cantidadinv = cantidadinv;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public AdminProducto getAdminProducto() {
		return adminProducto;
	}

	public void setAdminProducto(AdminProducto adminProducto) {
		this.adminProducto = adminProducto;
	}

	public ProductoDTO getDto() {
		return dto;
	}

	public void setDto(ProductoDTO dto) {
		this.dto = dto;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}
	  
	



}
