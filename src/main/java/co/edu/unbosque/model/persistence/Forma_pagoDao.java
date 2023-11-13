package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Forma_pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Forma_pagoDao implements DaoCrud {
	private EntityManagerFactory emf;
	private EntityManager em;

	public Forma_pagoDao() {
		emf = Persistence.createEntityManagerFactory("FormapagoPu");
		em = emf.createEntityManager();

	}

	public void open() {
		if (!emf.isOpen() || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("FormapagoPu");
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
	public ArrayList<Forma_pago> findAll() {
		open();
		try {
			return (ArrayList<Forma_pago>) em.createQuery("SELECT f FROM Forma_pago f").getResultList();

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
		return new ArrayList<Forma_pago>();
	}

	
	public Forma_pago findOne(String nombre) {
		open();
		try {
			Forma_pago selectedForma_pago = em.find(Forma_pago.class,nombre);
			return selectedForma_pago;
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
	public Object findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
