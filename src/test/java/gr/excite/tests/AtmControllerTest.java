package gr.excite.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gr.excite.atm.model.Atm;
import gr.excite.atm.service.IAtmController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/resources/application-context.xml"))

public class AtmControllerTest {

	@Autowired
	private Atm atm;
	@Autowired
	private IAtmController atmCotroller;

	// same for insert50s
	@Ignore
	@Test
	public void testInsert20s() {
		int nbrOf20s = 2;
		atmCotroller.insert20s(nbrOf20s);
		assertEquals(nbrOf20s, atm.getNbrOfTwenties());
	}

	// same for remove50s
	@Ignore
	@Test
	public void testRemove20s() {
		int initial20s = 5;
		int disposed20s = 2;

		atm.setNbrOfTwenties(initial20s);
		atmCotroller.remove20s(disposed20s);

		assertEquals(initial20s - disposed20s, atm.getNbrOfTwenties());
	}

	@Test
	public void testReturnTotal() {
		int initial50s = 5;
		int initial20s = 7;
		int total = initial50s * 50 + initial20s * 20;
		atm.setNbrOfFifties(initial50s);
		atm.setNbrOfTwenties(initial20s);

		assertEquals(total, atmCotroller.returnTotal());
	}
}
