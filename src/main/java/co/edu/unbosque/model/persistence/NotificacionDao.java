package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Notificacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NotificacionDao implements DaoCrud {
	private EntityManagerFactory emf;
	private EntityManager em;

	public NotificacionDao() {
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
	public ArrayList<Notificacion> findAll() {
		open();
		try {
			return (ArrayList<Notificacion>) em.createQuery("SELECT n FROM Notificacion n").getResultList();

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
		return new ArrayList<Notificacion>();
	}

	public Object findOne(String email) {
		open();
		try {
			Notificacion selectedNotificacion = em.find(Notificacion.class,email);
			return selectedNotificacion;
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
	public Object findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
