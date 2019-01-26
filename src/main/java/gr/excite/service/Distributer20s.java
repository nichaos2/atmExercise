package gr.excite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.excite.atm.model.Demand;

@Service
public class Distributer20s implements IDistributer {

	@Autowired
	AtmController atmC;
	@Autowired
	Demand demand;

	@Override
	public void giveMoney(Demand demand) {
		if(demand.getAmount() >= 20) {
			int nbrOf20s = demand.getAmount() / 20; 
			int remainder = demand.getAmount() % 20; 
			System.out.println("Distributed " + nbrOf20s + " 20 note(s)");
			
			atmC.remove20s(nbrOf20s);
		}
		
	}
	

}
