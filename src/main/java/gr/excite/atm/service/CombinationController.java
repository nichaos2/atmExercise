package gr.excite.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.excite.atm.model.Atm;

@Service("combC")
public class CombinationController implements ICombinationController {

	@Autowired
	Atm atm;

	@Override
	public boolean combinationExists(int amount) {
	
		// combination of fifties
		int remainderOf50s 	= amount % 50;
		int nbrOf50s 		= amount/50;
		if (remainderOf50s == 0) {
			if (enough50s(nbrOf50s)) {
				return true;
			} 
		}

		// combination of fifties and twenties
		int remainderOf20s 	= (amount - nbrOf50s * 50)%20;
		int nbrOf20s 		= (amount - nbrOf50s * 50)/20;
		if (remainderOf20s == 0) {
			if (enough20s(nbrOf20s) && enough50s(nbrOf50s)) {
				return true;
			}
		} 

		// Combination of twenties
		int remainderOfOnly20s 	= amount % 20;
		int nbrOfOnly20s 		= amount / 20;
		if (remainderOfOnly20s == 0) {
			if (enough20s(nbrOfOnly20s)) {
				return true;
			} 
		}

		// if fails
		System.out.println("Please try another amount which is combination of 20s and 50s");
		return false;
	}

	private boolean enough50s(int remainderOf50s) {
		if (remainderOf50s <= atm.getNbrOfFifties())
			return true;

		// TODO message handler
		System.out.println("Not enough 50s in this machine");
		return false;
	}

	private boolean enough20s(int remainderOf20s) {
		if (remainderOf20s <= atm.getNbrOfTwenties())
			return true;

		// TODO message handler
		System.out.println("Not enough 20s in this machine");
		return false;
	}

}
