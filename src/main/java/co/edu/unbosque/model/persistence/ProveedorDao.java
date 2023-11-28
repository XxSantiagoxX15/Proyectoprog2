package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProveedorDao implements DaoCrud {
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProveedorDao() {
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

	public boolean delete(String nombre) {
		open();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Proveedor.class, nombre));
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

	public boolean update(String nombre, Object o) {
		open();
		try {
			em.getTransaction().begin();
			Proveedor selectedProveedor = em.find(Proveedor.class, nombre);
			Proveedor newProveedor = (Proveedor) o;
			selectedProveedor.setNombre(newProveedor.getNombre());
			selectedProveedor.setEmail(newProveedor.getEmail());
			selectedProveedor.setTelefono(newProveedor.getTelefono());

			em.persist(newProveedor);
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
	public ArrayList<Proveedor> findAll() {
		open();
		try {
			return (ArrayList<Proveedor>) em.createQuery("SELECT p FROM Proveedor p").getResultList();

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
		return new ArrayList<Proveedor>();
	}

	public Proveedor findOne(String nombre) {
		open();
		try {
			Proveedor selectedProveedor = em.find(Proveedor.class, nombre);
			return selectedProveedor;
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

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
