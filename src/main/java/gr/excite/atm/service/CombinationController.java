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
		int remainderOf50s = amount % 50;
		System.out.println("amount reamining " + remainderOf50s);
		if (remainderOf50s == 0) {
			if (enough50s(remainderOf50s)) {
				return true;
			} else {
				
			}
		}

		// combination of fifties and twenties
		int amountOf50s = (amount/50) * 50;
		int remainderOf20s = (amount - amountOf50s) % 20;
		System.out.println("amount " + amount);
		System.out.println("subtract " + amountOf50s);
		System.out.println("amount reamining " +  remainderOf20s);
		int amountOf20s = (amount-amountOf50s)/20;
		if (remainderOf20s == 0) {
			if (enough20s(amountOf20s) && enough50s(amountOf50s)) {
				return true;
			}
		} else {
			// TODO message handler
			//System.out.println("Not enough 50s and 20s in this machine");
		}

		// Combination of twenties
		int remainderOfOnly20s = amount % 20;
		System.out.println( "amount reamining " + remainderOfOnly20s);

		if (remainderOfOnly20s == 0) {
			if (enough20s(remainderOfOnly20s)) {
				return true;
			} else {

			}
		}

		// else
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
