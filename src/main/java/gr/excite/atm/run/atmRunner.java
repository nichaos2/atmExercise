package gr.excite.atm.run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gr.excite.atm.model.Atm;

public class atmRunner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		Atm atm = (Atm) context.getBean("atm");
		
	}

}
