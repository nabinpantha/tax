package problemThree;

public class TestClass {

	public static double hourlywageweekly(Person person) {
		double weeklyGrossPayHourly = 0;
		if (person.getHour() <= 40) {

			return weeklyGrossPayHourly = person.getHour() * person.getHourlyRate();
		} else if (person.getHour() > 40 && person.getHour() <= 60) {
			return weeklyGrossPayHourly = (40 * person.getHourlyRate())
					+ ((person.getHour() - 40) * person.getHourlyRate() * 1.5);
		} else {
			System.out.println("Wrong Input !! Try Again ");
		}
		return weeklyGrossPayHourly;

	}

	public static double roundOff(double weeklyGrossPayHourly) {
		double roundOffWeeklyGrossPayHourly = Math.floor(weeklyGrossPayHourly * 100) / 100d;
		return roundOffWeeklyGrossPayHourly;
	}

	public static double weeklyWageAnnually(double annualSalary) {
		double weeklyGrossPayAnnually = annualSalary / 52;
		return weeklyGrossPayAnnually;
	}

	public static double grossPay(Person person) {
		if (person.getPayType().equalsIgnoreCase("h")) {
			double weeklyGrossPayHourly = hourlywageweekly(person);
			return roundOff(weeklyGrossPayHourly);
		} else if (person.getPayType().equalsIgnoreCase("s")) {
			return weeklyWageAnnually(person.getAnnualsalary());
		} else {
			System.out.println("Please Enter paytype again ----wrong user input-----");
		}
		return 0;
	}

	public static double federalTaxAnnually(Person person) {
		double tax = 0;
		if ((TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) > 0
				&& (TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) < 12000) {

			return tax = 0;// $0 $12,000 $0 0
		} else if ((TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) > 12000
				&& (TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) < 18000) {
			// $12,000 $18,000 $0 14% on Annual Gross Pay
			return tax = 0.14 * (TestClass.weeklyWageAnnually(person.getAnnualsalary())*52);
		}

		else if ((TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) > 18000
				&& (TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) < 29000) {
			// $18,000 $29,000 $840 16% on Annual Gross Pay above $18,000

			return tax = 840 + (0.16 * (18000 - ((TestClass.weeklyWageAnnually(person.getAnnualsalary())*52))));
		}

		else if ((TestClass.weeklyWageAnnually(person.getAnnualsalary())*52) > 29000) {
			// $29,000 $2600 19% on Annual Gross Pay above $29,000

			return tax = 2600 + (0.19 * (18000 - (TestClass.weeklyWageAnnually(person.getAnnualsalary())*52)));
		}
		return tax;
	}

	public static double federalTaxHourly(Person person) {
		double tax = 0;
		if ((TestClass.roundOff(hourlywageweekly(person))*52) > 0
				&& ((TestClass.roundOff(hourlywageweekly(person))*52) < 12000)) {

			return tax = 0;// $0 $12,000 $0 0
		} else if ((TestClass.roundOff(hourlywageweekly(person))*52) > 12000
				&& ((TestClass.roundOff(hourlywageweekly(person)))*52) < 18000) {
			// $12,000 $18,000 $0 14% on Annual Gross Pay
			return tax = 0.14 * (TestClass.roundOff(hourlywageweekly(person))*52);
		}

		else if ((TestClass.roundOff(hourlywageweekly(person))*52) > 18000
				&& ((TestClass.roundOff(hourlywageweekly(person)))*52) < 29000) {
			// $18,000 $29,000 $840 16% on Annual Gross Pay above $18,000

			return tax = 840 + (0.16 * (((TestClass.roundOff(hourlywageweekly(person)))*52)-18000) );
		}

		else if (((TestClass.roundOff(hourlywageweekly(person)))*52) > 29000) {
			// $29,000 $2600 19% on Annual Gross Pay above $29,000

			return tax = 2600 + (0.19 * (((TestClass.roundOff(hourlywageweekly(person)))*52) -29000 ));
		}
		return tax;
		
	}

	public  double federalTax(Person person) {
		if (person.getPayType().equalsIgnoreCase("h")) {
			return federalTaxHourly(person);
			
		} else if (person.getPayType().equalsIgnoreCase("s")) {
			return federalTaxAnnually(person);
		} 
		return 0;
	}
	public static  double netPay(Person person) {
			return (grossPay(person))- (federalTaxHourly(person)/52);
}}