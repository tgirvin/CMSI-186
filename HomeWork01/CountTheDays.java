//Timothy Girvin 
//CMSI186
//CountTheDays 

//Make a complete program, CountTheDays, which outputs the absolute number of days between 
//two given dates. The dates will be specified via args[0] through args[5]. 
//[As before, the order of the two dates is irrelevant.] This program will certainly make use of most, 
//if not all, of the preceding methods.






public class CountTheDays {
	public static void main (String [] args) {
		long month0 = Long.parseLong(args[0]);
		long day0 = Long.parseLong(args[1]);
		long year0 = Long.parseLong(args[2]);
		long month1 = Long.parseLong(args[3]);
		long day1 = Long.parseLong(args[4]);
		long year1 = Long.parseLong(args[5]);
		System.out.println(CalendarStuff.daysBetween(month0, day0, year0, month1, day1, year1));

	}
}