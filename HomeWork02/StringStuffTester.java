//Timothy Girvin 
//CMSI186
//StringStuffTester



/**
   * Main method to test the methods in this class
   *
   * @param args String array containing command line parameters
   */
   

public class StringStuffTester {




   public static void main( String args[] ) {

      test_containsVowel();     
      test_isPalindrome();    
      test_evensOnly();    
      test_oddsOnly();      
      test_evensOnlyNoDupes();     
      test_oddsOnlyNoDupes();       
      test_reverse();        
   }
     
   static void test_containsVowel(){
      System.out.println("Contains Vowel:");
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String joe = new String( "JoEy" );
      String jw = new String( "JWBPCD" );
      System.out.println( StringStuff.containsVowel( blah ) );
      System.out.println( StringStuff.containsVowel( woof ) );
      System.out.println( StringStuff.containsVowel( joe ) );
      System.out.println( StringStuff.containsVowel( jw ) );
   }



   static void test_isPalindrome(){
      System.out.println("Is Palindrome:");     
      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      String pal6 = new String( "racecar" );
      System.out.println( StringStuff.isPalindrome( pal1 ) );
      System.out.println( StringStuff.isPalindrome( pal2 ) );
      System.out.println( StringStuff.isPalindrome( pal3 ) );
      System.out.println( StringStuff.isPalindrome( pal4 ) );
      System.out.println( StringStuff.isPalindrome( pal5 ) );
      System.out.println( StringStuff.isPalindrome( pal6 ) );
   }

   static void test_evensOnly(){
      System.out.println("Evens Only:");  
      try { System.out.println( StringStuff.evensOnly( "REHEARSALSZ" ).equals("rhrlz") ? "correct, rhrlz " : "false, " + StringStuff.evensOnly( "REHEARSALSZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.evensOnly( "REhearSALsz" ).equals("rhrlz") ? "correct, rhrlz " : "false, " + StringStuff.evensOnly( "REhearSALsz" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.evensOnly( "abcdefghijklmnopqrstuvWXYZ" ).equals("bdfhjlnprtvxz") ? "correct, bdfhjlnprtvxz " : "false, Answer is: " + StringStuff.evensOnly( "abcdefghijklmnopqrstuvWXYZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.evensOnly( "abcdefghijklmnopqrstuvWXYZ" ).equals("acegikmoqsuwy") ? "correct, acegikmoqsuwy " : "false, Answer is: " + StringStuff.evensOnly( "abcdefghijklmnopqrstuvWXYZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

   static void test_oddsOnly(){
      System.out.println("Odds Only:"); 
      try { System.out.println( StringStuff.oddsOnly( "xylophones" ).equals("yooes") ? "correct, yooes " : "false, " + StringStuff.oddsOnly( "xylophones" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.oddsOnly( "XYloPHonES" ).equals("yooes") ? "correct, yooes " : "false, " + StringStuff.oddsOnly( "XYloPHonES" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.oddsOnly( "abcdefghijklmnopqrstuvWXYZ" ).equals("bdfhjlnprtvxz") ? "correct, bdfhjlnprtvxz " : "false, Answer is: " + StringStuff.oddsOnly( "abcdefghijklmnopqrstuvWXYZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.oddsOnly( "abcdefghijklmnopqrstuvWXYZ" ).equals("acegikmoqsuwy") ? "correct, acegikmoqsuwy " : "false, Answer is: " + StringStuff.oddsOnly( "abcdefghijklmnopqrstuvWXYZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

   static void test_evensOnlyNoDupes(){
      System.out.println("Evens Only No Dupes:"); 
      try { System.out.println( StringStuff.evensOnlyNoDupes( "teepee" ).equals("tp") ? "correct, tp " : "false, Answer is: " + StringStuff.evensOnlyNoDupes( "teepee" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.evensOnlyNoDupes( "REHEARSALS" ).equals("rhl") ? "correct, rhl " : "false, Answer is: " + StringStuff.evensOnlyNoDupes( "REHEARSALS" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.evensOnlyNoDupes( "aaaccceee" ).equals("") ? "correct,  " : "false, Answer is: " + StringStuff.evensOnlyNoDupes( "aaaccceee" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.evensOnlyNoDupes( "zzztxxxxjj" ).equals("ztxj") ? "correct, ztxj " : "false, Answer is: " + StringStuff.evensOnlyNoDupes( "zzztxxxxjj" ) ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

   static void test_oddsOnlyNoDupes(){
      System.out.println("Odds Only No Dupes:");
      System.out.println( "oddsOnlyNoDupes()  returns: " + StringStuff.oddsOnlyNoDupes( "XYloPHonES" ) );
      try { System.out.println( StringStuff.oddsOnlyNoDupes( "XYloPHonES" ).equals("yoes") ? "correct, yoes " : "false, Answer is: " + StringStuff.oddsOnlyNoDupes( "XYloPHonES" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.oddsOnlyNoDupes( "aaaccceee" ).equals("ace") ? "correct, ace" : "false, Answer is: " + StringStuff.oddsOnlyNoDupes( "aaaccceee" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.oddsOnlyNoDupes( "zzztxxxxjj" ).equals("") ? "correct, " : "false, Answer is: " + StringStuff.oddsOnlyNoDupes( "zzztxxxxjj" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
   }

   static void test_reverse(){
      System.out.println("Reverse:");
      System.out.println( "reverse()          returns: " + StringStuff.reverse( "REHEARSALSZ" ) );
      try { System.out.println( StringStuff.reverse( "REHEARSALSZ" ).equals("ZSLASRAEHER") ? "correct, ZSLASRAEHER" : "false, Answer is: " + StringStuff.reverse( "REHEARSALSZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.reverse( "RacECar" ).equals("raCEcaR") ? "correct, raCEcaR" : "false, Answer is: " + StringStuff.reverse( "RacECar" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
      try { System.out.println( StringStuff.reverse( "566899" ).equals("998665") ? "correct, 998665" : "false, Answer is: " + StringStuff.reverse( "566899" ) ); }
      catch( Exception e ) { System.out.println ( false ); }
   }
}