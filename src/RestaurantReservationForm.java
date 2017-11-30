import java.util.Date;

/**
 * The class RestaurantReservationForm has the responsibility for defining and
 * storing restaurant reservations
 *
 * @author Muzakkir
 * @version 1.0
 */
public class RestaurantReservationForm {

	int guest_id;
	int tableNum;
	String resDate;
	int RR_id;
	int numOfGuests;

	public RestaurantReservationForm() {

	}

	/**
	 * Constructor to create new instance of Restaurant Reservation Form
	 * 
	 * @param guest_id
	 *            An integer that identifies the guest.
	 * @param tableNum
	 *            An integer that identifies the table number where the guest will
	 *            sit.
	 * @param resDate
	 *            The date the guest makes a reservation for.
	 * @param RR_id
	 *            An integer that identifies the restaurant reservation.
	 * @param numOfGuest
	 *            An integer that identifies the number of guest that will be
	 *            attending the restaurant.
	 */

	public RestaurantReservationForm(int guest_id, int tableNum, String resDate, int numOfGuests) {
		this.guest_id = guest_id;
		this.tableNum = tableNum;
		this.resDate = resDate;
		this.numOfGuests = numOfGuests;
	}

	/**
	 * This method returns the guest id.
	 * 
	 * @return guest_id the number that identifies the guest.
	 */
	public int getGuest_id() {
		return guest_id;
	}

	/**
	 * This method sets guest id.
	 * 
	 * @param guest_id
	 *            the number that identifies the guest.
	 */
	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	/**
	 * This method returns the restaurant reservation table number.
	 * 
	 * @return tableNum the number that identifies the table.
	 */
	public int getTableNum() {
		return tableNum;
	}

	/**
	 * This method sets the table number.
	 * 
	 * @param tableNum
	 *            the number that identifies restaurant reservation table.
	 */
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	/**
	 * This method returns the restaurant reservation date.
	 * 
	 * @return resDate The restaurant reservation date.
	 */
	public String getResDate() {
		return resDate;
	}

	/**
	 * This method sets the restaurant reservation date.
	 * 
	 * @param resDate
	 *            The restaurant reservation date.
	 */
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	/**
	 * This method returns the restaurant reservation number.D
	 * 
	 * @return RR_id the number that identifies the restaurant reservation.
	 */
	public int getRR_id() {
		return RR_id;
	}

	/**
	 * This method sets the restaurant reservation id.
	 * 
	 * @param RR_id
	 *            The number that identifies the restaurant reservation id.
	 */
	public void setRR_id(int RR_id) {
		this.RR_id = RR_id;
	}

	/**
	 * This method returns the numOfGuest.
	 * 
	 * @return numOfGuest the number that identifies the number of guest that will
	 *         be seated.
	 */
	public int getNumOfGuests() {
		return numOfGuests;
	}

	/**
	 * This method sets numOfGuest.
	 * 
	 * @param numOfGuest
	 *            the number that identifies the number of guest that will be
	 *            seated.
	 */
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}

	@Override
	public String toString() {
		return "\nReservation Found [Guest ID: " + guest_id + ", Table Number: " + tableNum + ", Reservation Date: "
				+ resDate + ", Reservation ID: " + RR_id + ", Number of Guests: " + numOfGuests + "]";

	}

}