
import java.util.ArrayList;


interface UserInterface{
	public void viewFoodMenu();
	public void viewOrderedFoods();
	public boolean isValid();
	public boolean sameUserName(String un);
	
}


public class User implements UserInterface{
	
	protected String phone;
	protected String email;
	protected String username;
	protected SystemDirectory directory;
	
	
	//Constructor for this class
	public User(String un, String ph, String email) {
		this.username = un;
		this.phone = ph;
		this.email = email;
		directory = new SystemDirectory();
		
	}
		
	
	//default constructor
	public User() {
		directory = new SystemDirectory();
	}

	
	//setter and getter 
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhoneNumber() {
		return phone;
	}


	public void setPhoneNumber(String ph) {
		this.phone = ph;
	}


	public String getEmail() {
		return this.email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	


	public void viewFoodMenu() {
		System.out.println("Display information of all Food Menu Items: \n");
		directory.printAllFoodItems();
		
	}
	
	
	
    public void viewOrderedFoods() {
			// implementation of this method is in the Admin and customer class
			}

    
    public boolean isValid() {
    	if(username != null) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean sameUserName(String un) {
    	if(this.username.equals(un)) {
    		return true;
    	}
    	return false;
    }				
}
