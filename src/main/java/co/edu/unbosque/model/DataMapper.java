package co.edu.unbosque.model;

public class DataMapper {
	public static Usuarios_drogueria fromDTO2Entity(UserDTO dto) {
		Usuarios_drogueria u = new Usuarios_drogueria();
		u.setId(dto.getId());
		u.setNombre(dto.getNombre());
		u.setApellido(dto.getApellido());
		u.setEmail(dto.getEmail());
		u.setUser_password(dto.getUser_password());
		u.setAdministrador(dto.isAdministrador());
		u.setCta_bloqueada(dto.isCta_bloqueada());

		return u;
	}

	public static UserDTO fromEntity2DTO(Usuarios_drogueria u) {
		UserDTO udto = new UserDTO(u.getId(), u.getNombre(), u.getApellido(), u.getEmail(), u.getUser_password(),
				u.isAdministrador(), u.isCta_bloqueada());
		return udto;
	}

	public static Producto fromDTO2Entityp(ProductoDTO dto) {
		Producto p = new Producto();

		p.setNombre(dto.getNombre());
		p.setDescripcion(dto.getDescripcion());
		p.setPrecio(dto.getPrecio());
		p.setCantidad_inventario(dto.getCantidad_inventario());
		p.setCategoria(dto.getCategoria());

		return p;
	}

	public static ProductoDTO fromEntity2DTOp(Producto p) {
		ProductoDTO pdto = new ProductoDTO(p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getCantidad_inventario(),
				p.getCategoria());
		return pdto;
	}

	public static Cliente fromDTO2Entityc(ClienteDTO dto) {
		Cliente c = new Cliente();

		c.setNombre(dto.getNombre());
		c.setApellido(dto.getApellido());
		c.setEmail(dto.getEmail());
		c.setTelefono(dto.getTelefono());
		c.setDireccion(dto.getDireccion());
		c.setUser_password(dto.getUser_password());
		c.setFrecuente(dto.isFrecuente());
		c.setFecha_registro(dto.getFecha_registro());
		c.setCta_bloqueada(dto.isCta_bloqueada());
		return c;
	}

	public static ClienteDTO fromEntity2DTOc(Cliente c) {
		ClienteDTO cdto = new ClienteDTO(c.getId(), c.getNombre(), c.getApellido(), c.getEmail(), c.getTelefono(),
				c.getDireccion(), c.getUser_password(), c.isFrecuente(), c.getFecha_registro(), c.isCta_bloqueada());
		return cdto;
	}

	public static Proveedor fromDTO2Entityp(ProveedorDTO dto) {
		Proveedor p = new Proveedor();

		p.setNombre(dto.getNombre());
		p.setEmail(dto.getEmail());
		p.setTelefono(dto.getTelefono());

		return p;
	}

	public static ProveedorDTO fromEntity2DTOp(Proveedor p) {
		ProveedorDTO pdto = new ProveedorDTO(p.getNombre(), p.getEmail(), p.getTelefono());
		return pdto;
	}

	public static Notificacion fromDTO2Entityn(NotificacionDTO dto) {
		Notificacion n = new Notificacion();

		n.setMensaje(dto.getMensaje());
		n.setFecha(dto.getFecha());
		n.setCliente(dto.getCliente());

		return n;
	}

	public static NotificacionDTO fromEntity2DTOn(Notificacion n) {
		NotificacionDTO ndto = new NotificacionDTO(n.getMensaje(), n.getFecha(), n.getCliente());
		return ndto;
	}

	public static Forma_pago fromDTO2EntityF(Forma_pagoDTO dto) {
		Forma_pago f = new Forma_pago();
        f.setId(dto.getId());
		f.setNombre(dto.getNombre());
		f.setDisponible(dto.isDisponible());

		return f;
	}

	public static Forma_pagoDTO fromEntity2DTOF(Forma_pago f) {
		Forma_pagoDTO fdto = new Forma_pagoDTO(f.getId(),f.getNombre(), f.isDisponible());
		return fdto;
	}

	public static Factura fromDTO2Entityfa(FacturaDTO dto) {
		Factura f = new Factura();

		f.setFecha_facturacion(dto.getFecha_facturacion());
		f.setValor_compra(dto.getValor_compra());
		f.setValor_iva(dto.getValor_iva());
		f.setTotal_facturado(dto.getTotal_facturado());
		f.setForma_pago(dto.getForma_pago());

		return f;
	}

	public static FacturaDTO fromEntity2DTOfa(Factura f) {
		FacturaDTO fdto = new FacturaDTO(f.getFecha_facturacion(), f.getValor_compra(), f.getValor_iva(),
				f.getTotal_facturado(), f.getForma_pago());
		return fdto;
	}

	public static Domicilio fromDTO2EntityD(DomicilioDTO dto) {
		Domicilio d = new Domicilio();

		d.setCliente(dto.getCliente());
		d.setDireccion_entrega(dto.getDireccion_entrega());
		d.setFecha(dto.getFecha());

		return d;
	}

	public static DomicilioDTO fromEntity2DTOD(Domicilio d) {
		DomicilioDTO ddto = new DomicilioDTO(d.getCliente(),d.getDireccion_entrega(),d.getFecha());
		return ddto;
	}
	
	public static Detalle_factura fromDTO2EntityDe(Detalle_facturaDTO dto) {
		Detalle_factura d = new Detalle_factura();

		d.setFactura(dto.getFactura());
		d.setProducto(dto.getProducto());
		d.setCantidad(dto.getCantidad());
		d.setSubtotal_producto(dto.getSubtotal_producto());
		return d;
	}

	public static Detalle_facturaDTO fromEntity2DTODe(Detalle_factura d) {
		Detalle_facturaDTO ddto = new Detalle_facturaDTO(d.getFactura(),d.getProducto(),d.getCantidad(),d.getSubtotal_producto());
		return ddto;
	}
	public static Compra_inventario fromDTO2Entityco(CompraInventarioDTO dto) {
		Compra_inventario c = new Compra_inventario();

		
		c.setProducto(dto.getProducto());
		c.setCantidad_adquirida(dto.getCantidad_adquirida());
		c.setFecha(dto.getFecha());
		c.setProveedor(dto.getProveedor());
		c.setForma_pago(dto.getForma_pago());
		return c;
	}

	public static CompraInventarioDTO fromEntity2DTOco(Compra_inventario c) {
		CompraInventarioDTO cdto = new CompraInventarioDTO(c.getProducto(),c.getCantidad_adquirida(),c.getFecha(),c.getProveedor(),c.getForma_pago());
		return cdto;
	}
}
