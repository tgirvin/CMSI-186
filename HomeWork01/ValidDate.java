public class ValidDate {
	public static void main (String [] args) {
		long month = Long.parseLong(args[0]);
		long day = Long.parseLong(args[1]);
		long year = Long.parseLong(args[2]);
		System.out.println(isValidDate(month, day, year)); //month + "/" + day + "/" + year
	}
	public static boolean isValidDate (long month, long day, long year){
		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day <= 31)) {
			return true;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11) && (day <= 30)) {
			return true;
		}
		if (month == 0 || month > 12) {
			return false; 
		}
		
		//leapyear 
		if (((month == 2) && ( year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) && (day == 29)){
			return true ;
		}else if ((month == 2) && (day <= 28)){
			return true;
		}else {
			return false; 
		}
		/*
		if (month == String || day == String || year == String)	{
			return false;
		}
		if  (true){
			System.out.println (month + "/" + day + "/" + year);
		}
		*/
	}
}