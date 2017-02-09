public static String evensOnly( String s ){
	for (int i = 0; i < s.length(); i++) {
        String s = s.toLowerCase(i);
        switch(s.charAt(i)) {
	       	case 'b':
	        case 'd':
	        case 'f':
	        case 'h':
	        case 'j':
	        case 'l':
	        case 'n':
	        case 'p':
	        case 'r':
	        case 't':
	        case 'v':
	        case 'x':
	        case 'y':
               evens = 2;21
               System.out.println(evens);
            default:
               continue;
         }
   	}
}