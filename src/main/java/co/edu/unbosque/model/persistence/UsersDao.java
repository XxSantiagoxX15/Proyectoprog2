package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuarios_drogueria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsersDao implements DaoCrud  {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public UsersDao() {

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
		open();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Usuarios_drogueria.class, id));
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
			Usuarios_drogueria selectedUser = em.find(Usuarios_drogueria.class, id);
			Usuarios_drogueria newUser = (Usuarios_drogueria) o;
			selectedUser.setNombre(newUser.getNombre());
			selectedUser.setApellido(newUser.getApellido());
			selectedUser.setEmail(newUser.getEmail());
			selectedUser.setUser_password(newUser.getUser_password());
			em.persist(newUser);
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
	public ArrayList<?> findAll() {
		open();
		try {
			return (ArrayList<Usuarios_drogueria>)em.createQuery("SELECT u FROM Usuarios_drogueria u").getResultList();
         
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return new ArrayList<Usuarios_drogueria>();
	}

	@Override
	public Usuarios_drogueria findOne(int id) {
		open();
		try {
			Usuarios_drogueria selectedUser = em.find(Usuarios_drogueria.class, id);
			return selectedUser;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
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
