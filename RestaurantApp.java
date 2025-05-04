
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.nio.file.*;
public class RestaurantApp {

	protected static ArrayList<FoodEntry> foodList = new ArrayList<>();
	protected static ArrayList<Customer> customerList = new ArrayList<>();
	
    private static void initializeFoodMenu() {
        foodList.add(new FoodEntry("Cheeseburger", "01", 8.25, "Entree", new ArrayList<>()));
        foodList.add(new FoodEntry("Sausage Pizza", "02", 11.50, "Entree", new ArrayList<>()));
        foodList.add(new FoodEntry("Caesar Salad", "03", 6.75, "Appetizer", new ArrayList<>()));
        foodList.add(new FoodEntry("Chicken Wings", "04", 9.75, "Appetizer", new ArrayList<>()));
        foodList.add(new FoodEntry("Chocolate Cake", "05", 8.00, "Dessert", new ArrayList<>()));
        foodList.add(new FoodEntry("Apple Pie", "06", 4.50, "Dessert", new ArrayList<>()));
        foodList.add(new FoodEntry("Hot Coffee", "07", 3.00, "Beverage", new ArrayList<>()));
        foodList.add(new FoodEntry("Lobster Roll", "08", 14.75, "Beverage", new ArrayList<>()));
        foodList.add(new FoodEntry("Grilled Salmon", "09", 23.75, "Entree", new ArrayList<>()));
        foodList.add(new FoodEntry("Peking Duck", "10", 24.75, "Entree", new ArrayList<>()));
    }

	
	protected static int addEntry(FoodEntry entry){
		if(entry.isValid()) {
			foodList.add(entry);
			return 1;
		}
	 return 0;
	}
	
	//method overloading
	protected static int addEntry(Customer customer){
		if(customer.isValid()) {
			customerList.add(customer);
			return 1;
		}
	 return 0;
	}
	
	public static void main(String args[]) {
		
		initializeFoodMenu();
		//the userName of Admin is Admin
		SystemDirectory directory = new SystemDirectory();
 
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to use the Restaurant order System");
		System.out.println("If you are a Admin, Enter 1");
		System.out.println("If you are a Customer, Enter 2");
		System.out.println("If you want to Exit, Enter 3");
		int ans = input.nextInt();
		
		while (ans != 3) {
			
		//if the user choose to be the Admin
		// ans=1 represent Admin mode
		if(ans ==1) {
			input.nextLine();
			//password verification
			System.out.println("Hi, Admin user");
			System.out.println("The default UserName for Admin user is Admin");
		    System.out.println("Please enter your User Name: ");
			String un = input.next();
			Admin admin1 = new Admin();
			if(un.equalsIgnoreCase(admin1.getUsername())) 
			{
				System.out.println("You passed the verification!");
				System.out.println("Type 1 to Enter Food Ordering Management system");
				System.out.println("Type 2 to Exit");
				int num = input.nextInt();
			   
				//we will show the class of choice by admin
				//admin user can choose go to food ordering and table booking
				while(num!=2) {
					
				   if(num==1) {
					    System.out.println();
						admin1.manageMenu();
						System.out.println("Please enter the number of your choice: ");
					    int choice = input.nextInt();
					    while(choice != 8) {
					    	
					    	if(choice ==1) {
					    		admin1.addMenuItem();
					    	}else if (choice == 2 ) {
					    		admin1.deleteMenuItem();
					    	}else if (choice == 3 ) {
					    		admin1.editMenuItem();
					    	}else if (choice == 4) {
					    		admin1.displayInfo();
					    	}else if (choice == 5) {
					    		admin1.viewFoodMenu();
					    	}else if( choice == 6){
					    		admin1.viewOrderedFoods();
					    	}else if ( choice == 7) {
					    		admin1.viewFoodItemNameList();
					    	}else {
					    		System.out.println("Please enter a valid number!");
					    	}
					    	admin1.manageMenu();
					    	System.out.println("Please enter the number of your choice: ");
					    	choice = input.nextInt();
					    }
					    
					}else {
						System.out.println("Your input number is invalid!");
						System.out.println("Please enter a valid number");
					}
					System.out.println("Type 1 to enter Food Management system");
					System.out.println("Type 2 to Exit");
					num = input.nextInt();
				}
			
				//we quit the admin user menu at this point, but we are still a admin user
				
			//else shows the event that the admin user's input username is invalid
			}else {
				System.out.println("Your entered User Name is invalid!");
				
			}
				
			
		
	   }else if (ans == 2 ) {
		    input.nextLine();
		    System.out.println("Hi, Customer user!");
		    System.out.println("Please enter your User Name: ");
			String username = input.nextLine();
			
			//We try to locate the user by its user name
			Customer customer1 = directory.locateCustomer(username);
			
			// if the user do not enroll before, we will ask them to create a new user profile
			if(customer1 == null) {
				System.out.println("Sorry we don't find your input User Name in our System");
				System.out.println("Do you want to create a New Profile: ");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int choice = input.nextInt();
				input.nextLine();
				if(choice == 1) {
				  Customer.createProfile();
				}else {
					System.out.println("Sorry, you can't use our System with wrong User Name");
					break;
				}
			}
			//if we find the student name by its userName and password
			//then variable stu1 will be assigned to the found student object
			else if( customer1 != null && customer1.isValid()) {
				System.out.println("You passed the verification!");
				customer1.printCustomerMenu();
				System.out.println("Please enter the number of your choice: ");
				int choice = input.nextInt();
				while(choice != 6) {
				    if(choice ==1) {
				    	customer1.viewFoodMenu();
				    }else if (choice == 2 ) {
				    	customer1.orderFood();
				    }else if (choice == 3) {
				    	customer1.cancelFood();
				    }else if (choice == 4) {
				    	customer1.viewOrderedFoods();
				    }else if (choice == 5){
				    	customer1.getTotalOrderPrice();
				    }else {
				    	System.out.println("Please enter a valid number!");
				    } 
				    System.out.println();
				    customer1.printCustomerMenu();
				    System.out.println("Please enter the number of your choice: ");
				    choice = input.nextInt();
				    
				}
				//If the UserName is invalid
			}else {
				System.out.println("Your entered Customer's UserName is invalid!");	
			}
			
			
	     }else {
	        	System.out.println("Please enter a Valid Number for your answer!");
	     }
		        //update  the answer;
		        System.out.println();
	        	System.out.println("If you are a Admin, Enter 1");
	    		System.out.println("If you are a Student, Enter 2");
	    		System.out.println("If you want to Exit, Enter 3");
	    		ans = input.nextInt();
	    }
		
		
		   System.out.println("Thank for using our Food Ordering System!");
		   System.out.println("Hope you have a great day!");
		   
 } 	
	
}
	 