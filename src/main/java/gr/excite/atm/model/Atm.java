package gr.excite.atm.model;

public class Atm {
	private int nbrOfTwenties;
	private int nbrOfFifties;
	
	//TODO is the logic for this needed
	private int totalAmount;

	// Constructors
	public Atm() {
		
	}
	
	public Atm(int nbrOfTwenties, int nbrOfFifties) {
		this.nbrOfTwenties = nbrOfTwenties;
		this.nbrOfFifties  = nbrOfFifties;
		setTotalAmount(this.nbrOfTwenties * 20 + this.nbrOfFifties * 50);
		
	}

	// getters setters
	public int getNbrOfTwenties() {
		return nbrOfTwenties;
	}


	public void setNbrOfTwenties(int nbrOfTwenties) {
		this.nbrOfTwenties = nbrOfTwenties;
	}


	public int getNbrOfFifties() {
		return nbrOfFifties;
	}


	public void setNbrOfFifties(int nbrOfFifties) {
		this.nbrOfFifties = nbrOfFifties;
	}


	public int getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
