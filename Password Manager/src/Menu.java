

//Various Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Menu extends UsefulFuncs {
	
	public static String LOS;
	public Menu() throws InterruptedException {
		//Takes the LOS assigned in login, this allows the program to know which level of security it should use
	
		LOS = Login.getLOS();
		
		
		//Calls option method, to list the options the user can choose from 
		options();
		
	
	}
	
public static void options() throws InterruptedException {
	
	/**
	 * 
	 * TODO: Add time delay
	 * TODO: prevent error when LOS is not correct
	 * 
	 */
	
	//Input
	String option = input("You have successsfully logged into your password manager. You can do 4 different things.\n"
			+ "1. Create a password to save (The same level of security used for your master password will be used)\n"
			+ "2. View your passwords to various accouts.\n"
			+ "3. Delete all passwords from your account.\n"
			+ "4. Close the program.\n"
			+ "Please enter a number: ");
	
	
	if(Integer.parseInt(option)==1) {
		//Create an account function
		create();
	}
	else if(Integer.parseInt(option)==2) {
		//List your accounts function
		list();
}
	
	else if(Integer.parseInt(option)==3) {
		//Deletes all passwords saved
		delete();
	}
	else if(Integer.parseInt(option)==4) {
		//Closes the program
		System.exit(0);
	}
	else{ 
		print("You did not enter a valid number. Please try again.");
		//Same as time.sleep() from python, allows user to read what was being said
		sleep(2000);
		options();
	}
}

	
public static void create() throws InterruptedException {
	
	//The fields belows are the required information to save an account
	String name  = input("Please enter the name of the account you wish to add.\n"
			+ "Ex: Gmail, Outlook\n"
			+ " Enter: ");
	String user = input("Please enter your username: ");
	String password = input("Please enter your password: ");
	
	//If level of security is 1
	if(Integer.parseInt(LOS)==1) {
		
		//Print writer is the class used to create and edit text files
		PrintWriter writer;
		
		//Try and catch clauses are always required around PrintWriter
		try {
			//Creates the text file
			writer = new PrintWriter(name+".txt","UTF-8");
			
			//The username goes on the first line
			writer.println(user);
			//Password on the second, password is encrypted on the low setting as LOS = 1
			writer.println(low(password));
			//Saves and closes the file
			writer.close();
		} 
		//Useless catch clauses, just required to be there
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//Success Message
	print("You have added a new account!");
	sleep(2000);
	options();
	}
	
	/*
	 * The same code is essentially repeated below, however, for LOS 2 the password is encrypted differently.
	 * LOS 3 is saved in a different location(hidden), and also encrypted differently.
	 *  
	 */
	
	if(Integer.parseInt(LOS)==2) {
	
			PrintWriter writer;
			try {
				writer = new PrintWriter(name+".txt","UTF-8");
				writer.println(user);
				writer.println(mid(password));
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		print("You have added a new account!");
		sleep(2000);
		options();
		}
	
	if(Integer.parseInt(LOS)==3) {
		
			PrintWriter writer;
			try {
				writer = new PrintWriter("C:\\ApplebyTemp\\"+ name +".txt","UTF-8");
				writer.println(user);
				writer.println(high(password));
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		print("You have added a new account!");
		sleep(2000);
		options();
	}


}


//Function that lists all of the accounts
public static void list()  {

	if(Integer.parseInt(LOS) == 1 ||Integer.parseInt(LOS) == 2) {
	
		//Gets the folder name, which is the project directory
		File folder = new File(System.getProperty("user.dir"));
		
		//Creates a filter to only account for text files
		File[] files = folder.listFiles(new FilenameFilter() {
			public boolean accept(File folder, String name) {
				return name.toLowerCase().endsWith(".txt");
			}
		});
		//Loops through the text files  and prints the 
		for(int i =0; i< files.length; i++) {
			print((i+1)+". "+files[i].getName());
			}
		String view = input("To view any of the accounts, please enter the corrosponding number: ");
		for(int i=0;i<files.length;i++) {
			if(i+1 == Integer.parseInt(view)) {
				BufferedReader br;
				try {
					
					br = new BufferedReader(new FileReader(System.getProperty("user.dir")+ File.separator + (files[i].getName())));
					String pass;
					String user;
					user = br.readLine();
					pass = br.readLine();
					if(Integer.parseInt(LOS)==1) {
						print("Your user name is :"+user);
						print("Your password is: "+low(pass));
					}
					else {
						print("Your user name is :"+user);
						print("Your password is: "+decryptMid(pass));
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}

	if(Integer.parseInt(LOS)==3) {
		File folder = new File("C://ApplebyTemp");
		File[] files = folder.listFiles(new FilenameFilter() {
			public boolean accept(File folder, String name) {
				return name.toLowerCase().endsWith(".txt");
			}	
		});
		for(int i =0; i< files.length; i++) {
			print((i+1)+". "+files[i].getName());
			}
	String view = input("To view any of the accounts, please enter the corrosponding number: ");
	for(int i=0;i<files.length;i++) {
		if(i+1 == Integer.parseInt(view)) {
			BufferedReader br;
			try {
				
				br = new BufferedReader(new FileReader("C://ApplebyTemp//"+files[i].getName()));
				String pass;
				String user;
				user = br.readLine();
				pass = br.readLine();
				if(Integer.parseInt(LOS)==3) {
					print("Your user name is: "+low(pass));
					print("Your password is: "+decryptMid(low(pass)));
				}	
				} 
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
					
					}
				}
			}
		}	
	}

public static void delete() {
	if(Integer.parseInt(LOS)==3) {
		File folder = new File("C://ApplebyTemp//");

		//Creates a filter to only account for text files
		File[] files = folder.listFiles(new FilenameFilter() {
			public boolean accept(File folder, String name) {
				return name.toLowerCase().endsWith(".txt");
			}
		});
	for(int i=0;i<files.length;i++) {
		files[i].delete();
		
		
	}
	print("All passwords(including master password) have been deleted\n"
			+ "The program will now exit");
	}
	else {
		File folder = new File(System.getProperty("user.dir"));

		//Creates a filter to only account for text files
		File[] files = folder.listFiles(new FilenameFilter() {
			public boolean accept(File folder, String name) {
				return name.toLowerCase().endsWith(".txt");
			}
		});
	for(int i=0;i<files.length;i++) {
		files[i].delete();
		
		
	}
	print("All passwords(excluding master password) have been deleted\n"
			+ "The program will now exit");
	}


}

}



