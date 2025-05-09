import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantApp {

    protected static ArrayList<FoodEntry> foodList = new ArrayList<>();
    protected static ArrayList<Customer> customerList = new ArrayList<>();
    protected static ArrayList<Seat> seatList = new ArrayList<>();

    public static void main(String args[]) {
        initializeFoodMenu();
        initializeSeats();
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
                AdminCondintion(input);
            } else if (ans == 2) {
                CustomerCondition(input);
            } else if (ans != 3) {
                System.out.println("Please enter a Valid Number for your answer.");
            }

        } while (ans != 3);

        System.out.println("Thank you for using our Restaurant System!");
        System.out.println("Have a great day!");
    }

    private static void AdminCondintion(Scanner input) {
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
            admin1.printAdminFoodMenu();
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
            admin1.printAdminSeatMenu();
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

    private static void CustomerCondition(Scanner input) {
        input.nextLine();
        System.out.println("Hi, Dear Customer!");
        System.out.println("Please enter your User Name: ");
        String username = input.nextLine();

        Customer customer1 = locateCustomer(username);
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
                case 6 -> customer.displayInfo();
                case 7 -> System.out.println("Exiting food menu mode...");
                default -> System.out.println("Please enter a valid number.");
            }
        } while (food_choice != 7);
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
        foodList.add(new FoodEntry("Cheeseburger", "1", 8.25, "Entree", new ArrayList<>()));
        foodList.add(new FoodEntry("Sausage Pizza", "2", 11.50, "Entree", new ArrayList<>()));
        foodList.add(new FoodEntry("Caesar Salad", "3", 6.75, "Appetizer", new ArrayList<>()));
        foodList.add(new FoodEntry("Chicken Wings", "4", 9.75, "Appetizer", new ArrayList<>()));
        foodList.add(new FoodEntry("Chocolate Cake", "5", 8.00, "Dessert", new ArrayList<>()));
        foodList.add(new FoodEntry("Apple Pie", "6", 4.50, "Dessert", new ArrayList<>()));
        foodList.add(new FoodEntry("Hot Coffee", "7", 3.00, "Beverage", new ArrayList<>()));
        foodList.add(new FoodEntry("Lobster Roll", "8", 14.75, "Beverage", new ArrayList<>()));
        foodList.add(new FoodEntry("Grilled Salmon", "9", 23.75, "Entree", new ArrayList<>()));
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
			seatList.add(new Seat("T" + i, capacity));
		}
    }

    //locate the customer from the customer list by its userName 
	private static Customer locateCustomer(String userName) {
		for(int i=0;i<RestaurantApp.customerList.size(); i++) {
			if(RestaurantApp.customerList.get(i).isValid()) {
				Customer stu = RestaurantApp.customerList.get(i);
				if(stu.sameUserName(userName)) {
					return stu;
				}
		}
	 }
		return null;
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