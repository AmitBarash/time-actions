package introObject;

import java.time.LocalDateTime;

public class MainPro {

	public static void main(String[] args) {

//		final int MINUTES_PER_HOUR = 60;
//
//		System.out.println("**** Checking Class Clock ****");
//		
//		Clock c1 = new Clock();
//		c1.adj(65);
//		System.out.print("clock c1: ");
//		System.out.println(c1);
//		
//		Clock c2 = new Clock(12, 59);
//		c2.tik();
//		System.out.print("clock c2: ");
//		System.out.println(c2);
//		
//		int min = c1.diff(c2);
//		System.out.print("difference between clocks is ");
//		System.out.println(min + " minutes");
//		
//		int h = c2.getHours();
//		System.out.print("In " + h + " hours there are ");
//		System.out.println(Clock.convertHoursToMin(h) + " minutes");
//		
//		System.out.print(min + " minutes = ");
//		System.out.print(Clock.convertMinToHours(min));
//		System.out.println(" and " + min % MINUTES_PER_HOUR + " minutes");
//		
//		System.out.println("\n**** Checking Class Date ****");
//		
//		LocalDateTime ldt = LocalDateTime.now();
//		Date today = new Date(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth());
//		System.out.println("Today is " + today);
//		Date endOfSchoolYear_d = new Date(2021, 6, 20);
//		
//		System.out.print("There are " + today.diff(endOfSchoolYear_d));
//		System.out.println(" days till end of school year!");
//		
//		System.out.println("\n**** Checking Class Time ****");
//		Time now = new Time(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth(),
//				ldt.getHour(), ldt.getMinute());
//		Time endOfSchoolYearAtMidNight = new Time(2021, 6, 20);
//		
//		System.out.print("...which is " + now.diff(endOfSchoolYearAtMidNight));
//		System.out.println(" minutes from now!");
		
		
		
		Clock clock1 = new Clock(15 , 28);
		Clock clock4 = new Clock();
		GlobalClock clock2 = new GlobalClock(3 , clock1);
		System.out.println("clock1 = " + clock1);
		System.out.println("clock2 = " + clock2);
		GlobalClock clock3 = new GlobalClock(clock2);
		System.out.println("clock1 = " + clock1);
		System.out.println("clock2 = " + clock2);
		System.out.println("clock3 = " + clock3);
		clock3.setClock(clock4);
		System.out.println("clock1 = " + clock1);
		System.out.println("clock2 = " + clock2);
		System.out.println("clock3 = " + clock3);
		System.out.println("clock4 = " + clock4);
		Clock clock5 = new Clock(clock1);
		System.out.println("clock5 = " + clock5);
		System.out.println("clock1 = " + clock1);
		clock1.adj(20);
		System.out.println("clock5 = " + clock5);
		System.out.println("clock1: " + clock1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}