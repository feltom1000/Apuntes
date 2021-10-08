package DAO;

public class DAOFactory {
	
	public static IBandaDAO getBandaDAO() {
		return new BandaDAOImpl();
	}
	
	public static IGeneroDAO getGeneroDAO() {
		return new GeneroDAOImpl();
	}
}
