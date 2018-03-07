// Imports
import java.io.File;
import java.util.Scanner;

// This class if full of functions that I regularly use throughout the project, 
// Some methods are simply used alot and some are used just to simplify
public class UsefulFuncs {

	//I print to the console so often, it saves a lot of typing just making it into a print() method
	public static void print(String a) {
		System.out.println(a);
	}
	//Used when printing file names to the console
	public static void print(File a) {
		System.out.println(a);
	}
	public static String input(String a) {
		
		Scanner reader = new Scanner(System.in);
		print(a);
		String n = reader.next();
		
		return n;
	}
//This method is used to check whether Master.txt exits	
	public static boolean isFile(String a) {
		
		File f = new File(System.getProperty("user.dir")+ File.separator + (a));
		
		
		boolean exists = f.exists();
		
		return exists;
		}

	
	//This function can be used to encrypt and decrypt as it is simply just reversing the string
	public static String low(String a ) {
		//Reverse the String for minimal security
		//splits String into chars
		char[] in = a.toCharArray();
	    int begin=0;
	    int end=in.length-1;
	    char temp;
	    while(end>begin){
	        temp = in[begin];
	        in[begin]=in[end];
	        in[end] = temp;
	        end--;
	        begin++;
	    }
	    //Takes the chars and puts them into a string
	    return new String(in);
		
	}
	//This method is used for middle level encryption
	//This method switches out letters for a different symbol making the string look completely random
	// A different method is required to decrypt the string
	public static String mid(String a ) {
		//Variables
		String str = a;
		String Newstr = "";
		
		//makes string lowercase
		for(int i=0;i<str.length();i++) {
		char ch=Character.toLowerCase(str.charAt(i));
		
		//Switch and case are used like conditional statements
		//Ex if str(i) == a, NewStr = Newstr + {
		switch(ch) {
		case 'a':  
            Newstr=Newstr+"{";  
            break;  
        case 'b':  
            Newstr=Newstr+"}";  
            break;  
        case 'c':  
            Newstr=Newstr+"#";  
            break;  
        case 'd':  
            Newstr=Newstr+"~";  
            break;  
        case 'e':  
            Newstr=Newstr+"+";  
            break;  
        case 'f':  
            Newstr=Newstr+"-";  
            break;  
        case 'g':  
            Newstr=Newstr+"*";  
            break;  
        case 'h':  
            Newstr=Newstr+"@";  
            break;  
        case 'i':  
            Newstr=Newstr+"/";  
            break;  
        case 'j':  
            Newstr=Newstr+"\\";  
            break;  
        case 'k':  
            Newstr=Newstr+"?";  
            break;  
        case 'l':  
            Newstr=Newstr+"$";  
            break;  
        case 'm':  
            Newstr=Newstr+"!";  
            break;  
        case 'n':  
            Newstr=Newstr+"^";  
            break;  
        case 'o':  
            Newstr=Newstr+"(";  
            break;  
        case 'p':  
            Newstr=Newstr+")";  
            break;  
        case 'q':  
            Newstr=Newstr+"<";  
            break;  
        case 'r':  
            Newstr=Newstr+">";  
            break;  
        case 's' :  
            Newstr=Newstr+"=";  
            break;  
        case 't':  
            Newstr=Newstr+";";  
            break;  
        case 'u':  
            Newstr=Newstr+",";  
            break;  
        case 'v' :  
            Newstr=Newstr+"_";  
            break;  
        case 'w':  
            Newstr=Newstr+"[";  
            break;  
        case 'x' :  
            Newstr=Newstr+"]";  
            break;  
        case 'y':  
            Newstr=Newstr+":";  
            break;  
        case 'z' :  
            Newstr=Newstr+"\"";  
            break;  
        case ' ' :  
            Newstr=Newstr+" ";  
            break;  
        case '.':  
            Newstr=Newstr+'3';  
            break;  
        case ',':  
            Newstr=Newstr+"1";  
            break;  
        case '(':  
            Newstr=Newstr+'4';  
            break;  
        case '\"':  
            Newstr=Newstr+'5';  
            break;  
        case ')' :  
            Newstr=Newstr+"7";  
            break;  
        case '?' :  
            Newstr= Newstr+"2";  
            break;  
        case '!':  
            Newstr= Newstr+"8";  
            break;  
        case '-' :  
            Newstr= Newstr+"6";  
            break;  
        case '%' :  
            Newstr = Newstr+"9";  
            break;  
        case '1':  
            Newstr=Newstr+"r";  
            break;  
        case '2':  
            Newstr=Newstr+"k";  
            break;  
        case '3':  
            Newstr=Newstr+"b";  
            break;  
        case '4':  
            Newstr = Newstr+"e";  
            break;  
        case '5':  
            Newstr = Newstr+"q";  
            break;  
        case '6':  
            Newstr = Newstr+"h";  
            break;  
        case '7':  
            Newstr = Newstr+"u";  
            break;  
        case '8' :  
            Newstr= Newstr+"y";  
            break;  
        case '9':  
            Newstr = Newstr+"w";  
            break;  
        case '0':  
            Newstr = Newstr+"z";  
            break;  
         default:  
            Newstr=Newstr+"0";  
            break;  
    }  
		}  
		//Test case
	//System.out.println("The encrypted string is: \n" +Newstr);  
			
	return Newstr;	
	
}
	
	  public static String decryptMid(String a) {
	    {  
	        String str = a;
	        String Newstr = "";
	        
	        for (int i=0;i<str.length();i++)  
	        {  
	            char ch=str.charAt(i);  
	            switch (ch)  
	            {  
	                case '{':  
	                    Newstr=Newstr+"a";  
	                    break;  
	                case '}':  
	                    Newstr=Newstr+"b";  
	                    break;  
	                case '#':  
	                    Newstr=Newstr+"c";  
	                    break;  
	                case '~':  
	                    Newstr=Newstr+"d";  
	                    break;  
	                case '+':  
	                    Newstr=Newstr+"e";  
	                    break;  
	                case '-':  
	                    Newstr=Newstr+"f";  
	                    break;  
	                case '*':  
	                    Newstr=Newstr+"g";  
	                    break;  
	                case '@':  
	                    Newstr=Newstr+"h";  
	                    break;  
	                case '/':  
	                    Newstr=Newstr+"i";  
	                    break;  
	                case '\\':  
	                    Newstr=Newstr+"j";  
	                    break;  
	                case '?':  
	                    Newstr=Newstr+"k";  
	                    break;  
	                case '$':  
	                    Newstr=Newstr+"l";  
	                    break;  
	                case '!':  
	                    Newstr=Newstr+"m";  
	                    break;  
	                case '^':  
	                    Newstr=Newstr+"n";  
	                    break;  
	                case '(':  
	                    Newstr=Newstr+"o";  
	                    break;  
	                case ')':  
	                    Newstr=Newstr+"p";  
	                    break;  
	                case '<':  
	                    Newstr=Newstr+"q";  
	                    break;  
	                case '>':  
	                    Newstr=Newstr+"r";  
	                    break;  
	                case '=' :  
	                    Newstr=Newstr+"s";  
	                    break;  
	                case ';':  
	                    Newstr=Newstr+"t";  
	                    break;  
	                case ',':  
	                    Newstr=Newstr+"u";  
	                    break;  
	                case '_' :  
	                    Newstr=Newstr+"v";  
	                    break;  
	                case '[':  
	                    Newstr=Newstr+"w";  
	                    break;  
	                case ']' :  
	                    Newstr=Newstr+"x";  
	                    break;  
	                case ':':  
	                    Newstr=Newstr+"y";  
	                    break;  
	                case '\"' :  
	                    Newstr=Newstr+"z";  
	                    break;       
	                case 'r':  
	                    Newstr=Newstr+"1";  
	                    break;  
	                case 'k':  
	                    Newstr=Newstr+"2";  
	                    break;  
	                case 'b':  
	                    Newstr=Newstr+"3";  
	                    break;  
	                case 'e':  
	                    Newstr = Newstr+"4";  
	                    break;  
	                case 'q':  
	                    Newstr = Newstr+"5";  
	                    break;  
	                case 'h':  
	                    Newstr = Newstr+"6";  
	                    break;  
	                case 'u':  
	                    Newstr = Newstr+"7";  
	                    break;  
	                case 'y' :  
	                    Newstr= Newstr+"8";  
	                    break;  
	                case 'w':  
	                    Newstr = Newstr+"9";  
	                    break;  
	                case 'z':  
	                    Newstr = Newstr+"0";  
	                    break;  
	             
	            }  
	        }
	        return Newstr;
	    }     
	       
	    }  
	//High level encryption combines mid and low together. 
	public static String high(String a ) {
		String pass = a;
		//calls both methods to encrpyt them
		pass = (mid(low(pass)));
		return pass;
	}

	public static boolean numberOnly(String a) {
		try {
			Integer.parseInt(a);
		}
		catch(NumberFormatException e) {
			print("You did not enter a number. Please try again.");
			return false;
		}
		return true;
	}

	
	/**
	 * Thread.sleep must either include a catch/try or include a throws decleration.
	 * Personally I prefer the throws decleration over the catch/try because of the amount of 
	 * useless code that catch/try creates. However, the throws decleration is bothersome because
	 * it is required in any method that calls the method with throws.
	 * I switched back an forwards in this project just to see which I preffered more. 
	* 
	* It took me until later in the project where I figured out I could just make a function to call it without having to use the try/catch or throws
	* 
	*/
	public static void sleep(int a) {
		
		try {
			//Pauses the program for a set amount of time, in milliseconds
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}