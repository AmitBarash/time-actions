package introObject;

public class Clock
{
	final int TWENTY_THREE_HOURS = 23;
	final int TWENTY_FOUR_HOURS = 24;
	final int FIFTY_NINE_MINUTES = 59;
	final int SIXTY_MINUTES = 60;
	final int ZERO = 0;
	final int ONE = 1;
	final int TEN_MINUTES = 10;
	private int hours;
	private int minutes;
	private int serialNum;
	private static int clocksNum = 0;
	/**
	 * this function builds a new clock and restart it to 0:0.
	 */
	public Clock()
	{
		this.hours = ZERO;
		this.minutes = ZERO;
		clocksNum++;
		this.serialNum = clocksNum;
	}
	/**
	 * this function builds a new clock and restart is to the time the user wants.
	 * @param hours. this is the hours that the clock set on to.
	 * @param minutes. this is the minutes that the clock set on.
	 */
	public 	Clock(int hours, int minutes)
	{
		while(hours > TWENTY_THREE_HOURS)
		{
			hours -= TWENTY_FOUR_HOURS;
		}
		while(minutes > FIFTY_NINE_MINUTES)
		{
			minutes -= SIXTY_MINUTES;
		}
		if(hours < ZERO)
		{
			hours = ZERO;
		}
		if(minutes < ZERO)
		{
			minutes = ZERO;
		}
		this.hours = hours;
		this.minutes = minutes;
		clocksNum++;
		this.serialNum = clocksNum;
	}
	public Clock(Clock clock)
	{
		this.serialNum = clock.getSerialNum();
		this.hours = clock.getHours();
		this.minutes = clock.getMinutes();
	}
	/**
	 * the function returns the serial number of this clock.
	 * @return. the function returns the serial number of the calling clock.
	 */
	public int getSerialNum()
	{
		return this.serialNum;
	}
	/**
	 * the function returns the hours of the calling clock.
	 * @return. the function returns the hours number of the calling clock.
	 */
	public int getHours()
	{
		return this.hours;
	}
	/**
	 * the function returns the minutes of the calling clock.
	 * @return. the function returns the minutes number of the calling clock.
	 */
	public int getMinutes()
	{
		return this.minutes;
	}
	/**
	 * the function is setting an hours number of the calling clock according to number that the user wants.
	 * @param hours. the hours number that the clock set to.
	 */
	public void setHours(int hours)
	{
		if(hours < ZERO)
		{
			System.out.println("invaild input. the input is now zero");
			this.hours = ZERO;
		}
		else if(hours > TWENTY_THREE_HOURS)
		{
			while(hours > TWENTY_THREE_HOURS)
			{
				hours -= TWENTY_FOUR_HOURS;
			}
			this.hours = hours;
		}
		else
		{
			this.hours = hours;
		}
	}
	/**
	 * the function is setting an minutes number of the calling clock according to number that the user wants.
	 * @param minutes. the minutes number that the clock set to.
	 */
	public void setMinutes(int minutes)
	{
		if(minutes < ZERO)
		{
			System.out.println("invaild input. the input now is zero");
			this.minutes = ZERO;
		}
		else if(minutes > FIFTY_NINE_MINUTES)
		{
			while(minutes > FIFTY_NINE_MINUTES)
			{
				minutes -= SIXTY_MINUTES;
			}
			this.minutes = minutes;
		}
		else
		{
			this.minutes = minutes;
		}
	}
	/**
	 * the function adding a minute to the activating clock.
	 */
	public void tik()
	{
		if(this.getMinutes() == FIFTY_NINE_MINUTES)	//the if meant to check if the function makes the hours pass' and if so' the hours will pass and the minutes will restart.
		{
			this.setHours(this.getHours() + ONE);
			this.setMinutes(0);
		}
		else
		{
			this.setMinutes(this.getMinutes() + ONE);
		}
	}
	/**
	 * the function adding a number of minutes to a clock.
	 * @param minutesNum. this is the minutes number that the function adding.
	 */
	public void adj(int minutesNum)
	{
		int hoursNum = ZERO;
		this.minutes += minutesNum;
		if(this.minutes > FIFTY_NINE_MINUTES)
		{
			while(this.minutes > FIFTY_NINE_MINUTES)
			{
				this.minutes -= SIXTY_MINUTES;
				hoursNum++;
			}
			this.hours += hoursNum;
			while(this.hours > TWENTY_THREE_HOURS)
			{
				this.hours -= TWENTY_FOUR_HOURS;
			}
		}
		else if(this.minutes < ZERO)
		{
			hoursNum--;
			this.minutes += SIXTY_MINUTES;
			this.hours += hoursNum;
			if(this.hours < ZERO)
			{
				this.hours += TWENTY_FOUR_HOURS;
			}
		}

	}
	/**
	 * the function checks the difference in minutes between two clocks.
	 * @param clock3 the function gets one clock and activated by the other one. this is the clock that the function gets.
	 * @return the function returns the difference in minutes between the two clocks.
	 */
	public int diff(Clock clock3)
	{
		int diff = ZERO;
		if(clock3.getHours() > this.getHours())
		{
			diff += (clock3.getHours() - this.getHours()) * SIXTY_MINUTES;
			diff += clock3.getMinutes() - this.getMinutes();
		}
		else if(clock3.getHours() < this.getHours())
		{
			diff += (this.getHours() - clock3.getHours()) * SIXTY_MINUTES;
			diff += this.getMinutes() - clock3.getMinutes();
		}
		else
		{
			diff = ZERO;
		}
		return diff;
	}
	/**
	 * his function returns the time of the calling clock.
	 */
	public String toString()
	{
		if(this.minutes < TEN_MINUTES)
		{
			if(this.hours < TEN_MINUTES)
			{
				return "0" + this.getHours() + ":" + "0" + this.getMinutes();
			}
			else
			{
				return this.getHours() + ":" + "0" + this.getMinutes();
			}
		}
		else if(this.hours < TEN_MINUTES)
		{
			return "0" + this.getHours() + ":" + this.getMinutes();
		}
		return this.getHours() + ":" + this.getMinutes();
	}
	/**
	 * this function converts a number of hours to a number of minutes.
	 * @param min. the minutes number that the function convert.
	 * @return. the function returns the minutes number in hours.
	 */
	public static int convertMinToHours(int min)
	{
		int hoursNum = min / 60;	//here the 60 is not a constant because the function is static
		return hoursNum;
	}
	/**
	 * this function converts a number of minutes to a number of hours.
	 * @param hours. the hours number that the function convert.
	 * @return. the function returns the hours number in minutes.
	 */
	public static int convertHoursToMin(int hours)
	{
		int minutesNum = hours * 60;	//here the 60 is not a constant because the function is static
		return minutesNum;
	}
}