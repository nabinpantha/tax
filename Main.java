package problemThree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userTransaction();

	}

	private static void userTransaction() {
		Person person = new Person();

		Scanner a = new Scanner(System.in);

		System.out.println("Please enter employee name");
		person.setName(a.nextLine());

		System.out.println("Please enter paytype");
		System.out.println("Enter 'H' for hourly and 'S' for annually ");
		person.setPayType(a.nextLine());
		if (person.getPayType().equalsIgnoreCase("h")) {
			rateValue(person, a);
			if ((person.getHourlyRate() < 5.15) || (person.getHourlyRate() > 25)) {
				System.out.println("-------Wrong user input-------- please type user input again");
				rateValue(person, a);
			}

			else if ((person.getHour() < 0) || (person.getHour() > 60)) {
				System.out.println("-------Wrong user input-------- please type user input again");
				rateValue(person, a);
			}

		} else if (person.getPayType().equalsIgnoreCase("s")) {
			System.out.println("Please enter Annual salary");
			person.setAnnualsalary(a.nextDouble());
		}
		a.close();
		double grossPay = TestClass.grossPay(person);

		System.out.println("Weekly Gross Pay is " + grossPay);

		if (person.getPayType().equalsIgnoreCase("h")) {

			System.out.println("Annual federal tax is " + TestClass.federalTaxHourly(person));
			System.out
					.println("Net pay is " + (TestClass.grossPay(person) - (TestClass.federalTaxHourly(person) / 52)));

		} else if (person.getPayType().equalsIgnoreCase("s")) {
			System.out.println("Annual federal tax is " + TestClass.federalTaxAnnually(person));
			System.out.println("Net pay is " + (TestClass.grossPay(person) - (TestClass.federalTaxAnnually(person))));

		}
		Scanner b = new Scanner(System.in);
		System.out.println("If you want to compute another user Please type 'Y' for Yes and 'N' for No");
		
		String userIntrest = b.nextLine();
		b.close();

		if (userIntrest.equalsIgnoreCase("y")) {
			userTransaction();

		}
	}

	private static void rateValue(Person person, Scanner a) {
		System.out.println("Please enter hourly Rate");
		person.setHourlyRate(a.nextDouble());

		System.out.println("Please enter employee hour");
		person.setHour(a.nextDouble());
	}
}
