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
        p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		p.setDescripcion(dto.getDescripcion());
		p.setPrecio(dto.getPrecio());
		p.setCantidad_inventario(dto.getCantidad_inventario());
		p.setCategoria(dto.getCategoria());

		return p;
	}

	public static ProductoDTO fromEntity2DTOp(Producto p) {
		ProductoDTO pdto = new ProductoDTO(p.getId(),p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getCantidad_inventario(),
				p.getCategoria());
		return pdto;
	}


	public static Proveedor fromDTO2Entityp(ProveedorDTO dto) {
		Proveedor p = new Proveedor();
        p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		p.setEmail(dto.getEmail());
		p.setTelefono(dto.getTelefono());

		return p;
	}

	public static ProveedorDTO fromEntity2DTOp(Proveedor p) {
		ProveedorDTO pdto = new ProveedorDTO(p.getId(),p.getNombre(), p.getEmail(), p.getTelefono());
		return pdto;
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
