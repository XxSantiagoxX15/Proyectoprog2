package co.edu.unbosque.model;

public class DataMapper {
	public static Usuarios_drogueria fromDTO2Entity(UserDTO dto) {
		Usuarios_drogueria u = new Usuarios_drogueria();
		u.setId(dto.id());
		u.setNombre(dto.nombre());
		u.setApellido(dto.apellido());
		u.setEmail(dto.email());
		u.setUser_password(dto.user_password());
		u.setAdministrador(dto.administrador());
		u.setCta_bloqueada(dto.cta_bloqueada());

		return u;
	}

	public static UserDTO fromEntity2DTO(Usuarios_drogueria u) {
		UserDTO udto = new UserDTO(u.getId(), u.getNombre(), u.getApellido(), u.getEmail(), u.getUser_password(),
				u.isAdministrador(), u.isCta_bloqueada());
		return udto;
	}

	public static Producto fromDTO2Entityp(ProductoDTO dto) {
		Producto p = new Producto();

		p.setNombre(dto.nombre());
		p.setDescripcion(dto.descripcion());
		p.setPrecio(dto.precio());
		p.setCantidad_inventario(dto.cantidad_inventario());
		p.setCategoria(dto.categoria());

		return p;
	}

	public static ProductoDTO fromEntity2DTOp(Producto p) {
		ProductoDTO pdto = new ProductoDTO(p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getCantidad_inventario(),
				p.getCategoria());
		return pdto;
	}

}
