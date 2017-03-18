//Timothy Girvin
//CMSI 186
//Clock.java 


//At what times during a 12-hour day will the hands of a clock form a straight angle 180 degrees
//angle: [0] in degrees > [55] > [110] > [165] 
//simulated notion of the time: 00:10:000 = hrs: mins: secs > 00:20:000 > 00:30:000
//timeSlice: [600] in seconds (10 minutes)^ . [1200] > [1800] every 5 minutes or every 1 minute 
//how much does it strink? everytime big hand goes all away aross the small hand is going an hour so 1/12th that speed
//time slice by default is 60 
//slice = 60; 
//if(args[0]){
	//slice = args[0];
//


import java.text.DecimalFormat;
class Clock {
	private double slice;
	private double hours;
	private double minutes;
	private double seconds;
	private double angle; 
	//attributes = hrs minutes seconds is not the optimal solution 
	public Clock(double slice){
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
		this.slice = slice;
		this.angle = angle;
	}
	public double hours(){
		return this.hours;
	}
	public double minutes(){
		return this.minutes;
	}
	public double seconds(){
		return this.seconds;
	}

	public void tick(){
		this.seconds += slice;
		this.minutes += slice / 60;
		this.hours += slice / 3600;

		if (this.hours>=13){
			// this.hours += this.minutes / 60;
			this.hours = 1;
		}
		if (this.minutes>=60){
			// this.hours += this.minutes / 60;
			this.minutes = this.minutes % 60;
		}
		if (this.seconds>=60){
			// this.minutes += this.seconds / 60;
			this.seconds = this.seconds % 60;
		}
	}
	public double getMinutesAngle(){
		return 6.0 * this.minutes; /// this.slice;
	}
	public double getHourAngle() {
		// return 360 * this.hours / this.slice / 12 ;
		return 30.0 * this.hours; /// this.slice;
	}
	//public double angle() {

	//}
	public String toString(){
		
		DecimalFormat df = new DecimalFormat( "#0.00");
		return (int)(this.hours) + ":" + (int)(this.minutes%60) + ":" + df.format((int)(this.seconds%60));
	}


}




