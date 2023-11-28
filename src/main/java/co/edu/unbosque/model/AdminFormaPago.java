package co.edu.unbosque.model;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.edu.unbosque.model.persistence.Forma_pagoDao;

public class AdminFormaPago {
	private Forma_pagoDao dao;
	private static final Logger logger = LogManager.getLogger(AdminFormaPago.class);

	public AdminFormaPago() {
		dao = new Forma_pagoDao();
	}

	public ArrayList<Forma_pagoDTO> listar(Forma_pagoDTO FormaPagoDTO) {
		ArrayList<Forma_pago> formapago = dao.findAll();
		ArrayList<Forma_pagoDTO> formaPagoDTO = new ArrayList<>();

		for (Forma_pago Formapago : formapago) {

			Forma_pagoDTO dto = DataMapper.fromEntity2DTOF(Formapago);
			formaPagoDTO.add(dto);
			System.out.println(dto.toString());
		}

		return formaPagoDTO;
	}

	public Forma_pagoDTO buscar(String nombre) {
		Forma_pagoDTO dto = DataMapper.fromEntity2DTOF(dao.findOne(nombre));
		if (dto == null) {
			System.out.println("no existe esa verga");
		}
		return dto;
	}
}
