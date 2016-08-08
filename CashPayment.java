/*
Class Definition:
		Java class which extends base class Payment.  All accessor, constructor and mutator
		methods are handled/directed to base class Payment.

Dependents:
		GHP03.java - driver program
		Payment.java - base class

Variables Dictionary:
		NONE


Written by Jerry Stuart
Revision v5, last updated 04/19/16
Sources used/referenced were provided by class text and examples covered during lectures.
*/
public class CashPayment extends Payment
{
	public CashPayment()
	/*
	Constructor method - default
	Preconditions:	None.
	Postconditions:	Creates CashPayment object by calling the default base class constructor.
	*/
	{
		super();
	}

	public CashPayment(double amount)
	/*
	Constructor method - argument
	Preconditions:	A CashPayment object must exist.
	Postconditions:	Creates CashPayment object by calling the argument base class constructor
			and passing double argument.
	*/
	{
		super(amount);
	}

	public void paymentDetails()
	/* 
	Display method - displays all details associated with CashPayment object, formatted into a sentence. 
	Preconditions:	None.
	Postconditions:	Displays an English sentence describing the payment amount as a System output
			String has been paid in cash by overriding display method of the base class.
	*/
	{
		super.paymentDetails();
		System.out.printf(" has been paid in cash.\n");
	}
}
