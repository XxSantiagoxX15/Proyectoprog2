package co.edu.unbosque.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AdminProducto;
import co.edu.unbosque.model.AdminUser;
import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UsersDao;


public class ShopysApplicationTests {
	
	 
	@Test
	public void testCrearUser() {
	   
	    AdminUser user = new AdminUser();
	    UsersDao dao = new UsersDao();
	    
	
	    UserDTO userdto = new UserDTO(1018323, "Santiago", "melo", "Santiagomelo15@hotmail.com", user.encryptPassword("Santiago34*"), true, false);

	    boolean result = user.insertar(userdto);

	    assertTrue(result); 

	    
	    if (result) {
	        dao.delete(1018323);
	    }
	}

	  @Test
	    public void testListar() {
	        AdminProducto adminProducto = new AdminProducto();

	       
	        ArrayList<ProductoDTO> result = adminProducto.listar(new ProductoDTO());

	        
	        assertNotNull(result);
	       
	      
	    }
}
