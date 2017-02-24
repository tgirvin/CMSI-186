//Timothy Girvin 
//CMSI186
//DiceSet.java



/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Timothy Girvin 
 *  Date          :  2017-02-23
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public void setIndividual( int i, int jValue );  // Sets the ith die in this set to the value of jValue
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      this.count = count;
      this.sides = sides;

      if (count <= 0) {
        throw new IllegalArgumentException("Does not exist!");
      }
      ds = new Die[ count ]; //making space for # of dice 
      for (int i = 0; i < ds.length; i++) {
        ds[i] = new Die(sides);
      }

   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
      int result = 0;
      for (int i = 0; i < ds.length; i++) {
        result += ds[i].getValue();
      }
      return result;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     int value = 0;
     for (int i = 0; i < ds.length; i++) {
       // value = (int) (Math.random() * this.sides + 1);
       ds[i].roll();
     }
     System.out.println(toString());
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      for (int i = 0; i < ds.length; i++) {
        result += ds[i].toString();
      }
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
      return this.toString().equals(ds.toString());
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      // You do this part!
      DiceSet ds1 = new DiceSet(5,6);
      DiceSet ds2 = new DiceSet(5,6);
      DiceSet ds3 = new DiceSet(4,7);
      System.out.println("ds1: " + ds1);
      System.out.println("ds2 " + ds2);
      System.out.println("ds3: " + ds3 + "\n");

      System.out.println("Roll ds1");
      ds1.roll();
      System.out.println("Roll ds2");
      ds2.roll();
      System.out.println("Roll ds3");
      ds3.roll();
      System.out.println();

      ds1.rollIndividual(0);
      System.out.println("ds1: " + ds1);
      System.out.println("ds2 " + ds2);
      System.out.println("ds3: " + ds3 + "\n");

      System.out.println(ds1.getIndividual(0));
      System.out.println(toString(ds1));
      System.out.println(toString(ds2));
      System.out.println(toString(ds3));
      System.out.println();

      System.out.println(ds1.isIdentical(ds1));
      System.out.println(ds1.isIdentical(ds2));
      System.out.println(ds2.isIdentical(ds3));
   }
}
