package introObject;

public class Date
{
	private int day;
	private int month;
	private int year;
	/**
	 * the constructor builds a new date that contains a day' month and a year.
	 * @param day. this is the day that the function restarts to the new date.
	 * @param month. this is the month that the function restarts to the new date.
	 * @param year. this is the year that the function restarts to the new date.
	 */
	public Date(int year, int month, int day)
	{
		if(day <= 0) //in the API there was not mentioned what to do if the input in the constructor is invalid so I restarted it to minimum or maximum value.
		{
			System.out.println("invalid input at the day area, changed to 1");
			day = 1;
		}
		if(month <= 0)
		{
			System.out.println("invalid input at the month area, changed to 1");
			month = 1;
		}
		else if(month >= 13)
		{
			System.out.println("invalid input at the month area, changed to 12");
			month = 12;
		}
		if(year <= 0)
		{
			System.out.println("invalid input at the year area, changed to 1");
			year = 1;
		}
		if(day > daysNum(month, year))
		{
			System.out.println("invalid input at the day area, changed to " + daysNum(month, year));
			day = daysNum(month, year);
		}
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	/**
	 * this function is checking if the year is a leap year.
	 * @param year. this is the year that the function check if it is leap.
	 * @return. the function returns true if it is a leap year and false if it is not a leap year.
	 */
	public static boolean isLeapYear(int year)
	{
		if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * the function gives an access to the property by returning it.
	 * @return. the function returns the value of the property year.
	 */
	public int getYear()
	{
		return this.year;
	}
	/**
	 * the function gives an access to the property by returning it.
	 * @return. the function returns the value of the property month.
	 */
	public int getMonth()
	{
		return this.month;
	}
	/**
	 * the function gives an access to the property by returning it.
	 * @return. the function returns the value of the property day.
	 */
	public int getDay()
	{
		return this.day;
	}
	/**
	 * the function sets a year to the year parameter.
	 * @param year. this is what the function sets into the year parameter.
	 */
	public void setYear(int year)
	{
		if(year > 0 && year < 13)
		{
			this.year = year;
		}
	}
	/**
	 * the function sets a month to the year parameter.
	 * @param month. this is what the function sets into the month parameter.
	 */
	public void setMonth(int month)
	{
		if(month > 0 && month < 13 && daysNum(month, this.year) >= this.day)
		{
			this.month = month;
		}
	}
	public void setDay(int day)
	{
		if(day > 0 && day < daysNum(this.month, this.year))
		{
			this.day = day;
		}
	}
	/**
	 * the function calculates the days from the calling date to the 01.01.01.
	 * this function uses another Auxiliary functions to convert years and months to days.
	 * @return. the function returns a number of days that are the difference from the date to the beginning.
	 */
	public int daysFromStart()
	{
		int numOfLeaps = numOfLeap(this.year);
		int numOfDays = convertYearToDay(this.year);
		numOfDays += numOfLeaps;
		int monthInDays = convertMonthToDay(this.month, this.year);
		numOfDays += monthInDays;
		numOfDays += this.getDay();
		return numOfDays;
	}
	/**
	 * the function calculates the days from the calling date to the date d.
	 * the function uses another Auxiliary functions to convert years and months to days.
	 * @param d. this is the second date that the function checks the difference between them.
	 * @return. the function returns the number of days between the two dates.
	 */
	public int diff(Date d)
	{
		int numOfDays = 0;
		if(this.year >= d.getYear())
		{
			int temp1 = this.year - d.getYear();
			numOfDays += convertYearToDay(temp1);
		}
		else
		{
			int temp2 = this.year - d.getYear();
			temp2 *= -1;
			numOfDays += convertYearToDay(temp2);
		}
		if(this.month >= d.getMonth())
		{
			for(int i = d.getMonth() + 1 ; i < this.month && i >= d.getMonth() ; i++)
			{
				numOfDays += daysNum(i, this.year);//there was not mentioned which year I suppose to insert because the function that helps to find the days in a month need a year parameter.
												//so I decided to insert the year of the first date. It doesn't suppose to disturb it is only for February.
			}
		}
		else
		{
			for(int j = this.month + 1 ; j > this.month && j <= d.getMonth() ; j++)
			{
				numOfDays += daysNum(j, this.year);//there was not mentioned which year I suppose to insert because the function that helps to find the days in a month need a year parameter.
												//so I decided to insert the year of the first date. It doesn't suppose to disturb it is only for February.
			}
		}
		if(this.day >= d.getDay())
		{
			numOfDays += this.day - d.getDay();
		}
		else
		{
			int temp3 = this.day - d.getDay();
			temp3 *= -1;
			numOfDays += temp3;
		}
		if(numOfDays < 0)
		{
			numOfDays *= -1;
		}
		return numOfDays;
	}
	/**
	 * the function returns the date that called it.
	 */
	public String toString()
	{
		return this.day + "/" + this.month + "/" + this.year;
	}
	/**
	 * this function is an auxiliary function that calculates how many days are there in a number of years.
	 * this function is using another Auxiliary function named "numOfLeaps" to check how many another days are added to the year (because of the leap years).
	 * @param year. this is the number of years that the function converts to days.
	 * @return. the function returns the number of days in the number of years.
	 */
	public static int convertYearToDay(int year)
	{
		int numOfDays = year * 365;
		numOfDays += numOfLeap(year);
		return numOfDays;
	}
	/**
	 * this function is an Auxiliary function that converts a number of months from the beginning of the year to the selected month to days. 
	 * this function uses another Auxiliary function named "daysNum" to check how many days are in which month.
	 * @param month. this is the number of months that the function converts to days.
	 * @param year. this parameter is to help the Auxiliary functions to calculate if it is a leap year or not because it affects on the number of the days.
	 * @return. the function returns the number of days in those months.
	 */
	public static int convertMonthToDay(int month , int year)
	{
		int numOfDays = 0;
		for(int i = 1 ; i <= month ; i++)
		{
			numOfDays += daysNum(i, year);
		}
		return numOfDays;
	}
	/**
	 * the function is an Auxiliary function that checks how many leap years were from the beginning of the calendar until the selected year.
	 * @param year. this is the year that the function checks how many leap years were until it.
	 * @return. the function returns the number of the leap years until the selected year.
	 */
	public static int numOfLeap(int year)
	{
		int numOfLeap = 0;
		for(int i = 1 ; i <= year ; i++)
		{
			if(isLeapYear(i))
			{
				numOfLeap++;
			}
		}
		return numOfLeap;
	}
	/**
	 * this function is an Auxiliary function that matches a number of a month and return how many days are there in this month.
	 * @param month. this is the month number that the function checks.
	 * @param year. it meant to be an Auxiliary variable to check if it is a leap year because it affects on how many days are in any month.
	 * @return. the function returns the number of the days in the selected month.
	 */
	public static int daysNum(int month, int year)
	{
		int daysNum = 0;
		if(month == 1)
		{
			daysNum = 31;
		}
		else if(month == 2)
		{
			if(isLeapYear(year))
			{
				daysNum = 29;
			}
			else
			{
				daysNum = 28;
			}
		}
		else if(month == 3)
		{
			daysNum = 31;
		}
		else if(month == 4)
		{
			daysNum = 30;
		}
		else if(month == 5)
		{
			daysNum = 31;
		}
		else if(month == 6)
		{
			daysNum = 30;
		}
		else if(month == 7)
		{
			daysNum = 31;
		}
		else if(month == 8)
		{
			daysNum = 31;
		}
		else if(month == 9)
		{
			daysNum = 30;
		}
		else if(month == 10)
		{
			daysNum = 31;
		}
		else if(month == 11)
		{
			daysNum = 30;
		}
		else if(month == 12)
		{
			daysNum = 31;
		}
		return daysNum;
	}
}
