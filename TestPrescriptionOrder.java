/*
 * Created on: Oct 19, 2022
 *
 * ULID: badavi4
 * Class: IT 168 
 */
package edu.ilstu;

/**
 * Creating a CVS program to help customers with their prescription orders
 *
 * @author <Brady Davidson>
 *
 */
import java.util.Scanner;

public class TestPrescriptionOrder
{

	/**
	 * @param args
	 */

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String action;

		PrescriptionOrder prescriptionOne = new PrescriptionOrder(1320335, "Peoria", "AMOXICILLIN 500 MG CAPSULE",
				"Antibiotic");
		PrescriptionOrder prescriptionTwo = new PrescriptionOrder(5304689, "Bloomington", "VITAMIN D2 1.25MG CAPSULE",
				"Vitamin Supplement");
		PrescriptionOrder prescriptionThree = new PrescriptionOrder(1145059, "Chicago", "FLUCERVAX QUAD SYRINGE",
				"Vaccine");

		System.out.println("Welcome to CVS!");
		System.out.println("Please choose one of the following: ");
		displayMenu();
		System.out.print("Enter your choice: ");
		action = input.next();
		while (!action.equalsIgnoreCase("Q"))
		{
			if (action.equalsIgnoreCase("L"))
			{
				System.out.println(prescriptionOne.toString());
				System.out.println(prescriptionTwo.toString());
				System.out.println(prescriptionThree.toString());

			} else if (action.equalsIgnoreCase("R"))
			{
				System.out.print("For which order? ");
				int rxNum = input.nextInt();
				if (rxNum == prescriptionOne.getNumberRx())
				{
					int refillsAvailable = prescriptionOne.getRefillsAvailable();
					if (refillsAvailable > 0)
					{
						prescriptionOne.refill();
						System.out.println("Refill successful.");
					} else
					{
						System.out.println("Refill unsuccessful.");
					}
				} else if (rxNum == prescriptionTwo.getNumberRx())
				{
					int refillsAvailable = prescriptionTwo.getRefillsAvailable();
					if (refillsAvailable > 0)
					{
						prescriptionTwo.refill();
						System.out.println("Refill successful.");
					} else
					{
						System.out.println("Refill unsuccessful.");
					}
				} else if (rxNum == prescriptionThree.getNumberRx())
				{
					int refillsAvailable = prescriptionThree.getRefillsAvailable();
					if (refillsAvailable > 0)
					{
						prescriptionThree.refill();
						System.out.println("Refill successful.");
					} else
					{
						System.out.println("Refill unsuccesful");
					}
				} else
				{
					System.out.println("Sorry, no matching order found.");
				}

			} else if (action.equalsIgnoreCase("T"))
			{
				System.out.print("For which order?");
				int rxNum = input.nextInt();

				if (rxNum == prescriptionOne.getNumberRx())
				{
					System.out.print("To which pharmacy?");
					String pharmacy = ("CVS-" + input.next());
					prescriptionOne.setPharmacyBranch(pharmacy);
					System.out.println("Transfer successful.");
				} else if (rxNum == prescriptionTwo.getNumberRx())
				{
					System.out.print("To which pharmacy?");
					String pharmacy = ("CVS-" + input.next());
					prescriptionTwo.setPharmacyBranch(pharmacy);
					System.out.println("Transfer successful.");
				} else if (rxNum == prescriptionThree.getNumberRx())
				{
					System.out.print("To which pharmacy?");
					String pharmacy = ("CVS-" + input.next());
					prescriptionThree.setPharmacyBranch(pharmacy);
					System.out.println("Transfer successful.");
				} else
				{
					System.out.println("Invaild RX number.");
				}
				// unfinished code

			}
			displayMenu();
			System.out.print("Enter your choice: ");
			action = input.next();
		}
		input.close();
	}

	public static void displayMenu()
	{
		System.out.println("L - list all Available precription orders\n");
		System.out.println("R - refill a prescription\n");
		System.out.println("T - transfer a prescription\n");
		System.out.println("Q - quit");

	}

}
