import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class newLogin extends UsefulFuncs {
	
	static String newpass;
	static String LOS;
	//LOS stands for level of security
	
	
	public newLogin() {
		//Calls check method
		passexist();
	}
	
	//This method checks to see whether Master.txt is a file in any of the possible locations
	//This indicate whether the user is new or not
	public static void passexist() {
		if(isFile("Master.txt")) {
			return;
		}
		File f = new File("C:\\ApplebyTemp\\Master.txt");

		if(f.exists() && !f.isDirectory()) {
			return;
		}
		else {
			welcome(); 
		}
	}
	
	public static void welcome() {
		
		print("Welcome to Matt's Password manager.\n This Application allows you to save and manage passwords for your various accounts. \n\n "
				+ "Lets begin by creating a master password to your account");

		sleep(2000);
		newpass = input("\n\nEnter a password: ");
		
		
		print("You can choose 3 different levels to protect your password\n"
				+ "1. Basic saving, simply put into a word file with minimal security\n"
				+ "2. The password is encrypted in a random cypher and put into a word file\n"
				+ "3. The password is double encrypted and the word file is hidden within the computer");
		LOS = input("\nChoose your level of security(1,2, or 3): ");
		encryptpass();
	}
	public static void encryptpass()  {
		
		if((Integer.parseInt(LOS)) == 1) {
			newpass = low(newpass);
		}
		if((Integer.parseInt(LOS)) == 2) {
			newpass = mid(newpass);
		}
		if((Integer.parseInt(LOS)) == 3) {
			newpass = high(newpass);
		}
			savePass();
	
		
	}
	public static void savePass() {
		if(Integer.parseInt(LOS)== 1||Integer.parseInt(LOS)== 2 ) {
			PrintWriter writer;
			try {
				writer = new PrintWriter("Master.txt","UTF-8");
				writer.println(newpass);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			//File f = new File("C:\\","Master.txt");
			PrintWriter writer;
	
			
			try {
				writer = new PrintWriter("C:\\ApplebyTemp\\Master.txt","UTF-8");
				writer.println(newpass);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		
			}
	}

}
