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
import gr.excite.atm.service.ICombinationController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/resources/application-context.xml"))

public class CombinationControllerTest {

	@Autowired
	Atm atm;
	int initial20s = 10;
	int initial50s = 3;
	@Autowired
	ICombinationController combControl;
	
	
	@Before
	public void initAtm() {
		atm.setNbrOfTwenties(initial20s);
		atm.setNbrOfFifties(initial50s);
		System.out.println("Initialised amount in ATM " + (initial20s*20 + initial50s*50));
	}
	
	@Ignore
	@Test
	public void testCombinationOf50sExists() {
		int amount = 250;
		assertEquals(true, combControl.combinationExists(amount) );
		
	}
	@Ignore
	@Test
	public void testCombinationOf50sAnd20sExists() {
		int amount = 270;
		assertEquals(true, combControl.combinationExists(amount) );
		
	}
	
	@Ignore
	@Test
	public void testCombinationOf20sExists() {
		int amount = 60;
		assertEquals(true, combControl.combinationExists(amount) );
		
	}
	
	@Test
	public void testEnoughExists() {
		int amount = 180;
		int nbrOf20s = atm.getNbrOfTwenties();
		System.out.println(nbrOf20s);
		assertEquals(true, combControl.combinationExists(amount));
	}
	
}
