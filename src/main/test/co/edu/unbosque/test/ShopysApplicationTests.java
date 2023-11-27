package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.beans.InventarioBean;
import co.edu.unbosque.model.AdminProducto;
import co.edu.unbosque.model.Compra_inventario;
import co.edu.unbosque.model.ProductoDTO;

public class ShopysApplicationTests {

    @Test
    public void testInsertarProducto() {
        // Create an instance of the ShopysApplication class
        ShopysApplication shopysApplication = new ShopysApplication();

        // Create a product to insert
        Product product = new Product("Example Product", 10.99);

        // Insert the product
        boolean result = shopysApplication.insertProduct(product);

        // Assert that the product was inserted successfully
        assertTrue(result);
    }
}
