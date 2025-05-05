
// import java.util.Scanner;
// import java.io.*;
// import java.util.ArrayList;
// import java.nio.file.*;
// public class RestaurantApp {

// 	// three important lists to store the food entries, customer entries and seat entries
// 	protected static ArrayList<FoodEntry> foodList = new ArrayList<>();
// 	protected static ArrayList<Customer> customerList = new ArrayList<>();
// 	// for table booking
// 	protected static ArrayList<Seat> seatList = new ArrayList<>();

	
//     private static void initializeFoodMenu() {
//         foodList.add(new FoodEntry("Cheeseburger", "01", 8.25, "Entree", new ArrayList<>()));
//         foodList.add(new FoodEntry("Sausage Pizza", "02", 11.50, "Entree", new ArrayList<>()));
//         foodList.add(new FoodEntry("Caesar Salad", "03", 6.75, "Appetizer", new ArrayList<>()));
//         foodList.add(new FoodEntry("Chicken Wings", "04", 9.75, "Appetizer", new ArrayList<>()));
//         foodList.add(new FoodEntry("Chocolate Cake", "05", 8.00, "Dessert", new ArrayList<>()));
//         foodList.add(new FoodEntry("Apple Pie", "06", 4.50, "Dessert", new ArrayList<>()));
//         foodList.add(new FoodEntry("Hot Coffee", "07", 3.00, "Beverage", new ArrayList<>()));
//         foodList.add(new FoodEntry("Lobster Roll", "08", 14.75, "Beverage", new ArrayList<>()));
//         foodList.add(new FoodEntry("Grilled Salmon", "09", 23.75, "Entree", new ArrayList<>()));
//         foodList.add(new FoodEntry("Peking Duck", "10", 24.75, "Entree", new ArrayList<>()));
//     }

// 	private static void initializeSeats() {
// 		for (int i = 1; i <= 10; i++) {
// 			int capacity;
// 			if (i <= 4) {
// 				capacity = 2;
// 			} else if (i <= 8) {
// 				capacity = 4;
// 			} else {
// 				capacity = 6;
// 			}
// 			seatList.add(new Seat("S" + i, capacity));
// 		}
// 	}

	
// 	protected static int addEntry(FoodEntry entry){
// 		if(entry.isValid()) {
// 			foodList.add(entry);
// 			return 1;
// 		}
// 	 return 0;
// 	}
	
// 	//method overloading
// 	protected static int addEntry(Customer customer){
// 		if(customer.isValid()) {
// 			customerList.add(customer);
// 			return 1;
// 		}
// 	 return 0;
// 	}
	
// 	public static void main(String args[]) {
		
// 		// initialize the food menu and seats
// 		initializeFoodMenu();
// 		initializeSeats();
// 		//the userName of Admin is Admin
// 		SystemDirectory directory = new SystemDirectory();
 
// 		Scanner input = new Scanner(System.in);
// 		System.out.println("====================================================");
// 		System.out.println("====================================================");
// 		System.out.println("====================================================");
// 		System.out.println("Welcome to Use the Restaurant Order and Seats Booking System!");
// 		System.out.println("====================================================");
// 		System.out.println("====================================================");
// 		System.out.println("====================================================");
// 		System.out.println("If you are an Admin, Enter 1");
// 		System.out.println("If you are a Customer, Enter 2");
// 		System.out.println("If you want to Exit, Enter 3");
// 		int ans = input.nextInt();
		
// 		while (ans != 3) {
			
// 		//if the user choose to be the Admin
// 		// ans=1 represent Admin mode
// 		if(ans ==1) {
// 			input.nextLine();
// 			//password verification
// 			System.out.println("Hi, Admin user");
// 			System.out.println("The default UserName for Admin user is Admin");
// 		    System.out.println("Please enter your User Name: ");
// 			String un = input.next();
// 			Admin admin1 = new Admin();
// 			if(un.equalsIgnoreCase(admin1.getUsername())) 
// 			{
// 				System.out.println("You passed the verification!");
// 				System.out.println("Type 1 to Enter Food Ordering Management system");
// 				System.out.println("Type 2 to Enter Table Booking Management system");
// 				System.out.println("Type 3 to Exit");
// 				int num = input.nextInt();
			   
// 				//we will show the class of choice by admin
// 				//admin user can choose go to food ordering and table booking
// 				while(num!=3) {
// 				   if(num==1) {
// 					    System.out.println();
// 						admin1.manageFoodMenu();
// 						System.out.println("Please enter the number of your choice: ");
// 					    int choice = input.nextInt();
// 					    while(choice != 8) {
					    	
// 					    	if(choice ==1) {
// 					    		admin1.addMenuItem();
// 					    	}else if (choice == 2 ) {
// 					    		admin1.deleteMenuItem();
// 					    	}else if (choice == 3 ) {
// 					    		admin1.editMenuItem();
// 					    	}else if (choice == 4) {
// 					    		admin1.displayInfo();
// 					    	}else if (choice == 5) {
// 					    		admin1.viewFoodMenu();
// 					    	}else if( choice == 6){
// 					    		admin1.viewOrderedFoods();
// 					    	}else if ( choice == 7) {
// 					    		admin1.viewFoodItemNameList();
// 					    	}else {
// 					    		System.out.println("Please enter a valid number!");
// 					    	}
// 					    	admin1.manageFoodMenu();
// 					    	System.out.println("Please enter the number of your choice: ");
// 					    	choice = input.nextInt();
// 					    }
					    
// 					}else if(num == 2) {
// 						System.out.println();
// 						admin1.manageSeatMenu();
// 						System.out.println("Please enter the number of your choice: ");
// 						int choice = input.nextInt();
// 						while(choice != 3) {
// 							if(choice == 1) {
// 								admin1.viewSeatReservations();
// 							}else if (choice == 2 ) {
// 								admin1.changeSeatAvailability();
// 							}else {
// 								System.out.println("Please enter a valid number!");
// 							}
// 							admin1.manageSeatMenu();
// 							System.out.println("Please enter the number of your choice: ");
// 							choice = input.nextInt();
// 						}
// 					}
// 					else {
// 						System.out.println("Your input number is invalid!");
// 						System.out.println("Please enter a valid number");
// 					}
// 					System.out.println("Type 1 to enter Food Management system");
// 					System.out.println("Type 2 to enter Seat Management system");
// 					System.out.println("Type 3 to Exit");
// 					num = input.nextInt();
// 				}
			
// 				//we quit the admin user menu at this point, but we are still a admin user
				
// 			//else shows the event that the admin user's input username is invalid
// 			}else {
// 				System.out.println("Your entered User Name is invalid!");
				
// 			}
				
			
		
// 	   }else if (ans == 2 ) {
// 		    input.nextLine();
// 		    System.out.println("Hi, Customer user!");
// 		    System.out.println("Please enter your User Name: ");
// 			String username = input.nextLine();
			
// 			//We try to locate the user by its user name
// 			Customer customer1 = directory.locateCustomer(username);
			
// 			// if the user do not enroll before, we will ask them to create a new user profile
// 			if(customer1 == null) {
// 				System.out.println("Sorry we don't find your input User Name in our System");
// 				System.out.println("Do you want to create a New Profile: ");
// 				System.out.println("1. Yes");
// 				System.out.println("2. No");
// 				int choice = input.nextInt();
// 				input.nextLine();
// 				if(choice == 1) {
// 				  Customer.createProfile();
// 				}else {
// 					System.out.println("Sorry, you can't use our System with wrong User Name");
// 					break;
// 				}
// 			}
// 			//if we find the customer name by its userName and password
// 			//then variable stu1 will be assigned to the found customer object
// 			else if( customer1 != null && customer1.isValid()) {
// 				System.out.println("You passed the verification!");
// 				System.out.println("Type 1 to Enter Food Ordering System");
// 				System.out.println("Type 2 to Enter Table Booking System");
// 				System.out.println("Type 3 to Exit");
// 				System.out.println("Please enter the number of your choice: ");
// 				int choice = input.nextInt();
// 				while(choice != 3) {
// 					if(choice == 1) {
// 						System.out.println();
// 						customer1.printCustomerFoodMenu();
// 						System.out.println("Please enter the number of your choice: ");
// 						int food_choice = input.nextInt();
// 						while(food_choice != 6) {
// 							if(food_choice ==1) {
// 								customer1.viewFoodMenu();
// 							}else if (food_choice == 2 ) {
// 								customer1.orderFood();
// 							}else if (food_choice == 3) {
// 								customer1.cancelFood();
// 							}else if (food_choice == 4) {
// 								customer1.viewOrderedFoods();
// 							}else if (food_choice == 5){
// 								customer1.getTotalOrderPrice();
// 							}else {
// 								System.out.println("Please enter a valid number!");
// 							} 
// 							System.out.println();
// 							customer1.printCustomerFoodMenu();
// 							System.out.println("Please enter the number of your choice: ");
// 							food_choice = input.nextInt();
// 						}
// 					}else if (choice == 2) {
// 						System.out.println();
// 						customer1.printCustomerSeatMenu();
// 						System.out.println("Please enter the number of your choice: ");
// 						int seat_choice = input.nextInt();
// 						while(seat_choice != 4) {
// 							if(seat_choice == 1) {
// 								customer1.bookSeat();
// 							}else if (seat_choice == 2 ) {
// 								customer1.cancelSeat();
// 							}else if (seat_choice == 3) {
// 								customer1.viewMyReservations();
// 							}else {
// 								System.out.println("Please enter a valid number!");
// 							} 
// 							System.out.println();
// 							customer1.printCustomerSeatMenu();
// 							System.out.println("Please enter the number of your choice: ");
// 							seat_choice = input.nextInt();
// 						}
// 					}else {
// 						System.out.println("Your input number is invalid!");
// 					}
// 					System.out.println("Type 1 to enter Food Ordering System");
// 					System.out.println("Type 2 to enter Seat Booking System");
// 					System.out.println("Type 3 to Exit");
// 					System.out.println("Please enter the number of your choice: ");
// 					choice = input.nextInt();
// 				}

// 			//If the UserName is invalid
// 			}else {
// 				System.out.println("Your entered Customer's UserName is invalid!");	
// 			}
			
// 	     }
// 		 else 
// 		 {
// 	        	System.out.println("Please enter a Valid Number for your answer!");
// 	     }
// 		        //update  the answer;
// 		        System.out.println();
// 	        	System.out.println("If you are a Admin, Enter 1");
// 	    		System.out.println("If you are a Customer, Enter 2");
// 	    		System.out.println("If you want to Exit, Enter 3");
// 	    		ans = input.nextInt();
// 	    }
		
		
// 		   System.out.println("Thank for using our Food Ordering System!");
// 		   System.out.println("Hope you have a great day!");
		   
//  } 	
	
// }
	 

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantApp {

    protected static ArrayList<FoodEntry> foodList = new ArrayList<>();
    protected static ArrayList<Customer> customerList = new ArrayList<>();
    protected static ArrayList<Seat> seatList = new ArrayList<>();

    public static void main(String args[]) {
        initializeFoodMenu();
        initializeSeats();
        SystemDirectory directory = new SystemDirectory();
        Scanner input = new Scanner(System.in);
		System.out.println("=================================================================");
        System.out.println("Welcome to Use the Restaurant Order and Seats Booking System!");
		System.out.println("================================================================");
		System.out.println("");

        int ans;
		// use do while loop to keep asking the user for input until they choose to exit
        do {
            System.out.println("If you are an Admin, Enter 1");
            System.out.println("If you are a Customer, Enter 2");
            System.out.println("If you want to Exit, Enter 3");
            ans = input.nextInt();

            if (ans == 1) {
                AdminCondintion(directory, input);
            } else if (ans == 2) {
                CustomerCondition(directory, input);
            } else if (ans != 3) {
                System.out.println("Please enter a Valid Number for your answer.");
            }

        } while (ans != 3);

        System.out.println("Thank you for using our Restaurant System!");
        System.out.println("Have a great day!");
    }

    private static void AdminCondintion(SystemDirectory directory, Scanner input) {
        input.nextLine();
        System.out.println("Hi, Dear Admin");
        System.out.println("The default UserName for Admin user is Admin");
        System.out.println("Please enter your User Name: ");
        String un = input.next();
        Admin admin1 = new Admin();
        if (un.equalsIgnoreCase(admin1.getUsername())) {
            System.out.println("You passed the verification!");
            int num;
            do {
                System.out.println("Type 1 to Enter Food Ordering Management system");
                System.out.println("Type 2 to Enter Table Booking Management system");
                System.out.println("Type 3 to Exit");
                num = input.nextInt();

				// use switch case to handle the admin menu
                switch (num) {
                    case 1 -> AdminFoodCondition(admin1, input);
                    case 2 -> AdminSeatCondition(admin1, input);
                    case 3 -> System.out.println("Exiting Admin Mode...");
                    default -> System.out.println("Your input number is invalid, please try again.");
                }
            } while (num != 3);
        } else {
            System.out.println("Your entered User Name is invalid, please try again.");
        }
    }

    private static void AdminFoodCondition(Admin admin1, Scanner input) {
        int choice;
        do {
            admin1.manageFoodMenu();
            System.out.println("Please enter the number of your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> admin1.addMenuItem();
                case 2 -> admin1.deleteMenuItem();
                case 3 -> admin1.editMenuItem();
                case 4 -> admin1.displayInfo();
                case 5 -> admin1.viewFoodMenu();
                case 6 -> admin1.viewOrderedFoods();
                case 7 -> admin1.viewFoodItemNameList();
                case 8 -> System.out.println("Exiting food system mode...");
                default -> System.out.println("Please enter a valid number.");
            }
        } while (choice != 8);
    }

    private static void AdminSeatCondition(Admin admin1, Scanner input) {
        int choice;
        do {
            admin1.manageSeatMenu();
            System.out.println("Please enter the number of your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> admin1.viewSeatReservations();
                case 2 -> admin1.changeSeatAvailability();
                case 3 -> System.out.println("Exiting seat system mode...");
                default -> System.out.println("Please enter a valid number.");
            }
        } while (choice != 3);
    }

    private static void CustomerCondition(SystemDirectory directory, Scanner input) {
        input.nextLine();
        System.out.println("Hi, Dear Customer!");
        System.out.println("Please enter your User Name: ");
        String username = input.nextLine();

        Customer customer1 = directory.locateCustomer(username);
        if (customer1 == null) {
            System.out.println("Sorry we don't find your input User Name in our System");
            System.out.println("Do you want to create a New Profile: ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                Customer.createProfile();
            } else {
                System.out.println("Sorry, you can't use our System with wrong User Name");
            }
            return;
        }

        if (customer1.isValid()) {
            System.out.println("You passed the verification!");
            int choice;
            do {
                System.out.println("Type 1 to Enter Food Ordering System");
                System.out.println("Type 2 to Enter Table Booking System");
                System.out.println("Type 3 to Exit");
                System.out.println("Please enter the number of your choice: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1 -> CustomerFoodCondition(customer1, input);
                    case 2 -> CustomerSeatCondition(customer1, input);
                    case 3 -> System.out.println("Exiting customer mode...");
                    default -> System.out.println("Invalid input number!");
                }
            } while (choice != 3);
        } else {
            System.out.println("Your entered Customer's UserName is invalid.");
        }
    }

    private static void CustomerFoodCondition(Customer customer, Scanner input) {
        int food_choice;
        do {
            customer.printCustomerFoodMenu();
            System.out.println("Please enter the number of your choice: ");
            food_choice = input.nextInt();

            switch (food_choice) {
                case 1 -> customer.viewFoodMenu();
                case 2 -> customer.orderFood();
                case 3 -> customer.cancelFood();
                case 4 -> customer.viewOrderedFoods();
                case 5 -> customer.getTotalOrderPrice();
                case 6 -> System.out.println("Exiting food menu mode...");
                default -> System.out.println("Please enter a valid number.");
            }
        } while (food_choice != 6);
    }

    private static void CustomerSeatCondition(Customer customer, Scanner input) {
        int seat_choice;
        do {
            customer.printCustomerSeatMenu();
            System.out.println("Please enter the number of your choice: ");
            seat_choice = input.nextInt();

            switch (seat_choice) {
                case 1 -> customer.bookSeat();
                case 2 -> customer.cancelSeat();
                case 3 -> customer.viewMyReservations();
                case 4 -> System.out.println("Exiting seat booking mode...");
                default -> System.out.println("Please enter a valid number.");
            }
        } while (seat_choice != 4);
    }

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

    private static void initializeSeats() {
		for (int i = 1; i <= 10; i++) {
			int capacity;
			if (i <= 4) {
				capacity = 2;
			} else if (i <= 8) {
				capacity = 4;
			} else {
				capacity = 6;
			}
			seatList.add(new Seat("S" + i, capacity));
		}
    }

	//method to add a food entry
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
}