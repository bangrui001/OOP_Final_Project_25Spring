
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

interface customerInterface{ 
	
	public void viewFoodMenu();
	public void orderFood();
	public void cancelFood();
	public void viewOrderedFoods();
	public void getTotalOrderPrice();
	public void bookSeat();
	public void cancelSeat();
	public void viewMyReservations();
	
}
public class Customer extends User implements customerInterface{
	
	
	// my Order include all the Food Item that user ordered
	ArrayList<FoodEntry> myOrder = new ArrayList<>();

	Customer(String username, String phone, String email){
		super(username, phone, email);
		
	}
	
	Customer(){
		
	}
	
	    
	public void printCustomerFoodMenu() {
		System.out.println();
		System.out.println("1. View all Food Menu items ");
		System.out.println("2. Order a food item");
		System.out.println("3. Cancel a food item");
		System.out.println("4. View all Food items that current customer ordered");
		System.out.println("5. Calculate the Total Price of my Order");
		System.out.println("6. Display information for a given Food item");
		System.out.println("7. Exit");	
	}

	public void printCustomerSeatMenu(){
		System.out.println();
		System.out.println("1. Book a Table");
		System.out.println("2. Cancel a Table");
		System.out.println("3. View my Reservations");
		System.out.println("4. Exit");
	}
	
	public static void createProfile() {
		System.out.println();
		System.out.println("You are creating a New User profile now");
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter your User Name: ");
	    String userName = input.nextLine();
	    System.out.println("Please Enter your Phone Number: ");
	    String phone = input.nextLine();
	    System.out.println("Please Enter your Email address: ");
	    String email = input.nextLine();
	    Customer cust = new Customer(userName, phone, email);
	    RestaurantApp.customerList.add(cust); 
	    System.out.println("You successfully created the profile "+ userName);
	}

	
	public void orderFood() {
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Food Item name you want to order: ");
		String fName = input.nextLine();
	
		
		//if we find the entry, result is 1
		int result = directory.addCustomer(this.username, fName);
		if(result ==1) {
			//add the ordered food to myOrder list
			if(myOrder == null) {
				myOrder = new ArrayList<FoodEntry>();
			}
			myOrder.add(directory.locateEntryByName(fName));
			System.out.println(this.username+" successfully ordered "+fName);
		}else {
			System.out.println("Fail to order "+ fName);
		}	
		
		
	}

	// cancel a Food Item from the customer's order. check by customer name and food name
	public void cancelFood() {
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the Food Item name you want to cancel: ");
		String fName = input.nextLine();

		int result = directory.cancelOrder(this.username, fName);
		if(result == 1) {
			//remove the cancelled food item from myOrder list
			if(myOrder == null) {
				myOrder = new ArrayList<FoodEntry>();
			}
			myOrder.remove(directory.locateEntryByName(fName));
			System.out.println(fName+" is successfully removed from your Order");
		}else {
			System.out.println("Fail to remove the food item");
		}
		
	}
	
	public void viewOrderedFoods() {
		System.out.println();
		if(myOrder == null) {
			myOrder = new ArrayList<FoodEntry>();
		}
		for(int i=0;i<myOrder.size();i++) {
			myOrder.get(i).printFoodEntry();
		}
		if(myOrder.size() == 0) {
			System.out.println("This customer doesn't order any Food Items");
		}
		
	}
	
	public void getTotalOrderPrice() {
		System.out.println();
	    double total = 0.00;
	    for (FoodEntry item : myOrder) {
	        total += item.getPrice();
	    }
	    System.out.print("The Total Price of your order is: $"+ total);
	}
	
	
	//check customer by user name
		public boolean sameUserName(String un) {
			if (this.username.equalsIgnoreCase(un)) {
				return true;
			}
			return false;
		}
		
	//check customer by phone
		public boolean sameLastName(String phone) {
			if(this.phone.equalsIgnoreCase(phone)) {
				return true;
			}
			return false;
		}
		
	public boolean isValid() {
		if(this.username != null) {
			return true;
		}
		return false;
	}

	// method for customer to book a seat
	public void bookSeat() {
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter party size (number of people): ");
		int partySize = input.nextInt();
		if (partySize > 6) {
			System.out.println("Sorry, we do not have tables available for more than 6 people.");
			return;
		}
		input.nextLine();
		System.out.println("Enter reservation hour (e.g. 18 for 6 PM): ");
		String hour = input.nextLine();
		directory.printAvailableSeats(hour, partySize);
	
		System.out.println("Enter Table ID to reserve: ");
		String seatId = input.nextLine();
		boolean success = directory.reserveSeat(this.username, seatId, hour);
		Seat seat = directory.findSeatById(seatId);

		if (success) {
			System.out.println("Table reserved successfully.");
		} else {
			System.out.println("Failed to reserve the Table.");
		}
	}
	
	public void cancelSeat() {
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Table ID to cancel: ");
		String seatId = input.nextLine();
		System.out.println("Enter the reservation hour (e.g. 18 for 6 PM): ");
		String hour = input.nextLine();
		boolean success = directory.cancelSeat(seatId, this.username, hour);
		if (success) {
			System.out.println("Table reservation cancelled.");
		} else {
			System.out.println("Failed to cancel reservation.");
		}
	}
	
	public void viewMyReservations() {
		System.out.println();
		int count = 0;
		for (Seat seat : RestaurantApp.seatList) {
			for (SeatReservation res : seat.getReservations()) {
				if (res.getCustomerName().equalsIgnoreCase(this.username)) {
					System.out.println("Table " + seat.getSeatId() + " at " + res.getHour()+ ":00");
					count++;
				}
			}
		}
		if (count == 0) {
			System.out.println("No reservations found for " + this.username);
		}
	}
}