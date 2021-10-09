package DAO;

public class MissingDataException extends RuntimeException {

 static final long serialVersionUID = -6664324794874412147L;

	public MissingDataException(Exception e) {
		super(e);
	}
}
