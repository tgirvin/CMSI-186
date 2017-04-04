// a/sina = b/sinb = c/sinc
//stop once you get 1 collision 
//balls disappear once they go out of field
//speed= slows down due to friction 1 % of the current velocity 
//4.45 inch radius= less than or equal to 8.9 inches = overlap treated as a collision = stop everything
//where do u enter the field size = put it into the parameter 1250 
// by 824 make it a constant or field x value = 2024 feet or field y value = 1060 yards
//if too close throw an exception 
//velocity = velocity * 8.9 = friction 
//flagpole
//for (i=0; i<length-2; i++) {
   // for (j=i+1; j<length-1; j++) {
         //if(bRA[1==bRA[j]) {}
   //}
      //}
// left -x, right is positive x, up is positive y, down is negative -y,
//deltax deltay - movement 
//assigning it to a new ball object 


class Ball {

   //instance variables 
   private double weight;
   private double rx, ry; //position
   private double radius;
   private double speed;
   private double angle;
   private double fx, fy; //position of flagpole 

   public Ball(double rx, double ry, double speed, double angle) {
      this.radius = radius;
      this.weight = 1;
      this.fx = 100; //x cordinate flagpole position
      this.fy = 100; //y cordinate flagpole position
      this.rx = rx; //x position 
      this.ry = ry; //y position
      this.speed = speed;
      this.angle = angle; 

   }

   //public void moveBall (double timeslice) {


   //}

   public void setRadius(double radius) {
      this.radius = radius;
   }

   public double getRadius() {
      return radius; 
   }

   public double setPositionX() {
      this.rx = rx;
   }

   public double getPositionX(){
      return rx;
   }
   
   public double setPositionY(){
      this.ry = ry;
   }

   public double getPositionY(){
      return ry;
   }
   public double getSpeed() {
      return this.speed;
      //speed= slows down due to friction 1 % of the current velocity 
   }
   public boolean isBallMoving(){
      if (this.speed == 0) {
         return false;
      }
   }
   public boolean isBallColliding(Ball ball){
      double xd = (int)(rx.getPositionX() - ball.rx.getPositionX());
      double yd = ry.getPositionY() - ball.ry.getPositionY();

      double sumRadius = radius + ball.radius;
      double sqrRadius = sumRadius * sumRadius;

      double distSqr = (xd * xd) + (yd * yd);

      if (distSqr <= sqrRadius) {
         return true;
      }

      return false;
   }   
  
   public String toString (){
      return "Position: " + "<" + (int)(this.rx) + "," + (int)(this.ry) + ">";
   }

}