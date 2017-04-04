import java.text.DecimalFormat;
class Timer {
	private double slice;
	private double hours;
	private double minutes;
	private double seconds;
	private double angle; 
	//attributes = hrs minutes seconds is not the optimal solution 
	public Timer(double slice){
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
