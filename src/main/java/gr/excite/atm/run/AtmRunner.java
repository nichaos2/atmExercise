package gr.excite.atm.run;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import gr.excite.atm.model.Atm;
import gr.excite.atm.model.Demand;
import gr.excite.atm.service.AtmController;
import gr.excite.atm.service.Distributer20s;
import gr.excite.atm.service.Distributer50s;
import gr.excite.atm.service.IDistributer;

public class AtmRunner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AtmConfiguration.class);

		Atm atm = (Atm) context.getBean("atm");
		AtmController atmC = (AtmController) context.getBean("atmC");
		
		// set chain
		IDistributer distr50s = (Distributer50s) context.getBean("distr50s");
		IDistributer distr20s = (Distributer20s) context.getBean("distr20s");
		distr50s.setNextDistributer(distr20s);
		
		
		// initialise atm
		int nbgof20s = 100;
		int nbrOf50s = 100;
		atm.setNbrOfTwenties(nbgof20s);
		atm.setNbrOfFifties(nbrOf50s);
		System.out.println("Money in ATM " + atmC.returnTotal());
		
		// get the amount from console
		System.out.println("Enter amount to dispense");
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();
		if (amount % 10 != 0) {
			System.out.println("Amount should be in mutliple of 10");
			return;
		}
		System.out.println("amount "+ amount);

		// TODO check if it can be given
		// if yes do the configuration
		// call dispatcher
		distr50s.giveMoney(new Demand(amount));
		
		// show message
		System.out.println("Total in ATM " + atmC.returnTotal());
		System.out.println(atm.getNbrOfTwenties() + " 20 notes remaining");
		System.out.println(atm.getNbrOfFifties()  + " 50 notes remaining");;
		
		//TODO else if not ask for a different amount

	}

}
