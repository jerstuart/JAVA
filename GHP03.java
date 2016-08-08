/*
Class Definition
		Driver program for CS249 homework assignment #03.  Creates two of each extended Payment
		class objects.

Dependent(s)
		Payment.java - base class
		CashPayment.java - extends Payment class
		CreditCardPayment - extends Payment class

Variables Dictionary
		amt - double used to hold a temporary double to be used for setting a private 
		      Payment/CashPayment/CreditCardPayment variable. 
		buffer - string used to "flush the buffer".
		delimiters - string character used as a delimiter to seperate month and year values
			     from user input string.
		keyboard - scanner object used for input methods.
		Cash1 - CashPayment object from the CashPayment class, extending the Payment class.
		Cash2 - CashPayment object from the CashPayment class, extending the Payment class.
		Credit1 - CreditCardPayment object from the CreditCardPayment class, extending the
			  Payment class.
		Credit1 - CreditCardPayment object from the CreditCardPayment class, extending the
			  Payment class.
		inputDate - StringTokenizer used to store the string value entered by the user
			    when asked to enter the expiration date on the account holder's credit
			    card for Cashpayment object CreditCardPayment1.
		inputDate2 - StringTokenizer used to store the string value entered by the user
			     when asked to enter the expiration date on the account holder's credit
			     card for Cashpayment object CreditCardPayment2.

Written by Jerry Stuart
Revision v5, last updated 04/19/16
Sources used/referenced were provided by class text and examples covered during lectures.
*/
import java.util.*;	// contains methods for creating StringTokenizer and Scanner objects.

public class GHP03
{
	public static void main (String[] args)
	{
		double amt;
		String input, buffer, delimiters = "/";
		Scanner keyboard = new Scanner(System.in);
		CashPayment Cash1 = new CashPayment();
		CashPayment Cash2 = new CashPayment();
		CreditCardPayment Credit1 = new CreditCardPayment();
		CreditCardPayment Credit2 = new CreditCardPayment();

		System.out.println("**************************[NOTICE]**************************");
		System.out.println("* This program has been hardcoded to prompt the user for   *");
		System.out.println("* data which will be used in the creation of 2 CashPayment *");
		System.out.println("* and CreditCardPayment objects                            *");
		System.out.println("************************************************************");

	// Data entry for CashPayment objects
		System.out.println("\n_____[ CashPayment Objects ]_____");
		System.out.println("Enter payment amount for CashPayment 1");
		Cash1.setAmount(keyboard.nextDouble());
		buffer = keyboard.nextLine();

		System.out.println("Enter payment amount for CashPayment 2");
		Cash2.setAmount(keyboard.nextDouble());
		buffer = keyboard.nextLine();

	// Data entry for CreditCardPayment objects
		System.out.println("\n_____[ CreditCardPayment 1 ]_____");
		System.out.println("Please enter the name as it appears on your credit card:");
		Credit1.setCardName(keyboard.nextLine());
		System.out.println("Enter 16-digit card number (without dashes or spaces):");
		Credit1.setCCnum(keyboard.nextLine());
		System.out.println("Enter expiration date (ex. 2/18):");
		StringTokenizer inputDate = new StringTokenizer(keyboard.nextLine(), delimiters);
		Credit1.setExpDate(inputDate.nextToken(), inputDate.nextToken());
		System.out.println("Please enter payment amount:");
		Credit1.setAmount(keyboard.nextDouble());
		buffer = keyboard.nextLine();

		System.out.println("\n_____[ CreditCardPayment 2 ]_____");
		System.out.println("Please enter the name as it appears on your credit card:");
		Credit2.setCardName(keyboard.nextLine());
		System.out.println("Enter 16-digit card number (without dashes or spaces):");
		Credit2.setCCnum(keyboard.nextLine());
		System.out.println("Enter expiration date (ex. 2/18):");
		StringTokenizer inputDate2 = new StringTokenizer(keyboard.nextLine(), delimiters);
		Credit2.setExpDate(inputDate2.nextToken(), inputDate2.nextToken());
		System.out.println("Please enter payment amount:");
		Credit2.setAmount(keyboard.nextDouble());
		buffer = keyboard.nextLine();

	// Output details for CashPayment and CreditCardPayment objects
		System.out.println("\n_____[ Object outputs ]_____\n\t-~{ CashPayment 1 }~-");
		Cash1.paymentDetails();
		System.out.println("\n\t-~{ CashPayment 2 }~-");
		Cash2.paymentDetails();
		System.out.println("\n\t-~{ CreditCardPayment 1 }~-");
		Credit1.paymentDetails();
		System.out.println("\n\t-~{ CreditCardPayment 2 }~-");
		Credit2.paymentDetails();

/*	//Testing constructors using passed arguments
		CreditCardPayment CreditTest = new CreditCardPayment(100.51, "John Smith", "1111222233334444", "02", "18");
		CreditTest.paymentDetails();
		CashPayment CashTest = new CashPayment(123.45);
		CashTest.paymentDetails();
*/
	}
}
