import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating, updating and managing Service list
 * storing Services
 * @author Sara Aktar
 * @version 1.0
 */
public class ServiceList {

	/** DB Connection */
	private JDBCServiceList db;

	/**
	 * This is a default constructor for the Service List.Its member variables will be set to default values.
	 */
	public ServiceList() {
			
		db = new JDBCServiceList();
		
	}

	/**
	 * Adds a new Service into the Database
	 * @param newService The new service added to the Database
	 * @return Returns true if new service was added successfully, if not returns false 
	 */
	public boolean addService(Service newService) {
		return db.addService(newService);
	}

	/**
	 * Deletes selected Service from the Database
	 * @param ServiceID The number that identifies the Service ID
	 * @return Returns true if service was deleted successfully, if not returns false 
	 */
	public Service deleteService(int listID) {
		return db.deleteService(listID);
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
	 * @param listID The number that identifies the Service ID
	 * @return Returns the Service based on Service ID, if found.
	 * @throws SQLException 
	 */
	public Service searchService(int listID) throws SQLException {
		return db.searchService(listID);
	}

	/**
	 * This method views the list of all Services in the Database
	 * @return Returns a List of All Services in a Hashmap
	 */
	public  List<Service> viewServices() {
		return null;
	}
}
