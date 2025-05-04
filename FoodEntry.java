
import java.util.ArrayList;
import java.util.*;

abstract class FoodObject{
	
    String foodName;
    String foodId;
    double price;
    String category;
	
	
	abstract void printCustomerName();
	abstract int addCustomerName(String name);
	abstract int deleteCustomerName(String fullName);
	abstract boolean findGivenCustomer(String fullName);
}

public class FoodEntry extends FoodObject {

	private String foodName;
	private String foodId;
	private double price;
	private String category;
	private ArrayList<String> customer_name_list = new ArrayList<>();

	
	//constructor
	public FoodEntry(String fn, String id, double p, String category, ArrayList<String> name_list) {
		this.foodName = fn;
		this.foodId = id;
		this.price = p;
		this.category = category;
		this.customer_name_list = name_list;
	}
	
	
	//default value of the FoodEntry object
	public FoodEntry() {
		this.foodName = "";
		this.foodId = "";
        this.price = 0;
        this.category = "";
		this.customer_name_list = new ArrayList<String>();
	
	}
	
	public String getFoodName() {
		return this.foodName;
	}
	
	public void setFoodName(String fn) {
		this.foodName = fn;
	}
	
	public String getFoodId() {
		return this.foodId;
	}
	
	public void setFoodId(String id) {
		this.foodId = id;
	}
	
	
	public double getPrice() {
		return this.price;
	}
	
	public int setPrice(double price) {
		if(price > 0) {
			this.price = price;
			return 1;
		}
		return 0;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String cg) {
		this.category = cg;
	}

	
	public ArrayList<String> getCustomer_name_list() {
		return customer_name_list;
	}
	
	public void setStudent_name_list(ArrayList<String> ary) {
		customer_name_list = ary;
	}
	
	//print all customer name in the name list
	public void printCustomerName() {
		for(int i=0; i<customer_name_list.size();i++) {
			System.out.print(customer_name_list.get(i)+"\t");
		}
	}
	
	// add a new customer name
	// return 1 if the system successfully added a valid name
	public int addCustomerName(String name) {
		//we need to create a empty arrayList to avoid NullPointer Exception
		if(customer_name_list == null) {
			this.customer_name_list = new ArrayList<String>();
		}
		if(name != null) {
			customer_name_list.add(name);
			return 1;
		}
		return 0;
	}

    //delete a customer name from the name list
	//if we find the customer name that needed to be delete, return 1;
	//if the name does not found, return 0;
	public int deleteCustomerName(String fullName) {
		if(this.customer_name_list== null || this.customer_name_list.size()==0) {
			System.out.println("You can't delete the customer name, because there's no customer ordered this Food item.");
			return 0;
		}
		for(int i=0;i< customer_name_list.size();i++) {
			if(customer_name_list.get(i).equalsIgnoreCase(fullName)) {
				customer_name_list.remove(i);
				return 1;
			}
		}
		return 0;
	}
	

	
	//return true if a given student name is in the course entry
	public boolean findGivenCustomer(String fullName) {
		if(fullName != null) {
			for(int i=0; i<customer_name_list.size(); i++) {
				if (fullName.equalsIgnoreCase(customer_name_list.get(i)))
				{
					return true;
				}
		    }
			
		}
		return false;
	}

	public void printFoodEntry() {
		System.out.println(foodName+"\t"+"$"+price+ "\t");
	}
	
	
	public void printFoodAllInfo() {
		System.out.println(foodName+"\t"+foodId+ "\t" + 
				price +"\t"+ category);
		
	}

	
	//check food item by ID
	public boolean sameFoodId(String a) {
		if(foodId.equalsIgnoreCase(a)) {
			return true;
		}
		return false;
	}
	
	//check food item by foodName
	public boolean sameFoodName(String fname) {
		if(this.foodName.equalsIgnoreCase(fname)) {
			return true;
		}
		return false;
	}
	
	
	// return a string representation of the object
	public String toString() {
		return foodName+"\t"+foodId+ "\t" + price+ "\t" 
				+ category +"\t"+ customer_name_list + "\t";
			
		}
	
	
	public boolean isValid() {
		if(foodName != null) {
			return true;
		}else {
			return false;
		}
	}
}
	
