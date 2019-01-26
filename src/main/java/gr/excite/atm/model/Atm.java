package gr.excite.atm.model;

import org.springframework.stereotype.Component;

@Component("atm")
public class Atm {
	private int nbrOfTwenties;
	private int nbrOfFifties;
	
	// Constructors
	public Atm() {
	}
	
	public Atm(int nbrOfTwenties, int nbrOfFifties) {
		this.nbrOfTwenties = nbrOfTwenties;
		this.nbrOfFifties  = nbrOfFifties;
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
}

