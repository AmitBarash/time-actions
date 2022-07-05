package introObject;

public class GlobalClock
{
	private Clock clock;
	private int UTC;
	
	public GlobalClock(int UTC , Clock clock)
	{
		this.UTC = UTC;
		this.clock = new Clock(clock.getHours() , clock.getMinutes());
	}
	public GlobalClock(GlobalClock clock)
	{
		this.UTC = clock.UTC;
		this.clock = new Clock(clock.clock.getHours() , clock.clock.getMinutes());
	}
	public void setClock(Clock clock)
	{
		this.clock = new Clock(clock.getHours() , clock.getMinutes());
	}
	public String toString()
	{
		return "the UTC is: " + this.UTC + " the time is: " + this.clock;
	}
}
