import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible for creating, updating and managing restaurant
 * reservation list storing restaurant reservations
 * 
 * @author Muzakkir
 * @version 1.0
 */
public class RestaurantResList {

	/** DB Connection */
	private JDBCRestaurantResList db;

	public RestaurantResList() {
		db = new JDBCRestaurantResList();
	}

	/**
	 * Adds a new Restaurant Reservation into the Database
	 * 
	 * @param New
	 *            Restaurant Reservation Form
	 * @return Returns true if new reservation was added successfully, if not
	 *         returns false
	 */
	public boolean add(RestaurantReservationForm newReservation) {
		return db.add(newReservation);
	}

	/**
	 * Deletes selected Restaurant Reservation from the Database
	 * 
	 * @param Reservation
	 *            ID
	 * @return Returns true if reservation was deleted successfully, if not returns
	 *         false
	 */
	public RestaurantReservationForm deleteReservation(int reservationID) {
		return db.deleteReservation(reservationID);
	}

	/**
	 * Updates Restaurant Reservation in the Database
	 * 
	 * @param Reservation
	 *            ID and the reservation form that needs to be updated
	 * @return Returns true if reservation was updated successfully, if not returns
	 *         false
	 */
	public boolean updateReservation(int reservationID, RestaurantReservationForm updateRes) {
		return db.updateReservation(reservationID, updateRes);
	}

	/**
	 * Search for a reservation
	 * 
	 * @param Reservation
	 *            ID
	 * @return Returns the Restaurant Reservation based on Reservation ID, if found.
	 * @throws SQLException
	 */
	public RestaurantReservationForm searchReservation(int reservationID) throws SQLException {
		return db.searchReservation(reservationID);
	}

	/**
	 * List of all the Restaurant Reservations
	 * 
	 * @param Reservation
	 *            ID
	 * @return Returns a List of All Restaurant Reservations
	 * @throws SQLException
	 */
	public List<RestaurantReservationForm> viewResReservation() throws SQLException {
		return db.viewResReservations();
	}

}
