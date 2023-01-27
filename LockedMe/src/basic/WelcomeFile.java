package basic;



import java.util.Scanner;


public class WelcomeFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
    	System.out.println("Welcome to LockedMe.com");
		System.out.println("Developer Name:-Preeti Choudhary");
		System.out.println("\n");

		mainMenu();
		String res =sc.next();
		mainMethode(res);
	}
	
	static void featureMethode(String option){
		switch (option) {
		  case "1":
			System.out.println("Please Enter the filename");
			new ServiceFile(sc.next()).addFile();
			featureMenu();
			featureMethode(sc.next());
		    break;
		    
		  case "2":
			  System.out.println("Please Enter the filename");
			  new ServiceFile(sc.next()).deleteFile();
			  featureMenu();
			  featureMethode(sc.next());
			 break;
			 
		  case "3":
			  System.out.println("Please Enter the filename");
			  new ServiceFile(sc.next()).searchFile();
			  featureMenu();
			  featureMethode(sc.next());
			 break;
		    
		  case "4":
			  mainMenu();
			  String res =sc.next();
			  mainMethode(res);
		    break;
		    
		  default:
			  System.out.println("Wrong Choice try again");
			  featureMenu();
			  featureMethode(sc.next());

		}
	
	}
	
	 static void mainMenu()
	    {

			System.out.println("Main menu");
			System.out.println("1- Current Directory");
			System.out.println("2- Feature Menu");
			System.out.println("3- Exit");
			
			
	    }
	
		    static void featureMenu()
		    {

				System.out.println("Feature menu");
				System.out.println("1- Add");
				System.out.println("2- Delete");
				System.out.println("3- Serach");
				System.out.println("4- Exit");
				
				
		    }
		    
		    
		    static void mainMethode(String option){
				switch (option) {
				  case "1":
				  System.out.println("Working Directory = " + System.getProperty("user.dir"));
				  new ServiceFile().displayFile();	
				  mainMenu();
				  mainMethode(sc.next());
				    break;
				    
				  case "2":
					  featureMenu();
					  String res =sc.next();
					  featureMethode(res);
					 break;
					
				  case "3":
				    System.out.println("Exit");
				    break;
				    
				  default:
					  System.out.println("Wrong Choice try again");
					  mainMenu();
					  mainMethode(sc.next());

				}
		    
}
}
 