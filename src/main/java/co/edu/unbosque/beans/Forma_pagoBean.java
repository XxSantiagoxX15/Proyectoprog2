package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.AdminFormaPago;

import co.edu.unbosque.model.Forma_pagoDTO;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class Forma_pagoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean disponible;
	private ArrayList<Forma_pagoDTO> formapago;
	private Forma_pagoDTO dto;
	private AdminFormaPago fp;

	
	
	public Forma_pagoBean() {
		dto = new Forma_pagoDTO();
		fp = new AdminFormaPago();
	}

	
	
	@PostConstruct
	public void init() {
		listar();
		fp = new AdminFormaPago();

	}

	
	
	
	
	public ArrayList<Forma_pagoDTO> listar() {
		formapago = fp.listar(dto);
		if (formapago != null) {
			for (Forma_pagoDTO formapago : formapago) {

			}
		}
		return formapago;
	}

	public Forma_pagoDTO buscar() {
		fp.buscar(nombre);
		System.out.println(dto.toString());
		return dto;

	}
	

	public String getNombre() {
		return nombre;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public boolean isDisponible() {
		return disponible;
	}
	
	

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
	
	public ArrayList<Forma_pagoDTO> getFormapago() {
		return formapago;
	}

	public void setFormapago(ArrayList<Forma_pagoDTO> formapago) {
		this.formapago = formapago;
	}
	
	

	public Forma_pagoDTO getDto() {
		return dto;
	}
	
	

	public void setDto(Forma_pagoDTO dto) {
		this.dto = dto;
	}

	
	
	public AdminFormaPago getFp() {
		return fp;
	}
	
	

	public void setFp(AdminFormaPago fp) {
		this.fp = fp;
	}

}
