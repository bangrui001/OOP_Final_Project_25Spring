
import java.util.ArrayList;
import java.util.Scanner;

interface AdminInterface{
	public void addMenuItem();
	public void deleteMenuItem();
	public void editMenuItem();
	public void displayInfo();
	public void viewFoodMenu();
	public void viewOrderedFoods();
	public void viewFoodItemNameList();
	
}

public class Admin extends User implements AdminInterface{
	
	
	public Admin(String un,String phone, String email) {
		super("Admin", phone, email);
   
	}
	
	public Admin() {
		super("Admin","9176688","bc3117@nyu.edu");
		
	}
	
	public void manageFoodMenu() {
		System.out.println("1. Add a new Food Item to the Menu");
		System.out.println("2. Delete a Food Item from the Menu");
		System.out.println("3. Edit a Food Item on the Menu");
		System.out.println("4. Display information for a given Food item");
		System.out.println("5. View all Food Items on the Menu");
		System.out.println("6. View the list of Food Items ordered by a given Customer");
		System.out.println("7. View the list of Customers that all ordered a given Food Item ");
		System.out.println("8. Exit");
	}
	
	public void manageSeatMenu(){
		System.out.println("1. View all Seat Reservations");
		System.out.println("2. Change Seat Availability");
		System.out.println("3. Exit");
	}

	public void addMenuItem(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Food Name you want to create: ");
		String foodName = input.nextLine();
		System.out.println("Please enter the Food ID: ");
		String foodId = input.next();
		System.out.println("Please enter the Price of Food: ");
		int price = input.nextInt();
		//move to the nextLine
		input.nextLine();
		System.out.println("Please enter the Category of Food: ");
		String category = input.nextLine();
		FoodEntry a = new FoodEntry(foodName,foodId, price, category,null);
		
		int result = directory.createMenuItem(a);
		if(result == 1) {
			System.out.println("you successfully create a new Menu Item "+a.getFoodName());
		}else {
			System.out.println("Fail to create a new Menu Item.");
		}
	}
	
	
	public void deleteMenuItem() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Food Name: ");
		String fName = input.nextLine();
		int result = directory.deleteEntry(fName);
		if(result == 1) {
			System.out.println("you successfully delete this Food Item from the Menu");
		}else {
			System.out.println("Fail to delete the Food Item");
		}
		
	}
	
	public void editMenuItem() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Food Name: ");
		String foodName = input.nextLine();
		int result = directory.editFoodEntry(foodName);
		if(result == 1) {
			System.out.println("you successfully edit this Food Item");
		}else {
			System.out.println("Fail to edit the Food Menu Item");
		}
	}
	
	//Display the information of a give Food Item
	public void displayInfo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Food Item Id: ");
		String id = input.nextLine();
		directory.displayFoodItem(id);
	
	}
	
	public void viewOrderedFoods() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Customer's User name: ");
		String un = input.next();
		
		//First we need to locate the customer
		for(int k=0; k<RestaurantApp.customerList.size();k++) {
			if(RestaurantApp.customerList.get(k).isValid()) {
				Customer user = RestaurantApp.customerList.get(k);
			//if we find the Food item, we call customer's viewOrderedFoods() method;
				if(user.sameUserName(un)) {
				user.viewOrderedFoods();
				break;
			}
		}  
	}
	}
	
	//view the names of all customers that all ordered a given Food item
	public void viewFoodItemNameList() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Food name: ");
		String fName = input.nextLine();
		directory.viewNameList(fName);
	}

	// Seats related methods for Admin
	public void viewSeatReservations() {
		for (Seat seat : RestaurantApp.seatList) {
			seat.printReservations();
		}
	}
	
	public void changeSeatAvailability() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Seat ID to change availability:");
		String seatId = input.nextLine();
		Seat seat = directory.findSeatById(seatId);
		if (seat != null) {
			System.out.println("Current status: " + seat.isReservable());
			System.out.println("Enter 1 to make it reservable, 0 to make it not reservable:");
			int admin_input = input.nextInt();
			if (admin_input == 1) {
				seat.setReservable(true);
			} else {
				seat.setReservable(false);
			}
			System.out.println("Seat availability updated.");
		} else {
			System.out.println("Seat not found.");
		}
	}

}