package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Factura;
import co.edu.unbosque.model.Forma_pago;
import co.edu.unbosque.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FacturaDao implements DaoCrud{

	private EntityManagerFactory emf;
	private EntityManager em;

	public FacturaDao() {
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

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<?> findAll() {
		open();
		try {
			return (ArrayList<Factura>) em.createQuery("SELECT f FROM Factura f").getResultList();

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
		return new ArrayList<Factura>();
	}

	@Override
	public Object findOne(int id) {
		open();
		try {
			Factura selectedFactura= em.find(Factura.class, id);
			return selectedFactura;
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
