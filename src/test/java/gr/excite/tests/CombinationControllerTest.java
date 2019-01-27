package gr.excite.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gr.excite.atm.service.ICombinationController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/resources/application-context.xml"))

public class CombinationControllerTest {

	@Autowired
	ICombinationController combControl;
	

	@Ignore
	@Test
	public void testCombinationOfFiftiesExists() {
		int amount = 250;
		assertEquals(true, combControl.combinationExists(amount) );
		
	}
	@Ignore
	@Test
	public void testCombinationOfFiftiesAndTweentiesExists() {
		int amount = 270;
		assertEquals(true, combControl.combinationExists(amount) );
		
	}
	
	@Test
	public void testCombinationOfTweentiesExists() {
		int amount = 60;
		assertEquals(true, combControl.combinationExists(amount) );
		
	}
	
}
