package co.edu.unbosque.model;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.edu.unbosque.model.persistence.Forma_pagoDao;

/**
 * The AdminFormaPago class represents an administrator for the FormaPago
 * objects.
 * It provides methods to list and search for FormaPago objects.
 */
public class AdminFormaPago {
	private Forma_pagoDao dao;
	private static final Logger logger = LogManager.getLogger(AdminFormaPago.class);

	/**
	 * Constructs a new AdminFormaPago object.
	 * Initializes the Forma_pagoDao.
	 */
	public AdminFormaPago() {
		dao = new Forma_pagoDao();
	}

	/**
	 * Lists all the FormaPago objects.
	 * 
	 * @param FormaPagoDTO The FormaPagoDTO object to be listed.
	 * @return An ArrayList of Forma_pagoDTO objects.
	 */
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

	/**
	 * Searches for a FormaPago object by its name.
	 * 
	 * @param nombre The name of the FormaPago object to be searched.
	 * @return The Forma_pagoDTO object found, or null if not found.
	 */
	public Forma_pagoDTO buscar(String nombre) {
		Forma_pagoDTO dto = DataMapper.fromEntity2DTOF(dao.findOne(nombre));
		if (dto == null) {
			System.out.println("no existe esa verga");
		}
		return dto;
	}
}
