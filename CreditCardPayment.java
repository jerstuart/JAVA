/*
Class Definition
		Java class which extends base class Payment.  Creates a CreditCardPayment object
		when called by driver program by use of accessor, constructor and mutator methods.

Dependent(s)
		GHP03.java - driver program
		Payment.java - base class

Variables Dictionary
		cardName - private string which holds the full name of the credit card account holder
		MM - private integer which hold the numerical month value in which the account holder's
		     credit card expires
		YY - private integer which hold the numerical year value in which the account holder's
		     credit card expires
		ccNum - private long which holds the 16 digits of the account holder's credit card
		dateYear - private SimpleDateFormat used to format any class Date object to return only 
			   the last two digits in the year of said Date object.
		dateMonth - private SimpleDateFormat used to format any class Date object to return only 
			    the two digits in the month of said Date object.
		dateAtRuntime - private Date which holds the current date at this program's runtime
		currentMonth - private string which holds the current month at this program's runtime
		currentYear - private string which holds the current year at this program's runtime


Written by Jerry Stuart
Revision v5, last updated 04/19/16
Sources used/referenced were provided by class text and examples covered during lectures.
*/
import java.util.Date;			// contains methods used for Date objects
import java.text.SimpleDateFormat;	// contains methods used to format the output of Date objects

public class CreditCardPayment extends Payment
{
	private String cardName;
	private int MM, YY;
	private long ccNum;

	private SimpleDateFormat dateYear = new SimpleDateFormat("yy");
	private SimpleDateFormat dateMonth = new SimpleDateFormat("MM");
	private Date dateAtRuntime = new Date();
	private String currentMonth = dateMonth.format(dateAtRuntime);
	private String currentYear = dateYear.format(dateAtRuntime);

	public CreditCardPayment()
	/*
	Constructor method - default
	Preconditions:	None.
	Postconditions:	Creates CreditCardPayment object with default values hardcoded below.
			The amount assocated with this object is set by calling the default base class
			constructor.
	*/
	{
		super();
		cardName = "No name";
		ccNum = 1111111111111111L;
		MM = Integer.parseInt(currentMonth);
		YY = Integer.parseInt(currentYear);
	}

	public CreditCardPayment(double theAmount, String theCardName, String theCCnum, String mm, String dd)
	/*
	Constructor method - argument
	Preconditions:	A CreditCardPayment object must exist.
	Postconditions:	Creates CreditCardPayment object by calling the appropriate mutator method within
			this class along with associated arguments provided.  See mutator methods for 
			conditions.
			The amount assocated with this object is set by calling the argument base class
			constructor.
	*/
	{
		super(theAmount);
		setCardName(theCardName);
		setCCnum(theCCnum);
		setExpDate(mm, dd);
	}

	public void setCardName(String newName)
	/*
	Mutator method - Set credit card account holder's name.
	Preconditions:	String argument cannot be NULL.
	Postconditions:	Sets value of private string cardName to the value of the string argument provided.
	*/
	{
		if(newName == null)
		{
			System.out.println("Fatal Error setting cardName for class CreditCardPayment.");
			System.exit(0);
		}
		else
			cardName = newName;
	}

	public String getCardName()
	/*
	Accessor method - returns credit card account holder's name as a string.
	Preconditions:	None.
	Postconditions:	Returns the value of private string cardName as a string.
	*/
	{
		return cardName;
	}

	public void setCCnum(String newCC)
	/*
	Mutator method - sets the 16 digits of the account holder's credit card.
	Preconditions:	String argument must be a valid length of 16 (credit card number).
	Postconditions:	Sets value of private long ccNum by parsing the string argument provided.
	*/
	{
		if(newCC.length() != 16)
		{
			System.out.println("Fatal Error: CC# length invalid (16 expected).");
			System.exit(0);
		}
		else
			ccNum = Long.parseLong(newCC);
	}

	public long getCCnum()
	/*
	Accessor method - returns the 16 digits of the account holder's credit card as a long.
	Preconditions:	None.
	Postconditions:	Returns the 16 digits of the account holder's credit card as a long.
	*/
	{
		return ccNum;
	}

	public void setExpDate(String mm, String yy)
	/*
	Mutator method - sets the expiration date of the account holder's credit card as two strings for month and year.
	Preconditions:	Credit card expiration date must be valid, will not accept any date passed the current date
			at runtime.  Also note that month and year values must fall between 0-12 and 00-99
			respectivley.  Arguments cannot be NULL.
	Postconditions:	Sets the values of private integers MM and YY by parsing the string arguments provided.
	*/
	{
		if(mm == null || yy == null)
		{
			System.out.println("Fatal Error: setDate NULL");
			System.exit(0);
		}
		else
		{
			MM = Integer.parseInt(mm);
			YY = Integer.parseInt(yy);
		}

		if((MM > 12 || MM < 1) || (MM < Integer.parseInt(currentMonth) && YY == Integer.parseInt(currentYear)))
		// Checks if the month falls between 1 OR 12 OR expiration date hasn't passed the current date at runtime.
		{
			System.out.println("Fatal Error: Month out-of-range (1-12)");
			System.exit(0);
		}
		else if(YY > 99 || YY < Integer.parseInt(currentYear))
		{
			System.out.println("Fatal Error: Year out-of-range (" + Integer.parseInt(currentYear) + "-99)");
			System.exit(0);
		}
	}

	public String getExpDate()
	/*
	Accessor method - returns the expiration date of the account holder's credit card as a readable string
	Preconditions:	None.
	Postconditions:	Returns the values of private integers MM and YY as a string with the "/" delimiter between them.
	*/
	{
		return (MM + "/" + YY);
	}

	public void paymentDetails()
	/* 
	Display method - displays all details associated with CashPayment object, formatted into a sentence. 
	Preconditions:	None.
	Postconditions:	Displays an English sentence describing the payment amount as a System output String has been paid
			by a credit card by overriding display method of the base class.
	*/
	{
		super.paymentDetails();
		System.out.printf(" has been paid by " + cardName + "'s\ncredit card with account number " + ccNum + " which expires on " + getExpDate() +".\n");
	}
}
