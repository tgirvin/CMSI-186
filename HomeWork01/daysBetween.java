//Timothy Girvin 
//CMSI186
//daysBetween

/*
Make method public static long daysBetween( long month0, long day0, long year0, long month1, long day1, long year1 ), 
which returns the absolute number of days between the two given dates. For example, daysBetween( 3, 1, 2000, 3, 1, 1999) 
should return 366, and daysBetween( 3, 2, 1999, 5, 1, 2001) should return 791.
*/

public class daysBetween {
	public static void main (String [] args) {
		long month0 = Long.parseLong(args[0]);
		long day0 = Long.parseLong(args[1]);
		long year0 = Long.parseLong(args[2]);
		long month1 = Long.parseLong(args[3]);
		long day1 = Long.parseLong(args[4]);
		long year1 = Long.parseLong(args[5]);
		System.out.println(daysBetween(month0, day0, year0, month1, day1, year1));


	public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      long daysCounter = 0;
   
      while ( day1 > 1) {
         day1-=1;
         daysCounter-=1;
      }

      while( year1 < year2 ) {
         if (( year2 % 4 == 0) && (year2 % 100 != 0) || (year2 % 400 == 0)) {
            daysCounter += 366;
         } else {
            daysCounter += 365; 
         }


         year1 += 1;
      }

      while ( month1 < month2 ) {
         if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
            daysCounter += 31;
         } else if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
            daysCounter += 30;
         }
         month1 += 1;
      }

      while ( month1 > month2 ) {
         if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
            daysCounter -= 31;
         } else if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
            daysCounter -= 30;
         } else if ((month1 == 2) && (month1 == 2 && ( year1 % 4 == 0) && (year1 % 100 != 0) || (year1 % 400 == 0))) {
            daysCounter -= 29; 
         } else if ((month1 == 2)) {
            daysCounter -= 28;
         }
         month1 -= 1;
      }

      while ( day1 < day2) {
         day1+=1;
         daysCounter+=1;
      }

      return daysCounter;
   }

}