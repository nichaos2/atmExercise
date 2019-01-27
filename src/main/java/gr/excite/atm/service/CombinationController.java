package gr.excite.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("combC")
public class CombinationController implements ICombinationController {

	
	private String combination;
	
	@Autowired
	AtmController atmC;

	@Override
	public boolean combinationExists(int amount) {
	
		// combination of fifties
		int remainderOf50s 	= amount % 50;
		int nbrOf50s 		= amount/50;
		if (remainderOf50s == 0) {
			if (isEnough50s(nbrOf50s)) {
				setCombination("only50s");
				return true;
			} 
		}

		// combination of fifties and twenties
		int remainderOf20s 	= (amount - nbrOf50s * 50)%20;
		int nbrOf20s 		= (amount - nbrOf50s * 50)/20;
		if (remainderOf20s == 0) {
			if (isEnough20s(nbrOf20s) && isEnough50s(nbrOf50s)) {
				setCombination("20sAnd50s");
				return true;
			}
		} 

		// Combination of twenties
		int remainderOfOnly20s 	= amount % 20;
		int nbrOfOnly20s 		= amount / 20;
		if (remainderOfOnly20s == 0) {
			if (isEnough20s(nbrOfOnly20s)) {
				setCombination("only20s");
				return true;
			} 
		}

		// if no combinations
		System.out.println("Please try another amount which is combination of 20s and 50s");
		return false;
	}

	private boolean isEnough50s(int remainderOf50s) {
		if (remainderOf50s <= atmC.retrunNbrOf50s())
			return true;

		// TODO message handler
		System.out.println("Not enough 50s in this machine");
		return false;
	}

	private boolean isEnough20s(int remainderOf20s) {
		if (remainderOf20s <= atmC.returnNbrOf20s())
			return true;

		// TODO message handler
		System.out.println("Not enough 20s in this machine");
		return false;
	}

	public String getCombination() {
		return combination;
	}

	public void setCombination(String combination) {
		this.combination = combination;
	}

}
