import java.util.Date;

/**
 * The class Service has the responsibility for defining and storing all the Services of the Hotel Management System
 * @author Sara Aktar
 * @version 1.0
 */
public class Service {

	int list_id;
	
	int id;
	
	String name;
	
	double price;

	int guest_id;
	
	String date;

	/**
	 * This is a default constructor for the Service.Its member variables will be set to default values.
	 */
	public Service() {

	}
	
	public Service(int service_id, int guest_id, String date_requested) {
		this.id = service_id;
		this.guest_id = guest_id;
		this.date = date_requested;
	}
	
	 public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	/**
	  * This is Accessor used to Obtain Price of the Service 
	  * @return The price of the Service 
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Mutator used to set the Price instance variable
	 * @param price The price of the Service requested
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Accessor used to Obtain the Service requester's name
	 * @return This returns the Name tied to the Service
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator used to set the Name instance variable
	 * @param name The name of the Service Requested
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor used to Obtain the Date when the service was requested
	 * @return the service date when it was requested
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Mutator used to set the Date instance variable
	 * @param date The Service request Date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Accessor used to Obtain the Service ID
	 * @return the service ID tied to the Service
	 */
	public int getId() {
		return id;
	}

	/**
	 * Mutator used to set the Service ID instance variable
	 * @param id The number that identifies the Service.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Accessor used to Obtain the Guest ID
	 * @return the guestID tied to the Account
	 */
	public int getGuest_id() {
		return guest_id;
	}

	/**
	 * Mutator used to set the guestID instance variable
	 * @param guest_id The number that identifies the Guest
	 */
	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	@Override
	public String toString() {
		return "\n[List ID: " + list_id + ", Service ID: " + id + ", Service Name: " + name + ", Service Price: " + price + ", Guest ID: "
				+ guest_id + ", Date Requested: " + date + "]\n";
	}

	
	
	
}
