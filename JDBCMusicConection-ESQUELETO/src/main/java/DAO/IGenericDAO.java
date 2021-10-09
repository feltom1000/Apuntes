package DAO;

import java.util.List;

public interface IGenericDAO<T> {
	
	public List<T> findAll(); //SELECT * FROM <T>
	
	public int countAll();
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	

}
