//Import Statements, mainly for writing in text files
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Originally Login was going to extend to newLogin, for efficiency's sake, this was altered
public class Login extends newLogin {

	//Variable definitions
	private static String pass;
	public static String LOS;
	//LOS stands for level of security
	public static String check;
	
	//Constructor, simply calls for the password enter method
	public Login() {	
		print("Welcome back to Matt's Password manager!");
		//Calls password enter method
		passenter();
	}
	
	//Takes the users password and Level of Security
	public static void passenter() {
		
		//Input Statements (Input() is taken from usefulfuncs)
		pass = input("Please Enter your password to enter your manager: ");
		LOS = input("Please enter the level of security you have been using: ");
		
		//This checks to make sure the user entered a valid number
		if(numberOnly(LOS)==false) {
			/**
			 * Thread.sleep must either include a catch/try or include a throws decleration.
			 * Personally I prefer the throws decleration over the catch/try because of the amount of 
			 * useless code that catch/try creates. However, the throws decleration is bothersome because
			 * it is required in any method that calls the method with throws.
			 * I switched back an forwards in this project just to see which I preffered more. 
			*/
			sleep(2000);
			//brings the user back to password enter
			passenter();
		}
		
		//If LOS was a number it checks to make sure it is 1 2 or 3
		if(Integer.parseInt(LOS) != 1 && Integer.parseInt(LOS) != 2 && Integer.parseInt(LOS) != 3) {
			//If not, sends the user back to the beginning of password enter
			print("You did not enter a valid number. \n Please try again.");	
				sleep(2000);
				passenter();

		}
		
		
		
		//Calls the method that gets the password
		getcheckPass();
	}

	
 public static void getcheckPass() {
	
	 //Depending on the Level of Security the master password will be in a different location on the computer.
	 // That is why these conditional statements are required.
	 if(Integer.parseInt(LOS) == 1 ||Integer.parseInt(LOS) == 2 ) {
		 //Buffered Reader is used to read from text files.
		 //Throughout this project I epxerimented with different methods of reading and writing text to see which one I preferred the most
		 BufferedReader br;
		//When working with file altering it seems that try and catch clauses are typically required
		 try {
			//Tells the reader where to look and what file to look for
			 br = new BufferedReader(new FileReader(System.getProperty("user.dir")+ File.separator + ("Master.txt")));
			 //text variable to store what is read
			 String text;
			//reads password passes it to check variable
			 text = br .readLine();
			check = text;
		
			
			//Again, useless catch clauses	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	 }
	//This is what occurs if a user chooses the 3 level of security option
	 // This is all essentially a copy and paste, however, the buffered reader must look in a different
	 // Location on the computer.
	 else {
		 BufferedReader br;
			try {
				//
				br = new BufferedReader(new FileReader("C:\\ApplebyTemp\\Master.txt"));
				 String text;
				text = br.readLine();
				check = text;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 //After all is done, the check password is called
	 checkpass();
 }
 //
public static void checkpass(){
	if(Integer.parseInt(LOS) == 1) {
		if(pass.equals(low(check))) {
			print("Check is good");
			return;
		}
		else {
			print("The password does not match.\n Please try again.");
			passenter();
		}
	}
	if(Integer.parseInt(LOS)==2) {
		if(pass.toLowerCase().equals(decryptMid(check))) {
			print("Check is good");
			return;
		}
		
		else {
			print("The password does not match.\n Please try again.");
			passenter();
		}
	}
	
	if(Integer.parseInt(LOS)==3) {
		if(pass.toLowerCase().equals(low(decryptMid(check)))) {
			print("Check is good");
			return;
		}
		else {
			print("The password does not match.\n Please try again.");
			passenter();
			}
		}
	}
//This method is used to pass the LOS variable to the Menu class. Instead of asking the user to re-enter the LOS.
public static String getLOS() {
	return LOS;
}


}


