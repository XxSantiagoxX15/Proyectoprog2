package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;


public class ProductoDao implements DaoCrud {
	private EntityManagerFactory emf;
	private EntityManager em;
	

	public ProductoDao() {
		emf = Persistence.createEntityManagerFactory("DrogueriaPu");
		em = emf.createEntityManager();


	}

	public void open() {
		if (!emf.isOpen() || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("DrogueriaPu");
			em = emf.createEntityManager();
		}

	}

	@Override
	public boolean create(Object o) {
		open();
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return false;

	}
	public boolean delete(int id) {
	    open();
	    try {
	        em.getTransaction().begin();
	        Producto producto = em.find(Producto.class, id);
	        
	        // Aquí ajustamos la consulta DELETE para utilizar el identificador directamente
	        em.createQuery("DELETE FROM Compra_inventario c WHERE c.producto = :producto")
	          .setParameter("producto", id)
	          .executeUpdate();
	        em.createQuery("DELETE FROM Detalle_factura d WHERE d.producto = :producto")
	          .setParameter("producto", id)
	          .executeUpdate();
	        
	        if (producto != null) {
	            em.remove(producto);
	            em.getTransaction().commit();
	            return true;
	        } else {
	            return false; // El producto no existe en la base de datos
	        }
	    } catch (EntityNotFoundException e) {
	        System.out.println("El producto no existe en la base de datos.");
	        return false;
	    } catch (Exception e) {
	        System.out.println("Error al eliminar el producto: " + e.getMessage());
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        return false;
	    } finally {
	        if (em != null && em.isOpen()) {
	            em.close();
	        }
	        if (emf != null && emf.isOpen()) {
	            emf.close();
	        }
	    }
	}


	@Override
	public boolean delete(Object o) {
		open();
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}

		}
	}

	public boolean update(String nombre, Object o) {
	    open();
	    try {
	        em.getTransaction().begin();
	        Producto selectedProducto = em.find(Producto.class, nombre);
	        if (selectedProducto != null) {
	            Producto newProducto = (Producto) o;

	            // Actualizar los atributos del producto seleccionado con los nuevos valores
	            selectedProducto.setNombre(newProducto.getNombre());
	            selectedProducto.setDescripcion(newProducto.getDescripcion());
	            selectedProducto.setPrecio(newProducto.getPrecio());
	            selectedProducto.setCantidad_inventario(newProducto.getCantidad_inventario());

	            em.getTransaction().commit();
	            return true;
	        } else {
	            // Manejar el caso en el que no se encuentra el producto con el nombre dado
	            System.out.println("Producto no encontrado con el nombre: " + nombre);
	            return false;
	        }
	    } catch (Exception e) {
	        // Manejar cualquier excepción durante la actualización
	        System.out.println("Error al actualizar el producto: " + e.getMessage());
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        return false;
	    } finally {
	      em.close();
	    }
	}

	







	@Override
	public ArrayList<Producto> findAll() {
		open();
		try {
			return (ArrayList<Producto>) em.createQuery("SELECT p FROM Producto p").getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return new ArrayList<Producto>();
	}

	
	public Producto findOne(String nombre) {
		open();
		try {
			Producto selectedProducto = em.find(Producto.class, nombre);
			return selectedProducto;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	public ArrayList<Producto> findByInventory(){
		open();
		try {
			return (ArrayList<Producto>) em.createQuery("SELECT p FROM Producto p WHERE p.cantidad_inventario <= 10 ORDER BY p.cantidad_inventario").getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return new ArrayList<Producto>();
	}
	
	public List<Object[]> findBybestseller() {
	    open();
	    try {
	        return em.createNativeQuery("SELECT * FROM Vista_ProductosMasVendidos").getResultList();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
	    }
	    return null; // Se recomienda usar List en lugar de ArrayList en la declaración del tipo de retorno
	}
	
	

	@Override
	public boolean update(int id, Object o) {
		   open();
		    try {
		        em.getTransaction().begin();
		        Producto selectedProducto = em.find(Producto.class, id);
		        if (selectedProducto != null) {
		            Producto newProducto = (Producto) o;

		            // Actualizar los atributos del producto seleccionado con los nuevos valores
		            selectedProducto.setNombre(newProducto.getNombre());
		            selectedProducto.setDescripcion(newProducto.getDescripcion());
		            selectedProducto.setPrecio(newProducto.getPrecio());
		            selectedProducto.setCantidad_inventario(newProducto.getCantidad_inventario());

		            em.getTransaction().commit();
		            return true;
		        } else {
		            // Manejar el caso en el que no se encuentra el producto con el nombre dado
		            System.out.println("Producto no encontrado con el id: " + id);
		            return false;
		        }
		    } catch (Exception e) {
		        // Manejar cualquier excepción durante la actualización
		        System.out.println("Error al actualizar el producto: " + e.getMessage());
		        if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
		        return false;
		    } finally {
		      em.close();
		    }
	}

	@Override
	public Producto findOne(int id) {
		open();
		try {
			Producto selectedProducto = em.find(Producto.class, id);
			return selectedProducto;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	

}
