package co.edu.unbosque.beans;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.donut.DonutChartOptions;

import co.edu.unbosque.model.AdminProducto;

import co.edu.unbosque.model.ProductoDTO;

import jakarta.annotation.PostConstruct;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;

import jakarta.faces.context.FacesContext;

import jakarta.inject.Named;

@Named
@ViewScoped
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
    private DonutChartModel donut;
    private   ChartData data;
    public ProductoBean() {
    
        adminProducto = new AdminProducto();
   
    }

    @PostConstruct
    public void init() {
        listar();
        createDonutModel(); 
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
    public ArrayList<ProductoDTO> listarxinventario() {
        if ("Inventariocant".equals(opcionesesta)) {
        	productos = adminProducto.listarxinventario(dto);
            for (ProductoDTO producto : productos) {
         
               
            }
        }
        return productos;
    }
 
    public DonutChartModel createDonutModel() {
        DonutChartModel donut = new DonutChartModel();
        DonutChartOptions options = new DonutChartOptions();
        options.setMaintainAspectRatio(false);
        donut.setOptions(options);

        ArrayList<ProductoDTO> listaProductos = adminProducto.listarxinventario(dto);

        // Mover la creación de DonutChartDataSet fuera del bucle
        DonutChartDataSet dataSet = new DonutChartDataSet();
        ArrayList<Number> values = new ArrayList<>();
        ArrayList<String> bgColors = new ArrayList<>();

        for (ProductoDTO producto : listaProductos) {
            int cantidadinv = producto.getCantidad_inventario();
            values.add(cantidadinv);

            // Generar un color aleatorio en formato "rgb(r, g, b)"
            String randomColor = generateRandomColor();
            bgColors.add(randomColor);
        }

        dataSet.setData(values);
        dataSet.setBackgroundColor(bgColors);

        ChartData data = new ChartData();
        data.addChartDataSet(dataSet);

        // Mover la creación de labels fuera del bucle
        ArrayList<String> labels = new ArrayList<>();
        for (ProductoDTO producto : listaProductos) {
            String data2 = producto.getNombre();
            labels.add(data2);
        }
        data.setLabels(labels);

        donut.setData(data);

        return donut;
    }

    private String generateRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        return String.format("rgb(%d, %d, %d)", r, g, b);
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

	public DonutChartModel getDonut() {
		return donut;
	}

	public void setDonut(DonutChartModel donut) {
		this.donut = donut;
	}

	public ChartData getData() {
		return data;
	}

	public void setData(ChartData data) {
		this.data = data;
	}
	  
	



}
