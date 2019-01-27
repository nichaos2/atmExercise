package gr.excite.atm.service;

public interface IAtmController {

	public void insert20s(int nbrOf20s);
	public void insert50s(int nbrOf50s);
	
	public void remove20s(int nbrOf20s);
	public void remove50s(int nbrOf50s);
	
	public int returnNbrOf20s();
	public int retrunNbrOf50s();
	
	public int returnTotal();
	
}
