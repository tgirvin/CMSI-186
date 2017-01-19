public class LongYear {
	public static void main (String [] args){
		long year = Long.parseLong(args[0]);
		System.out.println(isLeapYear(year));
	}
	public static boolean isLeapYear (long year) {
		if (( year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) { //%=remainder
			return true;
		} else {
			return false; 
		}
	}	
}

//Timmy-MacBook-Pro:desktop MacBookPro$ java LongYear 1942
//false
//Timmy-MacBook-Pro:desktop MacBookPro$ java LongYear 2020
//true


