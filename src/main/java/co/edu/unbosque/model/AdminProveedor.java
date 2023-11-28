package co.edu.unbosque.model;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.edu.unbosque.model.persistence.ProveedorDao;

/**
 * Esta clase representa un administrador de proveedores.
 * AdminProveedor se encarga de realizar operaciones relacionadas con
 * proveedores,
 * como listar, buscar y agregar proveedores.
 */
public class AdminProveedor {
	private ProveedorDao dao;
	private static final Logger logger = LogManager.getLogger(AdminProveedor.class);

	public AdminProveedor() {
		dao = new ProveedorDao();
	}

	public ArrayList<ProveedorDTO> listar(ProveedorDTO Proveedordto) {
		ArrayList<Proveedor> proveedor = dao.findAll();
		ArrayList<ProveedorDTO> ProveedorDTO = new ArrayList<>();

		for (Proveedor Proveedor : proveedor) {

			ProveedorDTO dto = DataMapper.fromEntity2DTOp(Proveedor);
			ProveedorDTO.add(dto);
		}

		return ProveedorDTO;
	}

	public ProveedorDTO buscar(String nombre) {
		ProveedorDTO dto = DataMapper.fromEntity2DTOp(dao.findOne(nombre));
		return dto;
	}

	public boolean agregar(ProveedorDTO dto) {
		if (dao.create(DataMapper.fromDTO2Entityp(dto))) {
			System.out.println("se ingreso el proveedor");
			return true;
		} else {
			System.out.println("no se ingreso el proveedor");
		}
		return false;
	}
}
