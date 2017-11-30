import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.*;

/**
 * Class name: ReservationList Class Description: This class adds, searches,
 * removes, updates, and views the ReservationList.
 *
 *
 */

/**
 * This class is responsible for creating, updating and managing restaurant
 * reservation list
 * 
 * @author Muzakkir
 * @version 1.0
 *
 */
public class JDBCRestaurantResList {

	private Connection conn;
	Statement stmt;

	public JDBCRestaurantResList(String host, String user, String pass) {
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
			conn = DriverManager.getConnection(host, user, pass);
			stmt = conn.createStatement();
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
	}

	List<RestaurantReservationForm> restaurantResList = new ArrayList<RestaurantReservationForm>();

	/**
	 * Adds a new Restaurant Reservation into the Database
	 * 
	 * @param New
	 *            Restaurant Reservation Form
	 * @return Returns true if new reservation was added successfully, if not
	 *         returns false
	 */
	public boolean add(RestaurantReservationForm newReservation) {
		int guest_id = newReservation.getGuest_id();
		int tableNum = newReservation.getTableNum();
		String resDate = newReservation.getResDate();
		int RR_id = newReservation.getRR_id();
		int numGuests = newReservation.getNumOfGuests();

		// System.out.println("RestaurantReservationForm [guest_id=" + guest_id + ",
		// tableNum=" + tableNum + ", resDate="
		// + resDate + ", RR_id=" + RR_id + ", numGuests=" + numGuests + "]");

		String sql = "INSERT INTO hotel.restaurant_reservation_list (tableNum, numGuests, date, guestID) VALUES ('"
				+ tableNum + "', '" + numGuests + "', '" + resDate + "', " + guest_id + ")";
		try {
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			RR_id = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Insert failed");
			e.printStackTrace();
			return false;
		}

		System.out.println("Sucessfully Added. Your Reservervation ID is : " + RR_id);
		return true;
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
		RestaurantReservationForm form = new RestaurantReservationForm();
		String sql = "SELECT * FROM hotel.restaurant_reservation_list WHERE id = '" + reservationID + "'";
		String sql2 = "DELETE FROM hotel.restaurant_reservation_list WHERE id = '" + reservationID + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				form.setRR_id(rs.getInt(1));
				form.setTableNum(rs.getInt(2));
				form.setNumOfGuests(rs.getInt(3));
				form.setResDate(rs.getString(4));
				form.setGuest_id(rs.getInt(5));
				System.out.println(form.toString());
			}

			stmt.executeUpdate(sql2);

		} catch (SQLException e) {
			System.out.println("Delete failed");
			e.printStackTrace();
			return form;
		}

		System.out.println("Sucessfully Deleted Reservervation");
		return form;
	}

	/**
	 * Updates Restaurant Reservation in the Database
	 * 
	 * @param Reservation
	 *            ID and the reservation form that needs to be updated
	 * @return Returns true if reservation was updated successfully, if not returns
	 *         false
	 */
	public boolean updateReservation(int reservationID, RestaurantReservationForm newRes) {
		String sql = "UPDATE hotel.restaurant_reservation_list" + " SET tableNum =" + "'" + newRes.getTableNum() + "'"
				+ ", numGuests =" + "'" + newRes.getNumOfGuests() + "'" + ", date =" + "'" + newRes.getResDate() + "'"
				+ "WHERE id = " + reservationID;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Update failed");
			e.printStackTrace();
			return false;
		}
		System.out.println("Sucessfully Updated Reservervation");
		return true;
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

		String sql = "SELECT * FROM hotel.restaurant_reservation_list WHERE id = '" + reservationID + "'";
		RestaurantReservationForm form = new RestaurantReservationForm();
		boolean found = false;

		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				form.setRR_id(rs.getInt(1));
				form.setTableNum(rs.getInt(2));
				form.setNumOfGuests(rs.getInt(3));
				form.setResDate(rs.getString(4));
				form.setGuest_id(rs.getInt(5));
				found = true;
			}
			if (found) {
				System.out.println("Reservation Found [Guest ID: " + form.getGuest_id() + ", Table Number: "
						+ form.getTableNum() + ", Reservation Date: " + form.getResDate() + ", Reservation ID: "
						+ form.getRR_id() + ", Number of Guests: " + form.getNumOfGuests() + "]");
			} else {
				System.out.println("No Reservation Found with Reservation ID " + reservationID + ".");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;
	}

	/**
	 * List of all the Restaurant Reservations
	 * 
	 * @param Reservation
	 *            ID
	 * @return Returns a List of All Restaurant Reservations
	 * @throws SQLException
	 */
	public List<RestaurantReservationForm> viewResReservations() throws SQLException {
		List<RestaurantReservationForm> list = new ArrayList<RestaurantReservationForm>();
		String sql = "SELECT * FROM hotel.restaurant_reservation_list";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			RestaurantReservationForm form = new RestaurantReservationForm();
			form.setRR_id(rs.getInt(1));
			form.setTableNum(rs.getInt(2));
			form.setNumOfGuests(rs.getInt(3));
			form.setResDate(rs.getString(4));
			form.setGuest_id(rs.getInt(5));
			list.add(form);
		}

		return list;
	}

}
