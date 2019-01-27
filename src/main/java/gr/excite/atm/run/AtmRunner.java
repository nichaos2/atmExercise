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
import gr.excite.atm.service.CombinationController;
import gr.excite.atm.service.Distributer20s;
import gr.excite.atm.service.Distributer50s;
import gr.excite.atm.service.IDistributer;

public class AtmRunner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AtmConfiguration.class);

		Atm atm = (Atm) context.getBean("atm");
		AtmController atmC = (AtmController) context.getBean("atmC");
		CombinationController combC = (CombinationController) context.getBean("combC");
		
		// set chain
		IDistributer distr50s = (Distributer50s) context.getBean("distr50s");
		IDistributer distr20s = (Distributer20s) context.getBean("distr20s");
		distr50s.setNextDistributer(distr20s);
		
		// initialise atm
		System.out.println("Enter number of 20 notes to insert to ATM ");
		Scanner input = new Scanner(System.in);
		int nbrOf20s = input.nextInt();
		System.out.println("Enter number of 50 notes to insert to ATM ");
		input = new Scanner(System.in);
		int nbrOf50s = input.nextInt();
		atmC.insert20s(nbrOf20s);
		atmC.insert50s(nbrOf50s);
		
		// withdraw money
		System.out.println("Money in ATM " + atmC.returnTotal());
		System.out.println("Enter amount to dispense");
		input = new Scanner(System.in);
		int amount = input.nextInt();
		if (!combC.combinationExists(amount)) {
			System.out.println("Sorry for the incovenience!");
		}else {
		distr50s.giveMoney(new Demand(amount));
		
		// show message
		System.out.println("Total in ATM " + atmC.returnTotal());
		System.out.println(atm.getNbrOfTwenties() + " 20 notes remaining");
		System.out.println(atm.getNbrOfFifties()  + " 50 notes remaining");;
		}
	}


	
}
