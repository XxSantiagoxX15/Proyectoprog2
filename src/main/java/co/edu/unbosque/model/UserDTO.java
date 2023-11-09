package co.edu.unbosque.model;

public record UserDTO(int id, String nombre, String apellido, String email, String user_password,
		boolean administrador, boolean cta_bloqueada) {


}
