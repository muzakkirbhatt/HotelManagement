
/** 
 *@author Muzakkir
*/
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class allows user to interact with the program. Along with the main
 * method it contains methods such as print menu, prompt user to enter input
 * etc.
 */
public class GuestApp {

	public static void main(String[] args) throws SQLException {
		GuestApp mainApp = new GuestApp();
		mainApp.runApp();
	}

	private boolean Exit = false;
	RestaurantResList resList = new RestaurantResList();
	ServiceList serviceList = new ServiceList();

	public void runApp() throws SQLException {
		while (!Exit) {
			printMenu();
			processMenuInput();
		}
	}

	public void printMenu() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nHello! Please Enter One of The following Options From The Menu: ");
		System.out.println("1) Room Service");
		System.out.println("2) Concierge Service");
		System.out.println("3) Airport Shuttle");
		System.out.println("4) Dining Package");
		System.out.println("5) Beverage Package");
		System.out.println("6) Luandry Package");
		System.out.println("7) Restaurant Reservation");
		System.out.println("8) Exit");
	}

	/**
	 * Processes the option chosen by user.
	 * 
	 * @throws SQLException
	 */
	private void processMenuInput() throws SQLException {
		int userInput = 0;

		try {
			while (userInput < 1 || userInput > 8) {

				userInput = Integer.parseInt(prompt());

				if (userInput < 1 || userInput > 8) {
					System.out.println("Invalid Entry! Please Enter A Valid Option From The Menu: ");
				}
			}

		} catch (NumberFormatException e) {

			System.out.print("Invalid Entry! Please Enter A Valid Option From The Menu Below ");
		}
		switch (userInput) {
		case 1:
			requestService(1);
			break;
		case 2:
			requestService(2);
			break;
		case 3:
			requestService(3);
			break;
		case 4:
			requestService(4);
			break;
		case 5:
			requestService(5);
			break;
		case 6:
			requestService(6);
			break;
		case 7:
			addRestaurant();
			break;
		case 8:
			Exit = true;
			System.out.println("Bye Bye!");
			break;

		}
	}

	private void requestService(int input) throws SQLException {
		int service_id = input;
		while (service_id <= 0) {
			System.out.println("Please Enter Service ID: ");
			service_id = Integer.parseInt(prompt());
			if (service_id <= 0) {
				System.out.println("Service ID cannot be 0!");
			}
		}
		int guestID = 1; //From account thats logged in
		while (guestID <= 0) {
			System.out.println("Please Enter Guest ID: ");
			guestID = Integer.parseInt(prompt());
			if (guestID <= 0) {
				System.out.println("Guest ID cannot be 0!");
			}
		}
		System.out.println("Please Enter Date in YYYY-MM-DD Format");
		String date = prompt();
		Service newService = new Service(service_id, guestID, date);
		serviceList.addService(newService);
	}

	private void addRestaurant() {
		int guestID = 0; //From account thats logged in
		while (guestID <= 0) {
			System.out.println("Please Enter Guest ID: ");
			guestID = Integer.parseInt(prompt());
			if (guestID <= 0) {
				System.out.println("Guest ID cannot be 0!");
			}
		}
		int tableNum = 0;
		while (tableNum <= 0) {
			System.out.println("Please Enter Table Number: ");
			tableNum = Integer.parseInt(prompt());
			if (tableNum <= 0) {
				System.out.println("Table Number cannot be 0!");
			}
		}
		int numGuests = 0;
		while (numGuests <= 0) {
			System.out.println("Please Enter Number of Guests: ");
			numGuests = Integer.parseInt(prompt());
			if (numGuests <= 0) {
				System.out.println("Number of Guests cannot be 0!");
			}
		}
		System.out.println("Please Enter Date in YYYY-MM-DD Format");
		String date = prompt();
		RestaurantReservationForm newReservation = new RestaurantReservationForm(guestID, tableNum, date, numGuests);
		resList.add(newReservation);
	}

	@SuppressWarnings("resource")
	private String prompt() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}