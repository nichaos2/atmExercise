package gr.excite.atm.service;

import org.springframework.stereotype.Service;

@Service("combC")
public class CombinationController implements ICombinationController{

	@Override
	public boolean combinationExists(int amount) {
		
		// combination of fifties
		int remainderOf50s = amount%50;
		if (remainderOf50s == 0) return true;
		
		//combination of fifties and twenties
		int remainderOf50sand20s = (amount - amount/50*50)%20;
		if (remainderOf50sand20s == 0) return true;
		
		//Combination of twenties
		int remainderOf20s = amount%20;
		if (remainderOf20s == 0) return true;

		//else
		return false;
	}

	
	
}
