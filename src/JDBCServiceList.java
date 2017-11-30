import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating, updating and managing Service list 
 * @author Sara Aktar
 *
 */
public class JDBCServiceList {
	public List<Service> serviceList = new ArrayList<Service>();

	/**
	 * This is a default constructor for the JDBCServiceList.Its member variables will be set to default values.
	 */
	public JDBCServiceList() {

	}

	/**
	 * Adds a new Service into the Database
	 * @param newService The new service added to the Database
	 * @return Returns true if new service was added successfully, if not returns false 
	 */
	public boolean addService(Service newService) {
		return false;
	}

	/**
	 * Deletes selected Service from the Database
	 * @param ServiceID The number that identifies the Service ID
	 * @return Returns true if service was deleted successfully, if not returns false 
	 */
	public boolean deleteService(int ServiceID) {
		return false;
	}

	/**
	 * Updates Service in the Database
	 * @param ServiceID The number that identifies the Service ID which needs to be updates
	 * @param serviceUpdate The service which need to be updated
	 * @return Returns true if Service was updated successfully, if not returns false
	 */
	public boolean updateService(int ServiceID, Service serviceUpdate) {
		return false;
	}

	/**
	 * Searches the Database and Returns the Service Found
	 * @param ServiceID The number that identifies the Service ID
	 * @return Returns the Service based on Service ID, if found.
	 */
	public Service searchService(int ServiceID) {
		return null;
	}

	/**
	 * This method views the list of all Services in the Database
	 * @return Returns a List of All Services in a Hashmap
	 */
	public  List<Service> viewServices() {
		return null;
	}

}
