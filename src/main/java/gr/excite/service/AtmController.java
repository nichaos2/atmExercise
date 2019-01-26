package gr.excite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.excite.atm.model.Atm;

@Service
public class AtmController implements IAtmController {

	@Autowired
	private Atm atm;

	@Override
	public void insert20s(int nbrOf20s) {
		atm.setNbrOfTwenties(nbrOf20s);
	}

	@Override
	public void insert50s(int nbrOf50s) {
		atm.setNbrOfFifties(nbrOf50s);
	}

	@Override
	public void remove20s(int nbrOf20s) {
		atm.setNbrOfTwenties(atm.getNbrOfTwenties() - nbrOf20s);
	}

	@Override
	public void remove50s(int nbrOf50s) {
		atm.setNbrOfTwenties(atm.getNbrOfFifties() - nbrOf50s);
	}

	@Override
	public int returnTotal() {
		return atm.getNbrOfFifties() * 50 + atm.getNbrOfTwenties() * 20;
	}

}
