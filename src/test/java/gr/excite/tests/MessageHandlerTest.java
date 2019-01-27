package gr.excite.tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gr.excite.atm.service.IMessageHandler;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/resources/application-context.xml"))
public class MessageHandlerTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Autowired
	IMessageHandler message;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}


	@Test
	public void testDisplayMessage() {
		String myMessage = "myMessage";
		message.display(myMessage);
		assertEquals(myMessage+"\n", outContent.toString()); // this fails but the output is the same
	}	
	
	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
}
