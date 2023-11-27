package co.edu.unbosque.test;



import org.junit.Before;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.beans.InventarioBean;
import co.edu.unbosque.model.AdminProducto;
import co.edu.unbosque.model.Compra_inventario;
import co.edu.unbosque.model.ProductoDTO;

public class ShopysApplicationTests {
	private InventarioBean inventarioBean;
    private AdminProducto adminProductoMock;
    private Compra_inventario inventarioMock;


    @Before
    public void setUp() {
        // Inicializar los mocks y la clase bajo prueba
        adminProductoMock = mock(AdminProducto.class);
        inventarioMock = mock(Compra_inventario.class);
        inventarioBean = new InventarioBean();
    }

    @Test
    public void testInsertar() {
        // Configurar el comportamiento esperado para el mock de AdminProducto
        ProductoDTO productoExistente = new ProductoDTO("ProductoExistente", "Descripción", 10.0, 20, "Categoria");
        when(adminProductoMock.buscar("ProductoExistente")).thenReturn(productoExistente);

        // Configurar el comportamiento esperado para el mock de Inventario
        when(adminProductoMock.editar(eq("ProductoExistente"), any(ProductoDTO.class))).thenReturn(true);

        // Llamada al método bajo prueba
        inventarioBean.insertar();

        // Verificar que las interacciones esperadas ocurrieron
        verify(adminProductoMock).buscar("ProductoExistente");
        verify(adminProductoMock).editar(eq("ProductoExistente"), any(ProductoDTO.class));
        verify(inventarioMock).ingresarinv(any(CompraInventarioDTO.class));

        // Puedes agregar más aserciones según sea necesario
    }
}

