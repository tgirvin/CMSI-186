//Timothy Girvin
//CMSI 186
//SoccerSim.java 



//3 balls 
//Ball[] bRa = new Ball [3];
//bRA[0] = newBall(---);


class ClockSolver {



	public static void main (String [] args){

		
		//finds and identifies the collision 
		// exits once it finds collision 
		ballCount = 0;
	    for( double i = 0; i < ballCount; i++) {
	       for (double j = i+1; j < ballCount; j++) {
	          if (balls[i].colliding(balls[j])) {
	             System.out.println("They have collided!")
	             System.exit(1);
	            }
	        }    
		}   
	}
}

