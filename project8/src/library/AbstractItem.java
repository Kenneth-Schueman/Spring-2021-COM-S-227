package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class AbstractItem implements Item 
{
	
	/**
	 * Title of this item.
	 */
	private String title;

	/**
	 * Due date for this item. This value is null when not checked out.
	 */
	private Date dueDate;

	/**
	 * Patron to whom this item is checked out. This value is null when not checked
	 * out.
	 */
	private Patron checkedOutTo;

	/**
	 * Replacement cost for this Documentary.
	 */
	private double replacementCost;

	/**
	 * Duration of this Documentary, in minutes.
	 */
	private int duration;

	private int checkOutDays = 0;
	
	public void AbstractItem(String title, Date dueDate, Patron checkedOutTo, double replacemnetCost, int duration, int checkOutDays)
	{
		
	}

	public void checkIn() 
	{
		if (isCheckedOut()) 
		{
			checkedOutTo = null;
			dueDate = null;
		}
	}

	public void renew(Date now) 
	{
		// TODO Auto-generated method stub
		
	}

	public int compareTo(Item other) 
	{
		return title.compareTo(other.getTitle());
	}

	public String getTitle() 
	{
		return title;
	}

	public boolean isCheckedOut() 
	{
		return dueDate != null;
	}

	public Date getDueDate() 
	{
		return dueDate;
	}

	public Patron getPatron() 
	{
		return checkedOutTo;
	}
	
	public boolean isOverdue(Date now) 
	{
		if (!isCheckedOut()) 
		{
			return false;
		}
		return now.after(dueDate);
	}
	
	public void checkOut(Patron p, Date now) 
	{
		if (!isCheckedOut()) 
		{
			
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_YEAR, checkOutDays);

			// always set to 11:59:59 pm on the day it's due
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);

			// convert back to Date object
			dueDate = cal.getTime();

			checkedOutTo = p;
		}
	}

	public double getFine(Date now) 
	{
		return 0;
	}
}