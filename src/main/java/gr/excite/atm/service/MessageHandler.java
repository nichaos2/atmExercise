package gr.excite.atm.service;

import org.springframework.stereotype.Service;

@Service("msg")
public class MessageHandler implements IMessageHandler{

	@Override
	public void display(String message) {
		System.out.println(message);
	}

}
