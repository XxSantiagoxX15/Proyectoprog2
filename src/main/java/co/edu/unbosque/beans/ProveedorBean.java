package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.AdminProveedor;

import co.edu.unbosque.model.ProveedorDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

@Named
@RequestScoped
public class ProveedorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private AdminProveedor pr;
	private int id;
	private String nombre;
	private String email;
	private String telefono;
	private ArrayList<ProveedorDTO> proveedor;
	private ProveedorDTO dto;

	public ProveedorBean() {
		pr = new AdminProveedor();
	}

	@PostConstruct
	public void init() {
		listar();
		pr = new AdminProveedor();

	}

	public ArrayList<ProveedorDTO> listar() {
		proveedor = pr.listar(dto);
		if (proveedor != null) {
			for (ProveedorDTO proveedor : proveedor) {
				System.out.println(proveedor.toString());

			}
		}
		return proveedor;
	}

	public void agregar() {
		dto = new ProveedorDTO(nombre, email, telefono);
		pr.agregar(dto);
	}

	public AdminProveedor getPr() {
		return pr;
	}

	public void setPr(AdminProveedor pr) {
		this.pr = pr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<ProveedorDTO> getProveedor() {
		return proveedor;
	}

	public void setProveedor(ArrayList<ProveedorDTO> proveedor) {
		this.proveedor = proveedor;
	}

	public ProveedorDTO getDto() {
		return dto;
	}

	public void setDto(ProveedorDTO dto) {
		this.dto = dto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
