package DAO;

import java.util.List;

import model.Banda;

public interface IBandaDAO extends IGenericDAO<Banda> {
	
	public Banda findById(int id);
	
	public List<Banda> findByNombre(String nombre);

}
