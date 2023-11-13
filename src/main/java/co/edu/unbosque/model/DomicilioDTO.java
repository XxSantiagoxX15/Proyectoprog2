package co.edu.unbosque.model;

import java.util.Date;

public class DomicilioDTO {
	private int id;
	private int cliente;
	private String direccion_entrega;
	private Date fecha;
	
	public DomicilioDTO(int cliente,String direccion_entrega,Date fecha) {
this.cliente=cliente;
this.direccion_entrega=direccion_entrega;
this.fecha=fecha;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getDireccion_entrega() {
		return direccion_entrega;
	}

	public void setDireccion_entrega(String direccion_entrega) {
		this.direccion_entrega = direccion_entrega;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
