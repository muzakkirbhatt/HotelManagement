import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating, updating and managing Service list
 * 
 * @author Sara Aktar
 *
 */
public class JDBCServiceList {

	/** Host */
	public final String host = "jdbc:mysql://localhost:3306/hotel";

	/** User */
	public final String user = "root";

	/** Password */
	public final String password = "";

	private Connection conn;
	Statement stmt;

	public JDBCServiceList() {
		// connect to the database
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver Missing");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");

		try {
			conn = DriverManager.getConnection(host, user, password);
			stmt = conn.createStatement();
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * Adds a new Service into the Database
	 * 
	 * @param newService
	 *            The new service added to the Database
	 * @return Returns true if new service was added successfully, if not returns
	 *         false
	 */
	public boolean addService(Service newService) {
		int list_id = 0;
		int service_Id = newService.getId();
		double price = newService.getPrice();
		String date = newService.getDate();
		int guest_id = newService.getGuest_id();
		String sql = "INSERT INTO service_list (service_ID, service_name, service_price, guest_ID, date_requested) "
				+ "SELECT '" + service_Id + "', services.name, services.price, '" + guest_id + "', '" + date + "' "
				+ "FROM services " + "WHERE services.id = " + service_Id;

		// String sql = "INSERT INTO hotel.service_List (service_Id, service_name,
		// service_price, guest_Id, date_requested) "
		// + "VALUES ('" + service_Id + "', '" + price + "', '" + guest_id + "', '" +
		// date + "')";

		try {
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			list_id = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Insert failed");
			e.printStackTrace();
			return false;
		}
		System.out.println("Sucessfully Added. Your Service List ID is : " + list_id);
		return true;
	}

	/**
	 * Deletes selected Service from the Database
	 * 
	 * @param listID
	 *            The number that identifies the Service ID
	 * @return Returns true if service was deleted successfully, if not returns
	 *         false
	 */
	public Service deleteService(int listID) {
		Service service = new Service();
		String sql = "SELECT * FROM hotel.service_list WHERE list_ID = '" + listID + "'";
		String sql2 = "DELETE FROM hotel.service_list WHERE list_ID = '" + listID + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				service.setList_id(rs.getInt(1));
				service.setId(rs.getInt(2));
				service.setName(rs.getString(3));
				service.setPrice(rs.getDouble(4));
				service.setGuest_id(rs.getInt(5));
				service.setDate(rs.getString(3));
				System.out.println(service.toString());
			}

			stmt.executeUpdate(sql2);

		} catch (SQLException e) {
			System.out.println("Delete failed");
			e.printStackTrace();
			return service;
		}

		System.out.println("Sucessfully Deleted Service");
		return service;

	}

	/**
	 * Updates Service in the Database
	 * 
	 * @param ServiceID
	 *            The number that identifies the Service ID which needs to be
	 *            updates
	 * @param serviceUpdate
	 *            The service which need to be updated
	 * @return Returns true if Service was updated successfully, if not returns
	 *         false
	 */
	public boolean updateService(int ServiceID, Service serviceUpdate) {
		return false;
	}

	/**
	 * Searches the Database and Returns the Service Found
	 * 
	 * @param listID
	 *            The number that identifies the Service ID
	 * @return Returns the Service based on Service ID, if found.
	 */

	public Service searchService(int listID) throws SQLException {
		String sql = "SELECT * FROM hotel.service_list WHERE list_ID = '" + listID + "'";
		Service service = new Service();
		boolean found = false;

		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				service.setList_id(rs.getInt(1));
				service.setId(rs.getInt(2));
				service.setName(rs.getString(3));
				service.setPrice(rs.getDouble(4));
				service.setGuest_id(rs.getInt(5));
				service.setDate(rs.getString(3));
				found = true;
			}
			if (found) {
				System.out.println(service.toString());
			} else {
				System.out.println("No Service Found with Service ID " + listID + ".");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return service;
	}

	/**
	 * This method views the list of all Services in the Database
	 * 
	 * @return Returns a List of All Services in a Hashmap
	 */
	public List<Service> viewServices() {
		return null;
	}

}
