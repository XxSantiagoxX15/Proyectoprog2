package co.edu.unbosque.model;

import java.util.Date;

public class FacturaDTO {
	private int id;
	private Date fecha_facturacion;
	private double valor_compra;
	private double valor_iva;
	private double total_facturado;
	private int forma_pago;
	public FacturaDTO(Date fecha_facturacion,double valor_compra,double valor_iva,double total_facturado,int forma_pago) {
		this.fecha_facturacion=fecha_facturacion;
		this.valor_compra=valor_compra;
		this.valor_iva=valor_iva;
		this.total_facturado=total_facturado;
		this.forma_pago=forma_pago;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_facturacion() {
		return fecha_facturacion;
	}
	public void setFecha_facturacion(Date fecha_facturacion) {
		this.fecha_facturacion = fecha_facturacion;
	}
	public double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public double getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
	public double getTotal_facturado() {
		return total_facturado;
	}
	public void setTotal_facturado(double total_facturado) {
		this.total_facturado = total_facturado;
	}
	public int getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(int forma_pago) {
		this.forma_pago = forma_pago;
	}
	
}
