package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ProveedorDao;

public class AdminProveedor {
private ProveedorDao dao;

public AdminProveedor() {
	dao=new ProveedorDao();
}
	
	
	public ArrayList<ProveedorDTO> listar(ProveedorDTO Proveedordto) {
	    ArrayList<Proveedor> proveedor = dao.findAll();
	    ArrayList<ProveedorDTO> ProveedorDTO = new ArrayList<>();
	    
	    for (Proveedor Proveedor : proveedor) {

	        ProveedorDTO dto= DataMapper.fromEntity2DTOp(Proveedor);
	        ProveedorDTO.add(dto);
	    }
	    
	    return ProveedorDTO;
	}
	
	public  ProveedorDTO buscar(String nombre) {
		ProveedorDTO dto=DataMapper.fromEntity2DTOp(dao.findOne(nombre));
			return dto;
		}
}
