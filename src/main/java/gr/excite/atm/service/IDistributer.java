package gr.excite.atm.service;

import gr.excite.atm.model.Demand;

public interface IDistributer {

	public void giveMoney(Demand demand);
	
	public void setNextDistributer(IDistributer nextDistributer);
}
