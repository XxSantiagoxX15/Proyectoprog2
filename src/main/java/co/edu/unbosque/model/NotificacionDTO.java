package co.edu.unbosque.model;

import java.util.Date;

public class NotificacionDTO {
	private int id;
	private String mensaje;
	private Date fecha;
	private int cliente;
	
	
	public NotificacionDTO(String mensaje,Date fecha,int cliente) {
this.mensaje=mensaje;
this.fecha=fecha;
this.cliente=cliente;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getCliente() {
		return cliente;
	}


	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
}
