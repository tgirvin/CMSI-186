//Timothy Girvin
//CMSI 186
//Clock.java 



import java.text.DecimalFormat;

class ClockSolver {
	
	public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      }
      //Clock clock = new Clock();
   }


	public static void main (String [] args){
		double angle = 30;
		double slice = 60;
		double hours = 12;

		
		try {
			angle = Double.parseDouble(args[0]);
		} catch (Exception e){ //invalid 
			System.err.println(e);
		}

		try {
			slice = Double.parseDouble(args[1]);
			// System.out.println(c.getHours());
		} catch (Exception e){ //invalid 
			System.err.println(e);
		}
		Clock c = new Clock(slice);
		System.out.println("Angle: " + angle);
		System.out.println("Slice: " + slice);
		System.out.println("Current time:" + c);


		//Clock c = new Clock(slice);
		while (c.hours() < 12) {
			
			double angleSlice = 0.0;
			if (c.getHourAngle() > c.getMinutesAngle()) {
				angleSlice = (c.getHourAngle() - c.getMinutesAngle());
			}
			if (c.getHourAngle() < c.getMinutesAngle()) {
				angleSlice = (c.getHourAngle() - c.getMinutesAngle());
			}
			//DecimalFormat df = new DecimalFormat( "#0");
			//System.out.println("Angle Slice:" + df.format(angleSlice));
			



			if(((angleSlice - ((5.5/60*slice)/2)) < angle) && (angle < angleSlice + ((5.5/60*slice)/2))){
				System.out.println("Current time: " + c);
				DecimalFormat df = new DecimalFormat( "#0");
				System.out.println("Angle Slice:" + df.format(angleSlice));
			}

			c.tick();


			if ((c.hours() >= 12) && (c.minutes() >= 59)) {
				System.exit(1);
			}
			
			//System.out.println("Current time: " + c);
			//System.out.println("Minute angle: " + c.getMinutesAngle());
			//System.out.println("Hour angle: " + df.format(c.getHourAngle()));

		}
	}
}