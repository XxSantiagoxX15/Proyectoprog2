package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AdminProducto;
import co.edu.unbosque.model.ProductoDTO;

public class ShopysApplicationTests {

	@Test
	public void testInsertarProducto() {
		// Create an instance of the ShopysApplication class
		AdminProducto producto = new AdminProducto();

		// Create a product to insert
		ProductoDTO product = new ProductoDTO(3, "Example Product", "Descripcion prueba", 10.99, 0, "prueba");

		boolean result = producto.insertar(product);

		assertTrue(result);
	}

	@Test
	public void testListarxinventario() {
		AdminProducto producto = new AdminProducto();

		ProductoDTO product = new ProductoDTO("Example Product", "Descripcion prueba", 10.99, 0, "prueba");
		producto.insertar(product);

		ProductoDTO result = producto.buscar(3);
		assertEquals(product, result);
	}
}
