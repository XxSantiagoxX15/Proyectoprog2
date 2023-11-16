package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;



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
	 private static final long serialVersionUID = 1L;
	 private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadinv;
    private String opcionesesta;
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
        
    }

    public void agregar() {
        dto = new ProductoDTO(nombre, descripcion, precio, cantidadinv, categoria);
        adminProducto.insertar(dto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto insertado"));
    }

    public ArrayList<ProductoDTO> listar() {
        productos = adminProducto.listar(dto);
        if (productos != null) {
            for (ProductoDTO producto : productos) {
         
               
            }
        }
        return productos;
    }
    public ArrayList<?> listarxinventario() {
        if ("Inventariocant".equals(opcionesesta)) {
        	productos = adminProducto.listarxinventario(dto);
            for (ProductoDTO producto : productos) {
         
               
            }
        }
        return productos;
    }
 
    
    
 
    public void editar() {
    dto= new ProductoDTO(id,nombre,descripcion, precio, cantidadinv, categoria);
    adminProducto.editar(id,dto);	
    
    }
    
    public void eliminar() {
    	System.out.println("Método eliminar() ejecutado");
        // Lógica para eliminar el producto
        adminProducto.eliminar(id);
        // Agrega mensajes de registro para verificar si se está ejecutando correctamente
        System.out.println("Producto eliminado con éxito");
    }
    public int getId() {
		return id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpcionesesta() {
		return opcionesesta;
	}

	public void setOpcionesesta(String opcionesesta) {
		this.opcionesesta = opcionesesta;
	}
	  
	



}
