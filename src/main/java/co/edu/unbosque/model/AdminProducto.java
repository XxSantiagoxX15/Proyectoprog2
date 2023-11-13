package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ProductoDao;

public class AdminProducto {
	private ProductoDao dao;

	public AdminProducto() {
		dao = new ProductoDao();
	}
	
	public ArrayList<ProductoDTO> listar(ProductoDTO productoDTO) {
	    ArrayList<Producto> productos = dao.findAll();
	    ArrayList<ProductoDTO> productosDTO = new ArrayList<>();
	    
	    for (Producto producto : productos) {

	        ProductoDTO dto= DataMapper.fromEntity2DTOp(producto);
	        productosDTO.add(dto);
	    }
	    
	    return productosDTO;
	}

	public boolean insertar(ProductoDTO dto) {

		dao.create(DataMapper.fromDTO2Entityp(dto));
		return true;
	}
	
	public ProductoDTO buscar(String nombre) {
	    Producto producto = dao.findOne(nombre);

	    if (producto != null) {
	       System.out.println("si pasa aca");
	        return DataMapper.fromEntity2DTOp(producto);
	    } else {
	      System.out.println("Es nullo");
	        return null;
	    }
	}
	public void eliminar(ProductoDTO dto) {
		dao.delete(DataMapper.fromDTO2Entityp(dto));
	}
}
