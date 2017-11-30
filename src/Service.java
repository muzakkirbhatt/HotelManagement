import java.util.Date;

/**
 * The class Service has the responsibility for defining and storing all the Services of the Hotel Management System
 * @author Sara Aktar
 * @version 1.0
 */
public class Service {

	double price;

	String name;

	Date date;

	int id;

	int guest_id;

	/**
	 * This is a default constructor for the Service.Its member variables will be set to default values.
	 */
	public Service() {

	}

	/**
	 * Non-default Constructor to create new instance of Service where the parameter is Date and Guest ID.
	 * 
	 * @param date The date the guest makes a Service request for.
	 * @param guest_id The number that identifies the Guest
	 */
	public Service(Date date, int guest_id) {
		this.date = date;
		this.guest_id = guest_id;

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
	public Date getDate() {
		return date;
	}

	/**
	 * Mutator used to set the Date instance variable
	 * @param date The Service request Date
	 */
	public void setDate(Date date) {
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

}
