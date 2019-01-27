package gr.excite.atm.model;

import org.springframework.stereotype.Component;

@Component
public class Demand {

	private int amount;

	public Demand() {
		
	}
	public Demand(int amount) {
		this.amount= amount;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
