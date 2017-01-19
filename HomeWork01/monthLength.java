public class monthLength {

	public static void main (String [] args) {
		long month = Long.parseLong(args[0]);//args = argument 
		long year = Long.parseLong(args[1]);
		System.out.println(daysInMonth(month,year));
	}

	public static long daysInMonth (long month, long year) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}

		if (month == 2 && ( year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return 29;
		} else {
			return 28; 
		}
	}		
}
