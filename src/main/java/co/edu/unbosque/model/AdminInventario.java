package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CompraInventarioDao;

public class AdminInventario {
private CompraInventarioDao dao;

public AdminInventario() {
	dao=new CompraInventarioDao();
}
	
	
	public boolean ingresarinv(CompraInventarioDTO dto) {
		if (dao.create(DataMapper.fromDTO2Entityco(dto)) != false) {

		}
		
		return false;
	}
}
