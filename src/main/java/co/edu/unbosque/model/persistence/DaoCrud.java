package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface DaoCrud {
	public boolean create(Object o);
	public boolean delete(int id);
	public boolean delete(Object o);
	public boolean update(int id, Object o);
	public ArrayList<?>findAll();
	public Object findOne(int id);
}
