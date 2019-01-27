package gr.excite.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.excite.atm.model.Demand;

@Service("distr20s")
public class Distributer20s implements IDistributer {

	@Autowired
	IDistributer nextDistributer;
	@Autowired
	AtmController atmC;
	@Autowired
	Demand demand;
	@Autowired
	IMessageHandler message;

	@Override
	public void giveMoney(Demand demand) {
		if(demand.getAmount() >= 20) {
			int nbrOf20s = demand.getAmount() / 20; 
			
			message.display("Distributed " + nbrOf20s + " 20 note(s)");
			
			atmC.remove20s(nbrOf20s);
		}		
	}

	@Override
	public void setNextDistributer(IDistributer nextDistributer) {
		this.nextDistributer = nextDistributer;
	}
	

}
