/*
Class Definition
		Java class Payment creates a Payment object when called by driver program by use of
		accessor, constructor and mutator methods.

Dependent:
		GHP03.java - driver program

Variables Dictionary
		amount - private double containing the double payment value for class Payment


Written by Jerry Stuart
Revision v5, last updated 04/19/16
Sources used/referenced were provided by class text and examples covered during lectures.
*/
public class Payment
{
	private double amount;

	public Payment()
	/*
	Constructor method - default
	Preconditions:	None.
	Postconditions:	Creates Payment object, sets payment amount to zero.
	*/
	{
		amount = 0;
	}

	public Payment(double theAmount)
	/*
	Constructor method - argument
	Preconditions:	A Payment object must exist.
	Postconditions:	Creates Payment object, sets payment amount to the value of double argument 
			provided.
	*/
	{
		if(theAmount == -1)
		{
			System.out.println("Fatal Error creating Payment object.");
			System.exit(0);
		}

		amount = theAmount;
	}

	public void setAmount(double newAmount)
	/*
	Mutator method - sets the payment amount of Payment object
	Preconditions:	Double argument must be greater than zero.
	Postconditions:	Sets value of private double amount to the value of double argument provided.
	*/
	{
		if(newAmount <= 0)
		{
			System.out.println("Fatal Error setting payment amount (value must be > 0).");
			System.exit(0);
		}
		else
			amount = newAmount;
	}

	public double getAmount()
	/*
	Accessor method - returns the payment amount of Payment object as a double.
	Preconditions:	None.
	Postconditions:	Returns the value of private double amount.
	*/
	{
		return amount;
	}

	public void paymentDetails()
	/* 
	Display method - displays all details associated with Payment object, formatted into a sentence.
	Preconditions:	None.
	Postconditions:	Displays an English sentence describing the payment amount as a System output
			String.
	*/
	{
		System.out.printf("The payment amount of $%#.2f", amount);
	}
}
