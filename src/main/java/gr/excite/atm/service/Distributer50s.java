package gr.excite.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.excite.atm.model.Demand;

@Service("distr50s")
public class Distributer50s implements IDistributer{
	
	@Autowired
	IDistributer nextDistributer;
	
	@Autowired
	AtmController atmC;
	@Autowired
	Demand demand;

	@Override
	public void giveMoney(Demand demand) {
		if(demand.getAmount() >= 50) {
			int nbrOf50s = demand.getAmount() / 50; 
			int remainder = demand.getAmount() % 50; 
			
			// message handler
			System.out.println("Distributed " + nbrOf50s + " 50 note(s)");
			
			// 
			atmC.remove50s(nbrOf50s);
			
			if (remainder!=0) this.nextDistributer.giveMoney(new Demand(remainder));
		}else {
			this.nextDistributer.giveMoney(demand);
		}
		
	}

	@Override
	public void setNextDistributer(IDistributer nextDistributer) {
		this.nextDistributer = nextDistributer;
	}
	
}
