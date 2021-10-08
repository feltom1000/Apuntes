package app;

import DAO.DAOFactory;
import DAO.IBandaDAO;
import DAO.IGeneroDAO;
import model.Banda;

public class App {
	public static void main(String[] args) {
		IBandaDAO bandaDAO = DAOFactory.getBandaDAO();
		IGeneroDAO generoDAO = DAOFactory.getGeneroDAO();
		

		
//		Banda nueva = new Banda(12, "Skrillex", 5, 2);
//		bandaDAO.insert(nueva);
		
		System.out.println(bandaDAO.findByNombre("Skrillex"));
		System.out.println(bandaDAO.findByNombre("lalala"));
		System.out.println(bandaDAO.findAll());
		
		System.out.println(generoDAO.findAll());
	}

}
