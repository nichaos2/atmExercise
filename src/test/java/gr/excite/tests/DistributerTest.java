package gr.excite.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gr.excite.atm.model.Atm;
import gr.excite.atm.model.Demand;
import gr.excite.atm.service.IDistributer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/resources/application-context.xml"))

public class DistributerTest {

	@Autowired
	Atm atm;
	@Autowired
	Demand demand;
	@Autowired
	IDistributer distr20;
	
	private int initial20s = 100;
	
	@Before
	public void initAtm() {
		atm.setNbrOfTwenties(100);
		System.out.println("Initialised amount in ATM " + (initial20s*20));
	}
	
	// same for 50s
	@Ignore
	@Test
	public void testGiveMoney() {
		int amount = 20;
		demand.setAmount(amount);
		distr20.giveMoney(demand);
		// test how many 20s are left in the atm
		assertEquals(initial20s - amount/20, atm.getNbrOfTwenties());
	}
	
	
	
}
