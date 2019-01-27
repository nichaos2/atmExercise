package gr.excite.atm.run;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gr.excite.atm.model.Demand;
import gr.excite.atm.service.AtmController;
import gr.excite.atm.service.CombinationController;
import gr.excite.atm.service.Distributer20s;
import gr.excite.atm.service.Distributer50s;
import gr.excite.atm.service.IDistributer;

public class AtmRunner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AtmConfiguration.class);

		AtmController atmC = (AtmController) context.getBean("atmC");
		CombinationController combC = (CombinationController) context.getBean("combC");

		// set chain of Distributes
		IDistributer distr50s = (Distributer50s) context.getBean("distr50s");
		IDistributer distr20s = (Distributer20s) context.getBean("distr20s");
		distr50s.setNextDistributer(distr20s);

		// initialise atm
		AtmRunner atmRunner = new AtmRunner();
		atmRunner.initialiseATM(atmC);

		// way to test multiple times
		int n = 1;
		while (n < 2) {
			atmRunner.withdrawMoney(atmC, combC, distr50s, distr20s);
			n++;
			n = atmRunner.requestAnotherWithdraw(n);
		}
		System.out.println("Thank you. Bye bye!");
	}

	private void initialiseATM(AtmController atmC) {
		System.out.println("Enter number of 20 notes to insert to ATM ");
		Scanner input = new Scanner(System.in);
		int nbrOf20s = input.nextInt();
		System.out.println("Enter number of 50 notes to insert to ATM ");
		input = new Scanner(System.in);
		int nbrOf50s = input.nextInt();
		atmC.insert20s(nbrOf20s);
		atmC.insert50s(nbrOf50s);
	}

	private void withdrawMoney(AtmController atmC, CombinationController combC, IDistributer distr50s, IDistributer distr20s) {
		System.out.println("Money in ATM " + atmC.returnTotal());
		System.out.println("Enter amount to dispense");
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();
		if (!combC.combinationExists(amount)) {
			System.out.println("Sorry for the incovenience!");
		} else {
			if (combC.getCombination().equals("only20s"))
				distr20s.giveMoney(new Demand(amount));
			else
				distr50s.giveMoney(new Demand(amount));

			// show message
			System.out.println("Total in ATM " + atmC.returnTotal());
			System.out.println(atmC.returnNbrOf20s() + " 20 notes remaining");
			System.out.println(atmC.retrunNbrOf50s() + " 50 notes remaining");
		}

	}

	private int requestAnotherWithdraw(int n) {
		System.out.println(
				"Do you want another withdrawal? Print yes if you want or anything else to terminate the transaction");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		if (answer.toLowerCase().equals("yes"))
			n = 1;
		return n;
	}
}
