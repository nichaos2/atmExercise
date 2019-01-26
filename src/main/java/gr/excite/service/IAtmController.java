package gr.excite.service;

public interface IAtmController {

	public void insert20s(int nbrOf20s);
	public void insert50s(int nbrOf50s);
	
	public void remove20s(int nbrOf20s);
	public void remove50s(int nbrOf50s);
	
	public int returnTotal();
	
}
