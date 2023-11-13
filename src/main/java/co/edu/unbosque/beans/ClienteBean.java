package co.edu.unbosque.beans;

import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.AdminCliente;
import co.edu.unbosque.model.AdminUser;
import co.edu.unbosque.model.ClienteDTO;
import co.edu.unbosque.model.UserDTO;

public class ClienteBean {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String direccion;
	private String user_password;
	private boolean frecuente;
	private Date fecha_registro;
	private boolean cta_bloqueada;
	private AdminCliente adminCliente;
	private ClienteDTO dto;
	private ArrayList<ClienteDTO> clientes;

	public ClienteBean() {
		adminCliente = new AdminCliente();
	}

	
}