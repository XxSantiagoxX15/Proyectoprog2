package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDao  implements DaoCrud{
	private EntityManagerFactory emf;
	private EntityManager em;
	

	public ClienteDao() {
		emf = Persistence.createEntityManagerFactory("ClientePu");
		em = emf.createEntityManager();


	}

	public void open() {
		if (!emf.isOpen() || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("ClientePu");
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
	@Override
	public boolean delete(int id) {
		open();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Cliente.class,id));
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
	
	
	@Override
	public boolean update(int id, Object o) {
		open();
		try {
			em.getTransaction().begin();
			Producto selectedProducto = em.find(Producto.class, id);
			Producto newProducto = (Producto) o;
			selectedProducto.setNombre(newProducto.getNombre());
			selectedProducto.setDescripcion(newProducto.getDescripcion());
			selectedProducto.setPrecio(newProducto.getPrecio());
			selectedProducto.setCantidad_inventario(newProducto.getCantidad_inventario());
			em.persist(newProducto);
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



	@Override
	public ArrayList<Cliente> findAll() {
		open();
		try {
			return (ArrayList<Cliente>) em.createQuery("SELECT c FROM Cliente c").getResultList();

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
		return new ArrayList<Cliente>();
	}

	@Override
	public Cliente findOne(int id) {
		open();
		try {
			Cliente selectedProducto = em.find(Cliente.class, id);
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
