import java.io.*;
import java.util.*;

public class SystemDirectory {
	
	//constructor of the class SystemDirectory
	public SystemDirectory() {
	  
	}
	

	//add a new Customer to the customerList in the RestaurantApp class
	//if successfully add a new customer, return 1. Otherwise, return 0
	
	public int addEntry(Customer entry){
		if(entry.isValid()) {
			RestaurantApp.addEntry(entry);
			return 1;
		}
	 return 0;
	}
	
	//add a new Food item to the foodList in the RestaurantApp class
	protected int createMenuItem(FoodEntry a) {
	
		 int result = RestaurantApp.addEntry(a);
		 return result;
	}
	
	
	//locate the Food entry by its foodId 
	//this method will return the reference of the Food object
	private FoodEntry locateFoodEntry(String id) {
		for(int i=0;i<RestaurantApp.foodList.size();i++) {
			if(RestaurantApp.foodList.get(i).isValid()) {
				FoodEntry entry = RestaurantApp.foodList.get(i);
				//System.out.println(book.get(i).getFoodName());
				if(entry.sameFoodId(id)) {
					return entry;
				}
			}
		}
		return null;	
	}
	
	
	protected FoodEntry locateEntryByName(String fName) {
		for(int n=0; n<RestaurantApp.foodList.size(); n++) {
			if(RestaurantApp.foodList.get(n).isValid()) {
				FoodEntry entry = RestaurantApp.foodList.get(n);
				if(entry.sameFoodName(fName)) {
					return entry;
				}
			}
		}
		return null;
		
	}
	

	
	//view the names of customers for a specific Food Item
	protected void viewNameList(String foodName) {
		FoodEntry entry = locateEntryByName(foodName);
		if(entry != null && entry.isValid()) {
		   entry.printCustomerName();
		}
		
	}
	
	//add a customer to the customer_list
	protected boolean registerCustomer(Customer obj) {
		if(obj.username != null) {
		         RestaurantApp.customerList.add(obj);
		         return true;
		}
		return false;
		
	}
	
	//return 1 if successfully cancel a customer's order, otherwise return 0
	protected int cancelOrder(String userName, String foodName) {
		FoodEntry entry = locateEntryByName(foodName);
		//if we find the entry
		if(entry != null && entry.isValid()) {
		   return entry.deleteCustomerName(userName);  
		}
		return 0;
	
	}
 
	
	//delete a Food Item from the Food Menu List (only allowed by Admin)
	protected int deleteEntry(String fName) {
		FoodEntry foodItem = locateEntryByName(fName);
		if(foodItem != null && foodItem.isValid()) {
			RestaurantApp.foodList.remove(foodItem);
			return 1;
		}
		return 0;
			
	}
		
	

	//edit a food Item Except for foodId and foodName
	//if the FoodEntry does not exist, return 0;
	//if edit operation succeed, return 1
	protected int editFoodEntry(String foodName) {
		//if the entry exist
		FoodEntry foodEntry = locateEntryByName(foodName);
		if( foodEntry == null) {
			return 0;
		}
		
		System.out.println("1. Edit Price");
		System.out.println("2. Edit Category");
		
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter the number of your choice: ");
		int choice = input.nextInt();
		if(choice == 1) {
			System.out.println("Please enter the new Price of the food Item: ");
			int num = input.nextInt();
			return foodEntry.setPrice(num);
			
		}else if(choice == 2) {
			input.nextLine();
			System.out.println("Please enter the new category: ");
			String cg = input.nextLine();
			foodEntry.setCategory(cg);
			return 1;
		
		}else {
			System.out.println("Your entered number is invalid");
			return 0;
		}
		
	}
	
	protected void displayFoodItem(String foodid) {
		FoodEntry item = locateFoodEntry(foodid);
		if(item!= null && item.isValid()) {
		 item.printFoodAllInfo();
		}else {
			System.out.println("Sorry, we don't have this Food Item");
		}
	}
	
	protected void printAllFoodItems() {
		System.out.println("Food Name    "+"Food ID    "+"Price     "+ "Category     ");
		for(int i=0;i<RestaurantApp.foodList.size();i++) {
			if(RestaurantApp.foodList.get(i).isValid()) {
			   RestaurantApp.foodList.get(i).printFoodAllInfo();
			}
		}
	}
	
	
	//add a customer to a given Food Entry's customer_name_list
	//if we successfully add a customer to the given name list, return 1
	//Otherwise, return 0
	protected int addCustomer(String userName, String fName) {
		FoodEntry entry = locateEntryByName(fName);
		//if we find the entry
		
		if(entry != null && entry.isValid()) {
		   return entry.addCustomerName(userName);
		}
		return 0;
	}
	
	protected Seat findSeatById(String id) {
        for (Seat seat : RestaurantApp.seatList) {
            if (seat.getSeatId().equalsIgnoreCase(id)) {
                return seat;
            }
        }
        return null;
    }

    protected void printAllSeats() {
        for (Seat seat : RestaurantApp.seatList) {
            System.out.println("Table: " + seat.getSeatId() + ", Capacity: " + seat.getCapacity() +
            ", Reservable: " + seat.isReservable());
        }
    }

	protected void printAvailableSeats(String hour, int partySize) {
		System.out.println("Available tables for " + partySize + " people at " + hour + ":00:");
		for (Seat seat : RestaurantApp.seatList) {
			// filter by capacity and availability to get the available seats
			if (seat.isReservable() && seat.getCapacity() >= partySize && seat.isAvailableAt(hour)) {
				System.out.println(" - Table " + seat.getSeatId() + " (Capacity: " + seat.getCapacity() + ")");
			}
		}
	}
	
	protected boolean reserveSeat(String customerName, String seatId, String hour) {
		Seat seat = findSeatById(seatId);
		if (seat != null && seat.isAvailableAt(hour)) {
			seat.addReservation(new SeatReservation(customerName, hour));
			return true;
		}
		return false;
	}
	
	protected boolean cancelSeat(String seatId, String customerName, String hour) {
		Seat seat = findSeatById(seatId);
		if (seat != null) {
			return seat.removeReservation(customerName, hour);
		}
		return false;
	}
	
}
