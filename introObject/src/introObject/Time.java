package introObject;

public class Time
{
	private Clock clock;
	private Date date;
	
	/**
	 * this is the first constructor, it is restarting a new time.  
	 * @param year. what the function restart to the years number.
	 * @param month. what the function restart to the months number.
	 * @param day. what the function restart to the days number.
	 * @param hours. what the function restart to the hours number.
	 * @param minutes. what the function restart to the minutes number.
	 */
	public Time(int year, int month, int day, int hours, int minutes)
	{
		this.date = new Date(year, month, day);
		this.clock = new Clock(hours, minutes);
	}
	/**
	 * this constructor builds a new clock starting from a chosen date at midnight.
	 * @param year. the year of the chosen date.
	 * @param month. the month of the chosen date.
	 * @param day. the day of the chosen date.
	 */
	public Time(int year, int month, int day)
	{
		this.date = new Date(year, month, day);
		this.clock = new Clock();
	}
	/**
	 * this constructor builds a new time by two other objects.
	 * @param date. an object from type Date that contains a new date for the constructor.
	 * @param clock. an object from type Clock that contains a new clock for the constructor.
	 */
	public Time(Date date, Clock clock)
	{
		this.date = new Date(date.getYear(), date.getMonth(), date.getDay());
		this.clock = new Clock(clock.getHours(), clock.getMinutes());
	}
	/**
	 * this function gives an access to the property date.
	 * @return. it returns the value of property date.
	 */
	public Date getDate()
	{
		return this.date;
	}
	/**
	 * this function gives an access to the property clock.
	 * @return. the function returns the value of property clock.
	 */
	public Clock getClock()
	{
		return this.clock;
	}
	/**
	 * this function sets the property date by a property that contains the value will be set in the property.
	 * @param date. contains the value will be set in the property.
	 */
	public void setDate(Date date)
	{
		this.date = new Date(date.getYear(), date.getMonth(), date.getDay());
	}
	/**
	 * this function sets the property clock by a property that contains the value will be set in the property.
	 * @param clock. contains the value will be set in the property.
	 */
	public void setClock(Clock clock)
	{
		this.clock = new Clock(clock.getHours(), clock.getMinutes());
	}
	/**
	 * this function calculate the difference between two time objects (the calling one and another one it gets).
	 * @param t. this is the another time object the function gets.
	 * @return. the function returns the difference between the two time objects in minutes.
	 */
	public int diff(Time t)
	{
		int numOfDays = 0;
		if(this.date.getYear() >= t.date.getYear())
		{
			int temp1 = this.date.getYear() - t.date.getYear();
			numOfDays += Date.convertYearToDay(temp1);
		}
		else
		{
			int temp2 = this.date.getYear() - t.date.getYear();
			temp2 *= -1;
			numOfDays += Date.convertYearToDay(temp2);
		}
		if(this.date.getMonth() >= t.date.getMonth())
		{
			for(int i = t.date.getMonth() + 1 ; i < this.date.getMonth() && i >= t.date.getMonth() ; i++)
			{
				numOfDays += Date.daysNum(i, this.date.getYear());//there was not mentioned which year I suppose to insert because the function that helps to find the days in a month need a year parameter.
												//so I decided to insert the year of the first date. It doesn't suppose to disturb it is only for February.
			}
		}
		else
		{
			for(int j = this.date.getMonth() + 1 ; j > this.date.getMonth() && j <= t.date.getMonth() ; j++)
			{
				numOfDays += Date.daysNum(j, this.date.getYear());//there was not mentioned which year I suppose to insert because the function that helps to find the days in a month need a year parameter.
												//so I decided to insert the year of the first date. It doesn't suppose to disturb it is only for February.
			}
		}
		if(this.date.getDay() >= t.date.getDay())
		{
			numOfDays += this.date.getDay() - t.date.getDay();
		}
		else
		{
			int temp3 = this.date.getDay() - t.date.getDay();
			temp3 *= -1;
			numOfDays += temp3;
		}
		if(numOfDays < 0)
		{
			numOfDays *= -1;
		}
		numOfDays = convertDaysToMinutes(numOfDays);
		//----------
		int diff = 0;
		if(t.clock.getHours() > this.clock.getHours())
		{
			diff += (t.clock.getHours() - this.clock.getHours()) * 60;
			diff += t.clock.getMinutes() - this.clock.getMinutes();
		}
		else if(t.clock.getHours() < this.clock.getHours())
		{
			diff += (this.clock.getHours() - t.clock.getHours()) * 60;
			diff += this.clock.getMinutes() - t.clock.getMinutes();
		}
		else
		{
			diff = 0;
		}
		diff += numOfDays;
		return diff;
	}
	public String toString()
	{
		if(this.clock.getMinutes() < 10)
		{
			if(this.clock.getHours() < 10)
			{
				return "Date: " + this.date.getDay() + "/" + this.date.getMonth() + "/" + this.date.getYear() + " Time: " + "0" + this.clock.getHours() + ":" + "0" + this.clock.getMinutes();
			}
			else
			{
				return "Date: " + this.date.getDay() + "/" + this.date.getMonth() + "/" + this.date.getYear() + " Time: " + this.clock.getHours() + ":" + "0" + this.clock.getMinutes();
			}
		}
		else if(this.clock.getHours() < 10)
		{
			return "Date: " + this.date.getDay() + "/" + this.date.getMonth() + "/" + this.date.getYear() + " Time: " + "0" + this.clock.getHours() + ":" + this.clock.getMinutes();
		}
		return "Date: " + this.date.getDay() + "/" + this.date.getMonth() + "/" + this.date.getYear() + " Time: " + this.clock.getHours() + ":" + this.clock.getMinutes();
	}
	/**
	 * this is an Auxiliary function that converts a number of days to minutes.
	 * @param day. this is the number of days.
	 * @return. the function returns the number of minutes in the days.
	 */
	public static int convertDaysToMinutes(int day)
	{
		int numOfMin = 0;
		numOfMin += day * 24; //24 hours in a day
		numOfMin *= 60; //60 minutes in an hour
		return numOfMin;
	}

}
